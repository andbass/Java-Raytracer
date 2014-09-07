package Raytracer.Sampling;

import Raytracer.Math.Vec2;

import java.io.Serializable;

public class Grid extends Sampler {

	public Grid(int sampleSize){
		super(sampleSize);
	}
	
	public Vec2 getModXY(double x, double y) {
		return new Vec2(subPixelSize * x, subPixelSize * y);
	}
	
	public void setSamples(int samples){		
		this.sqrtSamples = (int)Math.sqrt(samples);
	
		if (sqrtSamples*sqrtSamples != samples){  			
			throw new IllegalArgumentException("The number of samples to be a perfect square, as the supersampling uses a square grid to cast additional rays");
		}
		this.samples 		= samples;
		this.subPixelSize 	= 1.0 / sqrtSamples; 
	}
	
}
