package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class FlatColor implements Material {

    public static final FlatColor RED    	= new FlatColor(Color.RED);
	public static final FlatColor GREEN	 	= new FlatColor(Color.GREEN);
	public static final FlatColor BLUE	 	= new FlatColor(Color.BLUE);
	public static final FlatColor YELLOW 	= new FlatColor(Color.YELLOW);
	public static final FlatColor ORANGE 	= new FlatColor(Color.ORANGE);
	public static final FlatColor MAGNETA 	= new FlatColor(Color.MAGNETA);
	public static final FlatColor WHITE	 	= new FlatColor(Color.WHITE);
	public static final FlatColor BLACK 	= new FlatColor(Color.BLACK);
	public static final FlatColor OFF_WHITE = new FlatColor(Color.OFF_WHITE);
	
	private Color ambient, diffuse, specular;
	private double reflectivity, shininess;
	
	public FlatColor(Color diffuse){
		this(diffuse, 5, 5);
	}
	
	public FlatColor(Color diffuse, double shininess, double reflectivity){
		this(Color.BLACK, diffuse, Color.WHITE, shininess, reflectivity);
	}
	
	public FlatColor(Color ambient, Color diffuse, Color specular, double shininess, double reflectivity){
		this.ambient = ambient;  this.diffuse = diffuse;  this.specular = specular;
		this.reflectivity = reflectivity;
		this.shininess = shininess;
	}
	
	public Color getAmbient(Vec3 point) {
		return ambient;
	}

	public Color getDiffuse(Vec3 point) {
		return diffuse;
	}

	public Color getSpecular(Vec3 point) {
		return specular;
	}

	public double getReflectivity(Vec3 point) {
		return reflectivity;
	}

	public double getShininess(Vec3 point) {
		return shininess;
	}

}
