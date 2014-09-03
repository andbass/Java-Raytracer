package Raytracer.Sampling;

import Raytracer.Math.Vec2;

public interface Sampler {
	public Vec2 getModXY(double x, double y);
	
	public int getSamples();
	public void setSamples(int samples);
	
}
