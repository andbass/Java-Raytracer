import Raytracer.*;
import Raytracer.Geometry.*;
import Raytracer.Lights.*;
import Raytracer.Math.*;
import Raytracer.Shaders.*;
import Raytracer.Swing.*;

public class Program {
	
	// It should be noted that the coordinate system is left handed.
	// This changes how camera rays are calculated (since the cross product formula used is
	// different compared to the right handed system).  Bare this in mind when determining
	// the camera's up vector.
	
	public static void main(String[] args){
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)", 1280, 720);

		Camera cam = new Camera(Vec3.ZERO, new Vec3(0,0,1), new Vec3(0,1,0), 60);
		
		Sphere sphere = new Sphere(new Vec3(0,0,20), 7, Color.WHITE, Color.WHITE, 0.01);
		PointLight light = new PointLight(new Vec3(0,25,-5), Color.WHITE);
		
		Scene scene = new Scene();
		scene.addGeometry(sphere);
		scene.addLight(light);
		
//		scene.setBGColorCalc(new BGCalc());
		raytracer.render(scene, cam);
	}
}

class BGShader implements Shader {
	public Color shade(Scene scene, RaycastResult result, double x, double y){
		return Color.RED;
	}
}
