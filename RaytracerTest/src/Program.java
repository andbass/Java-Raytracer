import Raytracer.BRDFs.Phong;
import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Debugging.Debug;
import Raytracer.Materials.FlatColor;
import Raytracer.Sampling.Poseidon;
import Raytracer.Swing.JRaytracer;

import java.io.Serializable;

public class Program implements Serializable {
	public static void main(String[] args){

		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(FlatColor.BLACK),
											 new Poseidon(5, 0.4));
				
		Scene scene = ExampleScenes.EARTH;
		Camera camera = ExampleScenes.getCamera(scene);
				
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();
		
		Debug.writeLog();
	}

}
