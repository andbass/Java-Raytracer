package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

public abstract class Geometry implements Serializable {

	public Geometry(Material mat){
		material = mat;
	}
	
	protected Material material;

	public Material 	getMaterial() { return material; };
	public void			setMaterial(Material material) { this.material = material; }
	
	public abstract RaycastResult 	collide(Ray ray);
	
	public abstract Color			getDiffuse(Vec3 point);
	public abstract Color 			getAmbient(Vec3 point);
	public abstract Color			getSpecular(Vec3 point);
	/*
	 * Returns the normal of a point on the object.
	 * The normal is the direction a surface is pointing.
	 */
	public abstract Vec3  		getNormal(Vec3 point);
	
	
}
