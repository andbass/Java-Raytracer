package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Gradient extends Material {
	public static final Gradient DAY_SKY = new Gradient(new Color(30,144,255),
														new Color(135,206,250));
	
	public static final Gradient DUSK_SKY = new Gradient(new Color(15,45,180), 
														 new Color(200,45,10));
	private Color[] colors;

	public Gradient(Color...colors){
		super(0,0);
		this.colors = colors;
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		double gradientLengths = 1 / colors.length;
		int index = (int)((1 - point.y) / gradientLengths);

		Color from = colors[index];  Color to = colors[index];



		return Color.BLACK;
	}

	public Color getSpecular(Vec3 point) {
		return null;
	}
}
