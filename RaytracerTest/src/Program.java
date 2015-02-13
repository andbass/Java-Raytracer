import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
import Raytracer.LightingModels.Phong;
import Raytracer.Materials.Gradient;
import Raytracer.Math.Color;
import Raytracer.Sampling.Poseidon;
import Raytracer.Swing.JRaytracer;

public class Program {
	public static void main(String[] args){

		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(Gradient.DAY_SKY),
											 new Poseidon(9, 0.4));
		
		Scene scene = ExampleScenes.TWO_SPHERES_PLANE;
		Camera camera = ExampleScenes.getCamera(scene);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();
		
		
		Debug.writeLog();
	}

}
