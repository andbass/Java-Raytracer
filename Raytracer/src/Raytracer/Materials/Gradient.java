package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Gradient extends Material {
	private Color from, to,diff;
	
	public Gradient(Color from, Color to){
		super(0,0);
		this.from = from;  this.to = to;
		diff = to.sub(from);
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		
		return from.add(diff.scale(point.y));
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}
}
