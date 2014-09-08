package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

public class Plane extends Geometry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vec3 pos, normal;
	
	public Plane(Vec3 pos, Vec3 normal, Material mat){
		super(mat);
		this.pos = pos;  this.normal = normal.normalize();
	}
	
	public void setPos(Vec3 pos) { this.pos = pos; }
	public void setNormal(Vec3 normal) { this.normal = normal.normalize(); }
	
	public RaycastResult collide(Ray ray) {
		double denom = ray.dir.dot(this.normal);
		
		if (denom < 0){
			Vec3 relativePos = ray.pos.sub(this.pos);
			double dist = -relativePos.dot(this.normal);
			dist /= denom;
						
			if (dist < 0) return RaycastResult.FAILURE;
			return new RaycastResult(true, this, ray.advance(dist), dist);
		}
		return RaycastResult.FAILURE;
	}

	public Color getDiffuse(Vec3 point) {
		return material.getDiffuse(point);
	}

	public Color getAmbient(Vec3 point) {
		return material.getAmbient(point);
	}

	public Color getSpecular(Vec3 point) {
		return material.getSpecular(point);
	}

	public Vec3 getNormal(Vec3 point) {
		return normal;
	}

}
