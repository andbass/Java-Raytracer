package Raytracer.Core;

import Raytracer.Math.*;

public class Ray {
	public Vec3 pos;
	public Vec3 dir;
	
	public Ray(Vec3 pos, Vec3 dir){
		this.pos = pos;
		this.dir = dir.normalize();
	}
	
	public Vec3 advance(double dist){
		return pos.add(dir.scale(dist));
	}
}
