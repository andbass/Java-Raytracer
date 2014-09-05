package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Gradient extends Material {
	public static final Gradient DAY_SKY = new Gradient(new Color(30,144,255),
														new Color(135,206,250));

	public static final Gradient DUSK_SKY = new Gradient(new Color(15,45,180),
														 new Color(200,45,10));

	public static final Gradient HORIZON_SKY = new Gradient(new Color(16,19,21),
			new Color(16,19,21),
			new Color(16,19,21),
			new Color(16,19,21),
			new Color(40,45,55),
			new Color(95,101,114),
			new Color(238,223,168),
			new Color(212,125,14),
			new Color(81,55,26),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0),
			new Color(0,0,0));

	public static final Gradient AFTER_SUNSET_SKY = new Gradient(new Color(5,5,21),
			new Color(5,10,31),
			new Color(5,5,21));

	public static final Gradient LIGHT_BLUE = new Gradient(new Color(211,250,248),
			new Color(239,250,250));

	public static final Gradient PURPLE_BLUE = new Gradient(new Color(102,36,232),
			new Color(81,133,221),
			new Color(0,0,0));

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
		int index = (int)(t * (colors.length-1));

		Color from = colors[index];  Color to = colors[index+1];
		Color diff = to.sub(from);

		return from.add(diff.scale(t));
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}
}
