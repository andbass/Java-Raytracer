import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Geometry.Plane;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.PointLight;
import Raytracer.Materials.Checkered;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Material;
import Raytracer.Materials.Metal;
import Raytracer.Materials.Texture;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;


public class ExampleScenes {
	public static final Scene TWO_SPHERES_PLANE = new Scene();
	private static final Camera TWO_SPHERES_PLANE_CAMERA = new Camera(new Vec3(0,7,-5), Vec3.FORWARD, Vec3.UP, 60);
	
	public static final Scene EARTH = new Scene();
	private static final Camera EARTH_CAMERA = new Camera(Vec3.ZERO, Vec3.FORWARD, Vec3.UP, 60);
	
	private static HashMap<Scene, Camera> cameraMap = new HashMap<Scene, Camera>();
	
	static public Camera getCamera(Scene scene){
		return cameraMap.get(scene);
	}
	
	static {
		// TWO_SPHERES_PLANE	
		// Geometry
		Sphere sphere 	= new Sphere(new Vec3(0,7,20), 7, Metal.GOLD);
		Sphere sphere2 	= new Sphere(new Vec3(-20, 5, 30), 5, FlatColor.MAGNETA);
		Plane plane 	= new Plane(Vec3.ZERO, Vec3.UP, Checkered.LARGE_YELLOW_GREEN);
		
		// Lights
		PointLight light 	= new PointLight(new Vec3(0,50,0), Color.WHITE);
		PointLight light2	= new PointLight(new Vec3(0,20,-50), Color.WHITE);

		TWO_SPHERES_PLANE.addGeometry(sphere, sphere2, plane);
		TWO_SPHERES_PLANE.addLight(light, light2);
		
		cameraMap.put(TWO_SPHERES_PLANE, TWO_SPHERES_PLANE_CAMERA);
		// END TWO_SPHERES_PLANE
		
		// EARTH	
		// Materials
		Texture earthTexture = new Texture("resources/earth_day.jpg");
		earthTexture.setShininess(5);
		earthTexture.setSpecular(Color.GREY);
		
		Texture moonTexture = new Texture("resources/moon.jpg");
		
		// Geometry
		Sphere planet = new Sphere(new Vec3(0,0,80), 25, earthTexture);
		Sphere planet2 = new Sphere(new Vec3(-50,50,120), 10, moonTexture);
		
		// Lights
		PointLight sun = new PointLight(new Vec3(0,5,10), Color.WHITE);
		
		EARTH.addGeometry(planet, planet2);
		EARTH.addLight(sun);
		
		cameraMap.put(EARTH, EARTH_CAMERA);
		// END EARTH
	}
}
