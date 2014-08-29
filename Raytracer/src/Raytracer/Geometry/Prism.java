package Raytracer.Geometry;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;
import Raytracer.Ray;
import Raytracer.RaycastResult;

/**
 * Created by benscholer on 8/29/14.
 */
public class Prism implements Geometry {

	public Prism(Vec3 minBounds, Vec3 maxBounds){

	}

	public RaycastResult collide(Ray ray) {
		return null;
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		return null;
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}

	public Vec3 getNormal(Vec3 point) {
		return null;
	}
} //end of Prism class
