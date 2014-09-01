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

	public Vec3 getDir(Vec3 point) {
		return pos.sub(point).normalize();
	}
	
	public Vec3 getPos() { return pos; }

}
