package Raytracer.Core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Geometry;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.Light;
import Raytracer.Materials.Material;

public class Scene implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;
	
	public ArrayList<Geometry> 	geomList;
	public ArrayList<Light>		lightList;
	
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
	
	public ArrayList<Geometry> getGeometry() {
		return geomList;
	}
	
	public ArrayList<Light> getLights(){
		return lightList;
	}
	
	public void addGeometry(Collection<Geometry> collection){
		for (Geometry geom : collection){
			geomList.add(geom);
		}
	}
	
	public void addGeometry(Geometry...geom){
		for (Geometry geometry : geom){
			geomList.add(geometry);
		}
	}
	
	public void addLight(Collection<Light> collection){
		for (Light light : collection){
			lightList.add(light);
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
