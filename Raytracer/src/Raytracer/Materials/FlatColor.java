package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class FlatColor extends Material {

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
	
	public FlatColor(Color diffuse){
		this(diffuse, Material.DEFAULT_SHININESS, Material.DEFAULT_REFLECTIVITY);
	}
	
	public FlatColor(Color diffuse, double shininess, double reflectivity){
		this(Color.BLACK, diffuse, Color.WHITE, shininess, reflectivity);
	}
	
	public FlatColor(Color ambient, Color diffuse, Color specular, double shininess, double reflectivity){
		super(shininess, reflectivity);
		this.ambient = ambient;  this.diffuse = diffuse;  this.specular = specular;
	}
	
	public Color getAmbient(Vec3 uv) {
		return ambient;
	}

	public Color getDiffuse(Vec3 uv) {
		return diffuse;
	}

	public Color getSpecular(Vec3 uv) {
		return specular;
	}
	
	public void setAmbient(Color ambient) 	{ this.ambient = ambient; }
	public void setDiffuse(Color diffuse) 	{ this.diffuse = diffuse; }
	public void setSpecular(Color specular) { this.specular = specular; }

}
