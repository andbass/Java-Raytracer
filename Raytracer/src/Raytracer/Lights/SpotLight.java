package Raytracer.Lights;

import Raytracer.Math.*;

import java.io.Serializable;

public class SpotLight extends PointLight implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpotLight(Vec3 pos, Vec3 dir, Color col) {
		super(pos, col);
		
	}

}
