package Raytracer.Lights;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class DirectionalLight implements Light {
	
	private Vec3 dirNeg;
	private Color ambient, diffuse, specular;
	
	public DirectionalLight(Vec3 dir, Color diffuse){
		this(dir, Color.BLACK, diffuse, Color.WHITE);
	}
	
	public DirectionalLight(Vec3 dir, Color ambient, Color diffuse, Color specular){
		this.dirNeg = dir.negate();
		this.ambient = ambient;  this.diffuse = diffuse;  this.specular = specular;
	}
	
	public Color getAmbient() {
		return ambient;
	}

	public Color getDiffuse() {
		return diffuse;
	}

	public Color getSpecular() {
		return specular;
	}

	public Vec3 getDirToLight(Vec3 point) {
		return dirNeg;
	}

	public double getLambertTerm(Vec3 normal, Vec3 pointToLight) {
		double lambTerm = Math.max(normal.dot(pointToLight), 0);
		
		return lambTerm;
	}

}