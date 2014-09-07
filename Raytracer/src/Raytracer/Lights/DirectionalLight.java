package Raytracer.Lights;

import Raytracer.Debugging.Debug;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

public class DirectionalLight implements Light, Serializable {
	
	
	private Vec3 dirNeg;
	private Color ambient, diffuse, specular;
	
	public DirectionalLight(Vec3 dir, Color diffuse){
		this(dir, Color.WHITE, diffuse, Color.WHITE);
	}
	
	public DirectionalLight(Vec3 dir, Color ambient, Color diffuse, Color specular){
		this.dirNeg = dir.normalize().negate();
		Debug.write(dirNeg);
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

	public double getDist(Vec3 point) {
		return Double.POSITIVE_INFINITY;
	}

}
