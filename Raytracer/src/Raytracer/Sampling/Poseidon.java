package Raytracer.Sampling;

import Raytracer.Math.Vec2;

public class Poseidon extends Sampler {

	private double scale;
	
	public Poseidon(int samples, double scale){
		super(samples);
		this.scale = scale;
	}
	
	public Vec2 getModXY(double x, double y) {
		return new Vec2((Math.random() * 2 - 1)*scale, (Math.random() * 2 - 1)*scale);
	}


}
