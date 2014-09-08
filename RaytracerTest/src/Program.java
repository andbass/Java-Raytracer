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
	public static void main(String[] args){
		
		JLogViewer logViewer = new JLogViewer(400,480);
		Debug.LOG.setLogViewer(logViewer);
		
		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(FlatColor.BLACK),
											 new Poseidon(1, 0));
				
		Scene scene = ExampleScenes.EARTH;
		scene.addGeometry(new Sphere(new Vec3(1000, 200, 2000), 10, FlatColor.WHITE));
		Camera camera = ExampleScenes.getCamera(scene);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();

	}

}
