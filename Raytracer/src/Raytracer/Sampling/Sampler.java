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
		this.samples = samples;
	}
	
}
