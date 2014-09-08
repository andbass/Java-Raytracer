package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

/**
 * A Material represents a two dimensinal surface that is wrapped around Geometry
 */
public abstract class Material implements Serializable { // TODO Replace Vec3 paramters with Vec2
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final double DEFAULT_SHININESS 	= 5;
	public static final double DEFAULT_REFLECTIVITY = 0;
	
	protected double shininess, reflectivity;
	
	public Material(double shininess, double reflectivity){
		this.shininess = shininess;  this.reflectivity = reflectivity;
	}
	/*
	 * The ambient color of an object.  Represents lighting from small amounts of light
	 * scattered around scene.  This color is visible when no light is directly hitting the object.
	 */
	public abstract Color 		getAmbient(Vec3 uv);
	
	/*
	 * The diffuse color of a uv on the object.
	 * This is the color of a uv where light is directly striking with
	 * a relative angle of zero.  Return a color value without doing any
	 * lighting calcuations.  The renderer will determine the intensity of 
	 * the color based on the amount of light illuminating the uv.
	 */
	public abstract Color 		getDiffuse(Vec3 uv);
	
	/*
	 * The specular intensity of a uv on the object.
	 * This is the specular intensity of a uv where light is being directly reflected
	 * into the camera.  Return a specular intensity without doing any lighting calcuations.
	 * The renderer will determine the actual intensity of the specular based on how light is
	 * striking the uv.
	 */
	public abstract Color		getSpecular(Vec3 uv);
	
	public double getReflectivity(Vec3 uv){
		return reflectivity;
	}
	
	public double getShininess(Vec3 uv){
		return shininess;
	}
	
	public void setReflectivity(double r) 	{ this.reflectivity = r; }
	public void setShininess(double s) 		{ this.shininess = s; }
	
}
