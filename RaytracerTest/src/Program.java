import Raytracer.*;
import Raytracer.Geometry.*;
import Raytracer.Lights.*;
import Raytracer.Math.*;
import Raytracer.Swing.JRaytracer;

public class Program {
	
	// It should be noted that the coordinate system is left handed.
	// This changes how camera rays are calculated (since the cross product formula used is
	// different compared to the right handed system).  Bare this in mind when determining
	// the camera's up vector.
	
	public static void main(String[] args){
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)", 640, 480);
		
		Camera cam = new Camera(Vec3.ZERO, new Vec3(0,0,1), new Vec3(0,1,0), 60);
		
		Sphere sphere = new Sphere(new Vec3(0,0,20), 7, Color.WHITE, Color.WHITE, 0.01);
		PointLight light = new PointLight(new Vec3(0,25,-5), Color.WHITE);
		
		Scene scene = new Scene();
		scene.addGeometry(sphere);
		scene.addLight(light);
		
		raytracer.render(scene, cam);
	}
	
	
}
