package Raytracer.Sampling;

import Raytracer.Math.Vec2;

public abstract class Sampler {
	protected int samples, sqrtSamples;
	protected double subPixelSize;
	
	public Sampler(int samples){
		setSamples(samples);
	}
	
	public abstract Vec2 getModXY(double x, double y);

	public int 	getSamples() { return this.samples; }
	
	public void setSamples(int samples) { 
		this.sqrtSamples = (int)Math.sqrt(samples);
		
		if (sqrtSamples*sqrtSamples != samples){  			
			throw new IllegalArgumentException("The number of samples to be a perfect square, as the supersampling uses a square grid to cast additional rays");
		}
		this.samples 		= samples;
		this.subPixelSize 	= 1.0 / sqrtSamples; 
	}
	
}
