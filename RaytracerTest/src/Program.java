import Raytracer.Core.*;
import Raytracer.Debugging.*;
import Raytracer.Geometry.*;
import Raytracer.Lights.*;
import Raytracer.Materials.*;
import Raytracer.Math.*;
import Raytracer.Sampling.*;
import Raytracer.Swing.*;

public class Program {
	public static void main(String[] args){

		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Poseidon(4, 0.1));

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

		scene.setBGMaterial(FlatColor.BLACK);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, cam);
		Debug.LOG.end();
		
		Debug.writeLog();
	}

}
