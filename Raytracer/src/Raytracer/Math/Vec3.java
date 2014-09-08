package Raytracer.Math;

import java.io.Serializable;
import java.util.Random;

public class Vec3 implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A Vec3 with every component equal to zero.
	 */
	public static final Vec3 ZERO		= new Vec3(0,0,0);
	
	/**
	 * A Vec3 facing upwards (in world space)
	 */
	public static final Vec3 UP			= new Vec3(0,1,0);
	
	/**
	 * A Vec3 facing right (in world space)
	 */
	public static final Vec3 RIGHT		= new Vec3(1,0,0);
	
	/**
	 * A Vec3 facing forwards (in world space)
	 */
	public static final Vec3 FORWARD	= new Vec3(0,0,1);
	
	public static Vec3 random(double max){
		return Vec3.random(max, max, max, true);
	}
	
	public static Vec3 random(double max, boolean canBeNegative){
		return Vec3.random(max, max, max, canBeNegative);
	}
	
	public static Vec3 random(double maxX, double maxY, double maxZ){
		return Vec3.random(maxX, maxY, maxZ, true);
	}
	
	public static Vec3 random(double maxX, double maxY, double maxZ, boolean canBeNegative){
		Random rand = new Random();
		
		double x = maxX * rand.nextDouble();
		rand.setSeed((long)x ^ 551232131L);
		double y = maxY * rand.nextDouble();
		rand.setSeed((long)y ^ 111212121L);
		double z = maxZ * rand.nextDouble();
		rand.setSeed((long)z ^ 41313132L);
		
		if (canBeNegative){
			x *= rand.nextInt(1) * 2 - 1;
			rand.setSeed((long)x ^ 75655L);
			y *= rand.nextInt(1) * 2 - 1;
			rand.setSeed((long)y ^ 5534534534L);
			z *= rand.nextInt(1) * 2 - 1;
			rand.setSeed((long)z ^ 124017890L);
		}
		return new Vec3(x, y, z);
	}
	
	public double x, y, z;

	public Vec3() {
		this(0,0,0);
	}
	
	public Vec3(double x){
		this(x, x, x);
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
	
	public Vec3 reflect(Vec3 normal){
		return normal.scale(2 * this.dot(normal)).sub(this);
	}
	
	public Vec3 normalize(){
		double length = length();
		return new Vec3(this.x / length, this.y / length, this.z / length);
	}
	
	public Vec3 dir(Vec3 vec){
		return vec.sub(this).normalize();
	}
	
	public Vec3 negate(){
		return new Vec3(-this.x, -this.y, -this.z);
	}
	
	public Vec3 around(double radius){
		Vec3 dir = Vec3.random(1, 1, 1).normalize();
		return this.add(dir.scale(radius));
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
