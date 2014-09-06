package Raytracer.Core;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Materials.Material;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Scene {
	public String name;
	
	public List<Geometry> 	geomList;
	public List<Light>		lightList;
	
	private Material		bgMaterial;
	
	public Scene(String name){
		this.name = name;
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
	
	public void save(String filePath){
		
	}
}
