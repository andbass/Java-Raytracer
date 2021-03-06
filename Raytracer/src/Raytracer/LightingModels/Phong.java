package Raytracer.LightingModels;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Core.Camera;
import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Math.Vec3;

public class Phong extends LightingModel {
	
	private int maxReflectiveIndex = 5;
	
	public Phong(){
		this(FlatColor.BLACK);
	}
	
	public Phong(Material mat){
		super(mat);
	}
	
	public Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords) {
		if (!result.hit){
			return bgMaterial.getDiffuse(screenCoords);
		}
		return getObjectColor(result, scene, camera);
	}
		
	private Color getObjectColor(RaycastResult result, Scene scene, Camera cam) {
		
		List<Geometry> tempGeomList = new ArrayList<Geometry>(scene.geomList);
		
		Color pointColor = Color.BLACK;

		Vec3 hitPoint = result.hitPoint;
		Geometry hitObj = result.hitObject;
		scene.geomList.remove(hitObj);
		
		Color objDiffuse = hitObj.getDiffuse(hitPoint);
		Color objSpecular = hitObj.getSpecular(hitPoint);
		Color objAmbient = hitObj.getAmbient(hitPoint);
		
		Material mat = hitObj.getMaterial();
		
		Vec3 normal = hitObj.getNormal(hitPoint);
		
		for (Light light : scene.lightList){
			Vec3 pointToLight = light.getDir(hitPoint);
			double distToLight = hitPoint.dist(light.getPos());
			
			Ray shadowRay = new Ray(hitPoint, pointToLight);
			
			RaycastResult shadowResult = scene.raycast(shadowRay);
			
			if (!shadowResult.hit || shadowResult.distance > distToLight){
				Color lightDiffuseIntensity = light.getDiffuse().descale(255);
				
				// Diffuse
				double lambTerm = Math.max(normal.dot(pointToLight),0);
				
				Color scaledDiffuse = objDiffuse.scale(lambTerm);
				scaledDiffuse = scaledDiffuse.mul(lightDiffuseIntensity);
				
				pointColor = pointColor.add(scaledDiffuse);
				
				// Specular
				Vec3 reflectedLightDir = pointToLight.reflect(normal);
				Vec3 pointToCam = cam.getPos().sub(hitPoint).normalize();
				
				double cosAngle = Math.max(reflectedLightDir.dot(pointToCam), 0);
				double specTerm = Math.pow(cosAngle, mat.getShininess(hitPoint));
				
				Color filter = Color.WHITE.sub(scaledDiffuse).descale(255);
				Color scaledSpecular = objSpecular.scale(specTerm);
				scaledSpecular = scaledSpecular.mul(filter);
				
				pointColor = pointColor.add(scaledSpecular);
				
			}
		}

		scene.geomList = tempGeomList;
		return pointColor.add(objAmbient);	
	}
}
