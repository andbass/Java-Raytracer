import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Geometry.Plane;
import Raytracer.Geometry.Sphere;
import Raytracer.Lights.PointLight;
import Raytracer.Materials.Checkered;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Metal;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.util.HashMap;

public class ExampleScenes {
	public static final Scene TWO_SPHERES_PLANE = new Scene("Two spheres and a plane");
	private static final Camera TWO_SPHERES_PLANE_CAMERA = new Camera(new Vec3(0, 7, -5), Vec3.FORWARD, Vec3.UP, 60);

	public static final Scene EARTH = Scene.load
			("resources/scenes/earth.scene");
	private static final Camera EARTH_CAMERA = new Camera(Vec3.ZERO, Vec3.FORWARD, Vec3.UP, 60);

	private static HashMap<Scene, Camera> cameraMap = new HashMap<Scene, Camera>();

	static public Camera getCamera(Scene scene) {
		return cameraMap.get(scene);
	}

	static {
		// TWO_SPHERES_PLANE
		TWO_SPHERES_PLANE.addGeometry(new Sphere(new Vec3(0, 7, 20), 7, Metal.GOLD),
				new Sphere(new Vec3(-20, 5, 30), 5, FlatColor.MAGNETA),
				new Plane(Vec3.ZERO, Vec3.UP, Checkered.LARGE_YELLOW_GREEN));

		TWO_SPHERES_PLANE.addLight(new PointLight(new Vec3(0, 50, 0), Color.WHITE),
				new PointLight(new Vec3(0, 20, -50), Color.WHITE));

		cameraMap.put(TWO_SPHERES_PLANE, TWO_SPHERES_PLANE_CAMERA);
		// END TWO_SPHERES_PLANE

		// EARTH	
		cameraMap.put(EARTH, EARTH_CAMERA);
		// END EARTH
	}
}
