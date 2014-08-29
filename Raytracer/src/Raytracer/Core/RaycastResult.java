package Raytracer.Core;

import Raytracer.Geometry.Geometry;
import Raytracer.Math.Vec3;

public class RaycastResult {
	public static final RaycastResult FAILURE = new RaycastResult();
	
	public double distance;
	public Vec3 hitPoint;
	public Geometry hitObject;
	public boolean hit;
	
	public RaycastResult(boolean hit, Geometry object, Vec3 hitPoint, double distance){
		this.hit = hit;
		this.hitObject = object;
		this.hitPoint = hitPoint;
		this.distance = distance;
	}
	
	public RaycastResult(){
		this(false, null, Vec3.ZERO, 0);
	}
}
