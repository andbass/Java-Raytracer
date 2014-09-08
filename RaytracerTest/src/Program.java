import java.util.ArrayList;
import java.util.List;

import Raytracer.BRDFs.Phong;
import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
import Raytracer.Geometry.Sphere;
import Raytracer.Materials.FlatColor;
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
											 new Phong(FlatColor.BLACK),
											 new Poseidon(1, 0));
				
		Scene scene = ExampleScenes.EARTH;
		List<Sphere> stars = new ArrayList<Sphere>();
		
		for (int i = 0; i < 5; i++){
			stars.add(new Sphere(Vec3.random(10000).add(new Vec3(0,0,1000)), 10, FlatColor.WHITE);
		}
		
		scene.addGeometry(stars);
		
		Camera camera = ExampleScenes.getCamera(scene);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();

	}

}
