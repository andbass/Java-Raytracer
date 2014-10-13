package Raytracer.Geometry;

import Raytracer.Materials.Material;
import Raytracer.Math.Vec3;

import java.io.Serializable;

/**
 * Created by Ben Scholer on 10/2/14.
 *
 * A Dome is a sphere with the normals facing towards the center of the sphere.
 */
public class Dome extends Sphere implements Serializable {

	public Dome(Vec3 pos, double radius, Material mat) {
		super(pos, radius, mat);
	}

	public Vec3 getNormal(Vec3 point) {
		System.out.println(super.getNormal(point));
		return super.getNormal(point).negate();
	}


} //end of Dome class
