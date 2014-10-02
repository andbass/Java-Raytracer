import Raytracer.BRDFs.Phong;
import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
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
											 new Poseidon(3,0.25));
		Camera camera = new Camera();
		Scene scene = ExampleScenes.getEarth(0);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();
		
	}

}
