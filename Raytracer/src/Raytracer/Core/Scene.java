package Raytracer.Core;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Math.Vec3;

public class Scene {
	private List<Geometry> 	geomList;
	private List<Light>		lightList;
	
	private Material		bgMaterial;
	
	public Scene(){
		geomList = new ArrayList<Geometry>();
		lightList = new ArrayList<Light>();
	}
	
	public RaycastResult raycast(Ray ray){
		double minDist = Double.MAX_VALUE;
		RaycastResult closestResult = RaycastResult.FAILURE;
		
		for (Geometry geom : geomList){
			RaycastResult result = geom.collide(ray);
			Debug.raysCasted++;
			if (result.hit && result.distance < minDist){
				minDist = result.distance;
				closestResult = result;
			}
		}
		return closestResult;
	}

	public Color getColor(RaycastResult result, Camera camera, Vec2 screenCoords){
		if (!result.hit){
			return bgMaterial.getDiffuse(screenCoords);
		}
		return getObjectColor(result, camera);
	}
	
	protected Color getObjectColor(RaycastResult result, Camera camera){
		List<Geometry> tempGeomList = new ArrayList<Geometry>(geomList);
		
		Color pointColor = Color.BLACK;

		Vec3 hitPoint = result.hitPoint;
		Geometry hitObj = result.hitObject;
		geomList.remove(hitObj);
		
		Color objDiffuse = hitObj.getDiffuse(hitPoint);
		Color objSpecular = hitObj.getSpecular(hitPoint);
		Color objAmbient = hitObj.getAmbient(hitPoint);
		
		Material mat = hitObj.getMaterial();
		
		Vec3 normal = hitObj.getNormal(hitPoint);
		
		for (Light light : lightList){
			Vec3 pointToLight = light.getDir(hitPoint);
			double distToLight = hitPoint.dist(light.getPos());
			
			Ray shadowRay = new Ray(hitPoint, pointToLight);
			
			RaycastResult shadowResult = this.raycast(shadowRay);
			
			if (!shadowResult.hit || shadowResult.distance > distToLight || shadowResult.hitObject == hitObj){
				Color lightDiffuseIntensity = light.getDiffuse().descale(255);
				
				// Diffuse
				double lambTerm = Math.max(normal.dot(pointToLight),0);
				
				Color scaledDiffuse = objDiffuse.scale(lambTerm);
				scaledDiffuse = scaledDiffuse.mul(lightDiffuseIntensity);
				
				pointColor = pointColor.add(scaledDiffuse);
				
				// Specular
				Vec3 reflectedLightDir = pointToLight.reflect(normal);
				Vec3 pointToCam = camera.getPos().sub(hitPoint).normalize();
				
				double cosAngle = Math.max(reflectedLightDir.dot(pointToCam), 0);
				double specTerm = Math.pow(cosAngle, mat.getShininess(hitPoint));
				
				Color filter = Color.WHITE.sub(scaledDiffuse).descale(255);
				Color scaledSpecular = objSpecular.scale(specTerm);
				scaledSpecular = scaledSpecular.mul(filter);
				
				pointColor = pointColor.add(scaledSpecular);
			}
		}

		geomList = tempGeomList;
		return pointColor.add(objAmbient);	
	}
	
	public void setBGMaterial(Material mat) { bgMaterial = mat; }
	
	protected Material getBGMaterial(){
		return bgMaterial;
	}
	
	public List<Geometry> getGeometry() {
		return geomList;
	}
	
	public List<Light> getLights(){
		return lightList;
	}
	
	public void addGeometry(Geometry...geom){
		for (Geometry geometry : geom){
			geomList.add(geometry);
		}
	}
	
	public void addLight(Light...lights){
		for (Light light : lights){
			lightList.add(light);
		}
	}
}
