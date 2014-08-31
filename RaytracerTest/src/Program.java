import Raytracer.Core.*;
import Raytracer.Geometry.*;
import Raytracer.Lights.*;
import Raytracer.Materials.*;
import Raytracer.Math.*;
import Raytracer.Swing.*;

public class Program {
	public static void main(String[] args){
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)", 1280, 720);

		Camera cam = new Camera(Vec3.ZERO, new Vec3(0,0,1), new Vec3(0,1,0), 60);
		
		// Geometry
		Sphere sphere = new Sphere(new Vec3(0,0,20), 7, Checkered.WHITE_RED);
		Sphere sphere2 = new Sphere(new Vec3(-20, -2, 30), 5, FlatColor.MAGNETA);
		
		// Lights
		PointLight light = new PointLight(new Vec3(0,5,-5), Color.WHITE);
		
		Scene scene = new Scene();
		scene.addGeometry(sphere, sphere2);
		scene.addLight(light);

		scene.setBGColor(Color.BLACK);
		raytracer.render(scene, cam);
	}

}
