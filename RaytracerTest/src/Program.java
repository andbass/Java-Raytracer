import Raytracer.Core.*;
import Raytracer.Debugging.*;
import Raytracer.Geometry.*;
import Raytracer.BRDFs.*;
import Raytracer.Lights.*;
import Raytracer.Materials.*;
import Raytracer.Math.*;
import Raytracer.Sampling.*;
import Raytracer.Swing.*;

public class Program {
	public static void main(String[] args) throws InterruptedException{

		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(FlatColor.BLACK),
											 new Poseidon(4, 0.25));

		Camera cam = new Camera(new Vec3(0,7,-5), Vec3.FORWARD, Vec3.UP, 60);
		
		// Material
		Checkered reflectiveSurface = new Checkered(1000, Color.WHITE, Color.DARK_BLUE);
		reflectiveSurface.setReflectivity(5);
		
		// Geometry
		Sphere sphere 	= new Sphere(new Vec3(0,7,20), 7, Checkered.WHITE_RED);
		Sphere sphere2 	= new Sphere(new Vec3(-20, 5, 30), 5, FlatColor.MAGNETA);
		Plane plane 	= new Plane(Vec3.ZERO, Vec3.UP, reflectiveSurface);

		// Lights
		PointLight light 	= new PointLight(new Vec3(0,50,0), Color.WHITE);
		PointLight light2	= new PointLight(new Vec3(0,20,-50), Color.WHITE);
	
		Scene scene = new Scene();
		scene.addGeometry(sphere, sphere2, plane);
		scene.addLight(light, light2);

		Debug.LOG.start("Test render");
		raytracer.render(scene, cam);
		Debug.LOG.end();
		
		
		Debug.writeLog();
	}

}
