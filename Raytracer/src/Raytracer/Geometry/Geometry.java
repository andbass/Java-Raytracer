package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public abstract class Geometry {

	protected Material material;
	
	/*
	 * Whether or not a ray intersects this geometry
	 */
	public abstract RaycastResult collide(Ray ray);
	
	public Material 	getMaterial() { return material; };
	public void			setMaterial(Material material) { this.material = material; }
	
	public abstract Color		getDiffuse(Vec3 point);
	public abstract Color 		getAmbient(Vec3 point);
	public abstract Color		getSpecular(Vec3 point);
	/*
	 * Returns the normal of a point on the object.
	 * The normal is the direction a surface is pointing.
	 */
	public abstract Vec3  		getNormal(Vec3 point);
	
	
}
