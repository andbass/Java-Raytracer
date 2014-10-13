package Raytracer.BRDFs;

import Raytracer.Core.Camera;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Math.Vec3;

public class Normals extends BRDF {

	public Normals(Material mat) {
		super(mat);
		// TODO Auto-generated constructor stub
	}

	public Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords) {
		Vec3 norm = result.hitObject.getNormal(result.hitPoint);
		return new Color(255*norm.x, 255*norm.y, 255*norm.z);
	}

}
