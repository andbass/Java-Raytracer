package Raytracer.Materials;

import java.awt.image.BufferedImage;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Texture extends Material {
	
	private BufferedImage tex;
	private Color specular;
	private double ambientMultipler;
	
	public Texture(BufferedImage tex, double ambientMultipler, double shininess, double reflectivity){
		super(shininess, reflectivity);
		this.tex = tex;
		this.ambientMultipler = ambientMultipler;
	}

	public Color getAmbient(Vec3 point) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getSpecular(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}
}
