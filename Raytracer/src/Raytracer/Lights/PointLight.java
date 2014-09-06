package Raytracer.Lights;

import Raytracer.Math.*;

public class PointLight implements Light {

	private Vec3 pos;
	
	private Color ambientIntensity;
	private Color diffuseIntensity;
	private Color specularIntensity;
	
	public PointLight(Vec3 pos, Color diffuse){
		this(pos, Color.WHITE, diffuse, Color.WHITE);
	}
	
	public PointLight(Vec3 pos, Color diffuse, double intensity){
		this(pos, diffuse.scale(intensity));
	}
	
	public PointLight(Vec3 pos, Color ambient, Color diffuse, Color specular){
		this.pos = pos;
		
		this.ambientIntensity = ambient;
		this.diffuseIntensity = diffuse;
		this.specularIntensity = specular;
	}
	
	public Color getAmbient() {
		return ambientIntensity;
	}

	public Color getDiffuse() {
		return diffuseIntensity;
	}

	public Color getSpecular() {
		return specularIntensity;
	}

	public Vec3 getDirToLight(Vec3 point) {
		return pos.sub(point).normalize();
	}
	
	public Vec3 getPos() { return pos; }

	public double getLambertTerm(Vec3 normal, Vec3 pointToLight) {
		return Math.max(normal.dot(pointToLight), 0);
	}

	public double getDist(Vec3 point) {
		return pos.dist(point);
	}

}
