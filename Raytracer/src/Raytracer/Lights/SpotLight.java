package Raytracer.Lights;

import Raytracer.Math.*;

import java.io.Serializable;

public class SpotLight extends PointLight implements Serializable {


	public SpotLight(Vec3 pos, Vec3 dir, Color col) {
		super(pos, col);
		
	}

}
