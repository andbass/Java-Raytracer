package Raytracer.Math;

public class Vec3 {

	public static final Vec3 ZERO = new Vec3(0,0,0);
	
	public double x, y, z;
	
	public Vec3(double x, double y){
		this(x, y, 0);
	}
	
	public Vec3(double x, double y, double z){
		this.x = x;  this.y = y;  this.z = z;
	}

	public void set(double x, double y, double z){
		this.x = x;  this.y = y;  this.z = z;
	}

	public Vec3 add(Vec3 vec){
		return new Vec3(this.x + vec.x, this.y + vec.y, this.z + vec.z);
	}
	
	public Vec3 sub(Vec3 vec){
		return new Vec3(this.x - vec.x, this.y - vec.y, this.z - vec.z);
	}
	
	public Vec3 scale(double number){
		return new Vec3(this.x*number, this.y*number, this.z*number);
	}
	
	public double dot(Vec3 vec){
		return this.x*vec.x + this.y*vec.y + this.z*vec.z;
	}
	
	public Vec3 cross(Vec3 vec){
		return new Vec3(this.y*vec.z - this.z*vec.y, this.x*vec.z - this.z*vec.x, this.y*vec.x - this.x*vec.y);
	}
	
	public Vec3 normalize(){
		double length = length();
		return new Vec3(this.x / length, this.y / length, this.z / length);
	}
	
	public Vec3 negate(){
		return new Vec3(-this.x, -this.y, -this.z);
	}
	
	public double dist(Vec3 vec){
		double x = this.x - vec.x;
		x *= x;
		
		double y = this.y - vec.y;
		y *= y;
		
		double z = this.z - vec.z;
		z *= z;
		
		return Math.sqrt(x + y + z);
	}
	
	public double length(){
		return dist(Vec3.ZERO);
	}
	
	public String toString(){
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	public Vec3 abs() {
		return new Vec3(Math.abs(x), Math.abs(y), Math.abs(z));
	}

}
