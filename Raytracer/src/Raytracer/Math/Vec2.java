package Raytracer.Math;

import java.io.Serializable;

public class Vec2 extends Vec3 implements Serializable {

	public Vec2(double x, double y){
		super(x, y, 0);
	}
	
	public void set(double x, double y){
		super.set(x, y, 0);
	}
	
	public Vec2 toScreenSpace(){
		return new Vec2((x + 1) / 2, (y + 1) / 2);
	}
	
	public Vec2 toNDC(){
		return new Vec2(-1 + x * 2, -1 + x * 2);
	}
	
	public Vec2 scale(double number){
		Vec3 temp = super.scale(number);
		return new Vec2(temp.x, temp.y);
	}
}
