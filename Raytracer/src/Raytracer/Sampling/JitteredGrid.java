package Raytracer.Sampling;

import Raytracer.Math.Vec2;

import java.io.Serializable;

public class JitteredGrid extends Grid {

	public JitteredGrid(int sampleSize) {
		super(sampleSize);
	}
	
	public Vec2 getModXY(int x, int y){
		return super.getModXY(x, y).scale(Math.random() * 0.5);
	}
}
