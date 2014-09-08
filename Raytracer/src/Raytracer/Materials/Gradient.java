package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

public class Gradient extends Material implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Gradient DAY_SKY = new Gradient(new Color(70,130,180),
														new Color(0,191,255),
														new Color(173,216,230));

	public static final Gradient DUSK_SKY = new Gradient(new Color(15,45,180),
														 new Color(200,45,10));

	public static final Gradient HORIZON_SKY = new Gradient(new Color(16,19,21));

	public static final Gradient AFTER_SUNSET_SKY = new Gradient(new Color(5,5,21),
																 new Color(5,10,31),
																 new Color(5,5,21));

	private Color[] colors;

	public Gradient(Color...colors){
		super(0,0);
		this.colors = colors;
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		double t = 1 - point.y;
		double offset = t * (colors.length - 1);
		int index = (int)(offset);
		
		offset -= index;
		
		Color from = colors[index];  Color to = colors[index+1];
		Color diff = to.sub(from);

		return from.add(diff.scale(offset));
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}
}
