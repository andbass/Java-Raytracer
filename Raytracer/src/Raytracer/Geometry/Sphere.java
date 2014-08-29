package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.QuadraticEquation;
import Raytracer.Math.Vec3;

public class Sphere implements Geometry {
	private Vec3 pos;
	private double radius, radiusSquared;
	
	private Material mat;
	
	public Sphere(Vec3 pos, double radius, Material mat){
		this.pos = pos;
		setRadius(radius);
		
		this.mat = mat;
	}
	
	public RaycastResult collide(Ray ray) {
		Vec3 relativePos = ray.pos.sub(this.pos);
		
		double a = ray.dir.dot(ray.dir);
		double b = 2 * relativePos.dot(ray.dir);
		double c = relativePos.dot(relativePos) - this.radiusSquared;
		 
		QuadraticEquation sphereEquation = new QuadraticEquation(a, b, c);
		
		if (!sphereEquation.isSolvable()){ // if the quadratic equation isnt solvable, that means our ray doesn't collide at all with the sphere
			return RaycastResult.FAILURE;
		}
		
		double root1 = sphereEquation.getFirstRoot();
		double root2 = sphereEquation.getSecondRoot();
		
		if (root1 < 0 && root2 < 0) return RaycastResult.FAILURE; // if both roots are negative, the sphere is behind the ray
		
		double lowestRoot = Math.min(root1, root2);
		
		// Fun fact: if the lowest root is negative, and the other is postive, that means the ray is inside the sphere.
		if (lowestRoot < 0){
			lowestRoot = Math.max(root1, root2);
		}
		
		return new RaycastResult(true, this, ray.advance(lowestRoot), lowestRoot);
	}
	
	public void 	setRadius(double radius)	{ this.radius = radius; this.radiusSquared = radius*radius; }
	public void 	setPos(Vec3 pos)			{ this.pos = pos; }
	
	public Vec3 	getPos()					{ return this.pos; }
	public double 	getRadius() 				{ return this.radius; }
	
	/*
	 * Returns the normal of a point on the sphere.
	 * The point should be in world coordinates.
	 */
	public Vec3 getNormal(Vec3 point) {
		point = point.sub(pos);
		return point.normalize();
	}
	
	public Material getMaterial(){
		return mat;
	}
}
	
	
	
	
	
	
