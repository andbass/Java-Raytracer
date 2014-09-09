import java.util.ArrayList;
import java.util.List;

import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Geometry.Geometry;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.PointLight;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Texture;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class ExampleScenes {
	public static final Scene TWO_SPHERES_PLANE = new Scene("Two spheres and a plane");
	private static final Camera TWO_SPHERES_PLANE_CAMERA = new Camera(new Vec3(0, 7, -5), Vec3.FORWARD, Vec3.UP, 60);

	public static Scene getEarth(int numberOfStars){
		Scene scene = new Scene("Stars in space");
		
		Color[] starColors = new Color[]{Color.WHITE, Color.RED, Color.YELLOW, Color.BLUE};
		List<Geometry> stars = new ArrayList<Geometry>();
		
		for (int i = 0; i < numberOfStars; i++){
			Vec3 rand = Vec3.random(20000, 15000, 6000).add(Vec3.FORWARD.scale(25000));
			Color starColor = starColors[i % starColors.length];
			Sphere star = new Sphere(rand, 50 * Math.random(), new FlatColor(starColor));
			stars.add(star);
		}
		
		Sphere earth	= new Sphere(new Vec3(0, 0, 400), 125, new Texture("resources/images/earth_day.jpg"));
		Sphere moon		= new Sphere(new Vec3(-200, 120, 450), 45, new Texture("resources/images/moon.jpg"));
		
		scene.addGeometry(stars);
		scene.addGeometry(earth, moon);
		
		scene.addLight(	new PointLight(new Vec3(0,100,0), Color.WHITE) );
		return scene;
	}
}
