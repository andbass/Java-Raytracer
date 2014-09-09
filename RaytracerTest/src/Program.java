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
		
		Scene scene = new Scene("Stars in space");
		Camera camera = new Camera();
		
		Color[] starColors = new Color[]{Color.WHITE, Color.RED, Color.YELLOW, Color.BLUE};
		List<Geometry> stars = new ArrayList<Geometry>();
		
		for (int i = 0; i < 20; i++){
			Vec3 rand = Vec3.random(10000, 10000, 3000).add(Vec3.FORWARD.scale(10000));
			Color starColor = starColors[i % starColors.length];
			Sphere star = new Sphere(rand, 250 * Math.random(), new FlatColor(starColor));
			stars.add(star);
		}
		
		scene.addGeometry(stars);
		
		Debug.LOG.start("Test render");
		raytracer.render(scene, camera);
		Debug.LOG.end();

	}

}
