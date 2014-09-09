import java.util.ArrayList;
import java.util.List;

import Raytracer.BRDFs.Phong;
import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Geometry;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.PointLight;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Gradient;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;
import Raytracer.Sampling.Poseidon;
import Raytracer.Swing.JLogViewer;
import Raytracer.Swing.JRaytracer;

public class Program {
	
	public static final String RESOURCE_DIR = "resources/";
	
	public static void main(String[] args){
		
		JLogViewer logViewer = new JLogViewer(400,480);
		Debug.LOG.setLogViewer(logViewer);
		
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(),
											 new Poseidon(1,0));
		Camera camera = new Camera();
		Scene scene = ExampleScenes.getEarth(200);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();
		
		Debug.LOG.start("Saving Scene");
		scene.save("resources/scenes/" + scene.name + ".scene");
		Debug.LOG.end();
		
	}

}
