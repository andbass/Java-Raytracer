package Raytracer;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;
import Raytracer.Shaders.DefaultBGShader;
import Raytracer.Shaders.Shader;

public class Scene {
	private List<Geometry> 	geomList;
	private List<Light>		lightList;
	private Shader 			bgShader;

	public Scene(){
		this(new DefaultBGShader());
	}
	
	public Scene(Shader shader){
		geomList = new ArrayList<Geometry>();
		lightList = new ArrayList<Light>();
		bgShader = shader;
	}
	
	public RaycastResult raycast(Ray ray){
		double minDist = Double.MAX_VALUE;
		RaycastResult closestResult = RaycastResult.FAILURE;
		
		for (Geometry geom : geomList){
			RaycastResult result = geom.collide(ray);
			if (result.hit && result.distance < minDist){
				minDist = result.distance;
				closestResult = result;
			}
		}
		return closestResult;
	}

	public Color getColor(RaycastResult result){
		return getColor(result, 0, 0);
	}
	
	public Color getColor(RaycastResult result, double x, double y){
		Color pointColor = Color.BLACK;
		if (!result.hit){
			return bgShader.shade(this, result, x, y);
		}
		Vec3 hitPoint = result.hitPoint;
		Geometry hitObj = result.hitObject;
		Color objDiffuse = hitObj.getDiffuse(hitPoint);
		
		Vec3 normal = hitObj.getNormal(hitPoint);
		
		for (Light light : lightList){
			Vec3 pointToLight = light.getDir(hitPoint);
			double lambTerm = Math.max(normal.dot(pointToLight),0);
			Color scaledDiffuse = objDiffuse.scale(lambTerm);
			pointColor = pointColor.add(scaledDiffuse);
		}
		return pointColor;	
	}
	
	public List<Geometry> getGeometry() {
		return geomList;
	}
	
	public List<Light> getLights(){
		return lightList;
	}
	
	public void addGeometry(Geometry geom){
		geomList.add(geom);
	}
	
	public void addLight(Light light){
		lightList.add(light);
	}
	
	public void setBGShader(Shader shader){
		this.bgShader = shader;
	}
	
}
