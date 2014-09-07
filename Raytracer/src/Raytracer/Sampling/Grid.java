package Raytracer.Sampling;

import Raytracer.Math.Vec2;

import java.io.Serializable;

public class Grid extends Sampler implements Serializable {

	public Grid(int sampleSize){
		super(sampleSize);
	}
	
	public Vec2 getModXY(double x, double y) {
		return new Vec2(subPixelSize * x, subPixelSize * y);
	}

	
}
