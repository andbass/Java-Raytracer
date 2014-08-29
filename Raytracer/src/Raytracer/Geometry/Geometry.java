package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Vec3;

public interface Geometry {

	/*
	 * Whether or not a ray intersects this geometry
	 */
	public RaycastResult collide(Ray ray);
	
	public Material 	getMaterial();
	
	/*
	 * Returns the normal of a point on the object.
	 * The normal is the direction a surface is pointing.
	 */
	public Vec3  		getNormal(Vec3 point);
	
	
}
