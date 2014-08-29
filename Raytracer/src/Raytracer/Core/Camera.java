package Raytracer.Core;

import Raytracer.Math.Vec3;

public class Camera {
	private Vec3 pos, dir, right, up;
	private double fovMultipler;
	private double fov;
	
	public Camera(Vec3 pos, Vec3 dir, Vec3 up, double fovDegrees){
		this.pos = pos;  this.dir = dir.normalize();  this.up = up.normalize();
		this.fov = fovDegrees;
		this.fovMultipler = Math.tan(Math.toRadians(fovDegrees/2));
		calculateRightVector();
	}
	
	public void setPos(Vec3 pos){ this.pos = pos; }
	
	public void setDir(Vec3 dir){
		this.dir = dir.normalize();
		calculateRightVector();
	}
	
	public void setUp(Vec3 up){
		this.up = up;
		calculateRightVector();
	}
	
	public void setFov(double fov){
		this.fov = fov;
		this.fovMultipler = Math.tan(Math.toRadians(fov/2));
	}

	public Vec3 getPos() 				{ return pos; }
	public Vec3 getDir()				{ return this.dir; }
	public Vec3 getUp()	   				{ return this.up; }
	public Vec3 getRight() 		  		{ return this.right; }
	public double getFov()  	  		{ return this.fov; }
	public double getFovMultipler() 	{ return this.fovMultipler; }
	
	public Ray getRay(double x, double y){
		Vec3 rayPos = this.pos;
		Vec3 rayDir = this.dir;
		rayDir = rayDir.add(this.right.scale(x))
					   .add(this.up.scale(y));
		
		return new Ray(rayPos, rayDir);
	}
	
	private void calculateRightVector() {
		this.right = up.cross(dir);
	}
	
	
	
}
