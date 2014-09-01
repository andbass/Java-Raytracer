package Raytracer.Math;

public class Vec2 extends Vec3 {

	public Vec2(double x, double y){
		super(x, y, 0);
	}
	
	public void set(double x, double y){
		super.set(x, y, 0);
	}
	
	public Vec2 toNDC(){
		return new Vec2((x + 1) / 2, (y + 1) / 2);
	}
	
	public Vec2 toScreenSpace(){
		return new Vec2(-1 + x * 2, -1 + x * 2);
	}
}
