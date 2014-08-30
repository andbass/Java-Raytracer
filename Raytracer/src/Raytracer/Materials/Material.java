package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public interface Material {
	/*
	 * The ambient color of an object.  Represents lighting from small amounts of light
	 * scattered around scene.  This color is visible when no light is directly hitting the object.
	 */
	public Color 		getAmbient(Vec3 point);
	
	/*
	 * The diffuse color of a point on the object.
	 * This is the color of a point where light is directly striking with
	 * a relative angle of zero.  Return a color value without doing any
	 * lighting calcuations.  The renderer will determine the intensity of 
	 * the color based on the amount of light illuminating the point.
	 */
	public Color 		getDiffuse(Vec3 point);
	
	/*
	 * The specular intensity of a point on the object.
	 * This is the specular intensity of a point where light is being directly reflected
	 * into the camera.  Return a specular intensity without doing any lighting calcuations.
	 * The renderer will determine the actual intensity of the specular based on how light is
	 * striking the point.
	 */
	public Color		getSpecular(Vec3 point);
	
	public double getReflectivity(Vec3 point);
	
	public double getShininess(Vec3 point);
	
}