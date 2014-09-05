package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Texture extends Material {
	
	public Texture(double shininess, double reflectivity){
		super(shininess, reflectivity);
	}

	public Color getAmbient(Vec3 point) {
		// TODO Auto-generated method stub
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
