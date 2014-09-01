import java.time.Instant;

import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Plane;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.PointLight;
import Raytracer.Materials.Checkered;
import Raytracer.Materials.FlatColor;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;
import Raytracer.Swing.JRaytracer;

public class Program {
	public static void main(String[] args){
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)", 1280, 720);

		Camera cam = new Camera(new Vec3(0,7,-5), Vec3.FORWARD, Vec3.UP, 60);
		
		// Geometry
		Sphere sphere 	= new Sphere(new Vec3(0,7,20), 7, Checkered.WHITE_RED);
		Sphere sphere2 	= new Sphere(new Vec3(-20, 5, 30), 5, FlatColor.MAGNETA);
		Plane plane 	= new Plane(Vec3.ZERO, Vec3.UP, Checkered.LARGE_YELLOW_GREEN);
		
		// Lights
		PointLight light 	= new PointLight(new Vec3(0,50,0), Color.WHITE);
		PointLight light2	= new PointLight(new Vec3(0,20,-50), Color.WHITE);
	
		Scene scene = new Scene();
		scene.addGeometry(sphere, sphere2, plane);
		scene.addLight(light, light2);
		
		Debug.Write(Instant.now());
		
		scene.setBGMaterial(FlatColor.BLACK);
		raytracer.render(scene, cam);
	}

}
