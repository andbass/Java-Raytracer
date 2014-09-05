package Raytracer.Sampling;

import Raytracer.Math.Vec2;

public class Grid extends Sampler {

	public Grid(int sampleSize){
		super(sampleSize);
	}
	
	public Vec2 getModXY(double x, double y) {
		return new Vec2(subPixelSize * x, subPixelSize * y);
	}

	
}
