package Raytracer.Materials;

import Raytracer.Debugging.Debug;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Gradient extends Material {
	public static final Gradient DAY_SKY = new Gradient(new Color(30,144,255),
														new Color(135,206,250));
	
	public static final Gradient DUSK_SKY = new Gradient(new Color(15,45,180), 
														 new Color(200,45,10));
	
	private Color from, to, diff;
	
	public Gradient(Color from, Color to){
		super(0,0);
		this.from = from;  this.to = to;
		diff = to.sub(from);
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		
		return from.add(diff.scale(1-point.y));
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}
}
