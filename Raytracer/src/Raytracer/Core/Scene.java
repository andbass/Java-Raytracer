package Raytracer.Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Geometry;
import Raytracer.Lights.Light;
import Raytracer.Materials.Material;

public class Scene implements Serializable {

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
		try {
			FileOutputStream fileOutput = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOutput);
			
	        out.writeObject(this);
	        out.close();
	        fileOutput.close();

			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static Scene load(String filePath){
		Scene scene = new Scene("Failed to load scene");
		
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			scene = (Scene)objIn.readObject();
			
			fileIn.close();
			objIn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return scene;
	}
}
