package Raytracer;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Scene {
	private List<Geometry> 	geomList;
	private List<Light>		lightList;
	
	public Scene(){
		geomList = new ArrayList<Geometry>();
		lightList = new ArrayList<Light>();
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

	public Color getColor(RaycastResult result, double x, double y){
		if (!result.hit){
			return getBGColor(x, y);
		}
		return getObjectColor(result, x, y);
	}
	
	protected Color getObjectColor(RaycastResult result, double x, double y){
		Color pointColor = Color.BLACK;

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
	
	protected Color getBGColor(double x, double y){
		return Color.OFF_WHITE;
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
}
