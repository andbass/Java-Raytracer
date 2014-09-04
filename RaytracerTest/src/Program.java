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
	public static void main(String[] args){

		JRaytracer raytracer = new JRaytracer("Raytracer (Alt + Enter to fullscreen)",
											 1280, 720,	
											 new Phong(Gradient.DAY_SKY),
											 new Poseidon(9, 0.2));
		
		Scene scene = ExampleScenes.TWO_SPHERES_PLANE;
		Camera camera = ExampleScenes.getCamera(scene);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();
		
		
		Debug.writeLog();
	}

}
