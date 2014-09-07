package Raytracer.Core;

import Raytracer.Math.*;

import java.io.Serializable;

public class Ray implements Serializable {
	public Vec3 pos;
	public Vec3 dir;
	
	public Ray(){
		this(Vec3.ZERO, Vec3.FORWARD);
	}
	
	public Ray(Vec3 pos, Vec3 dir){
		this.pos = pos;
		this.dir = dir.normalize();
	}
	
	public Vec3 advance(double dist){
		return pos.add(dir.scale(dist));
	}
}
