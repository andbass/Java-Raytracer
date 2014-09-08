package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

/**
 * Created by Ben Scholer on 9/5/14.
 */
public class Metal extends Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Metal ALUMINIUM = new Metal(new Color(173, 178, 189));
	public static final Metal BRASS = new Metal(new Color(181, 166, 66));
	public static final Metal COPPER = new Metal(new Color(184, 115, 51));
	public static final Metal GOLD = new Metal(new Color("#FFDF00"));
	public static final Metal PEWTER = new Metal(new Color("#9D9A96"));
	public static final Metal BRONZE = new Metal(new Color("#CD7F32"));

	private Color ambient, diffuse, specular;

	public Metal(Color diffuse){
		this(diffuse, 10, 0);
	}

	public Metal(Color diffuse, double shininess, double reflectivity){
		this(Color.BLACK, diffuse, Color.WHITE, shininess, reflectivity);
	}

	public Metal(Color ambient, Color diffuse, Color specular, double shininess, double reflectivity){
		super(shininess, reflectivity);
		this.ambient = ambient;  this.diffuse = diffuse;  this.specular = specular;
	}

	@Override
	public Color getAmbient(Vec3 uv) {
		return ambient;
	}

	@Override
	public Color getDiffuse(Vec3 uv) {
		return diffuse;
	}

	@Override
	public Color getSpecular(Vec3 uv) {
		return specular;
	}

	public void setAmbient(Color ambient) 	{ this.ambient = ambient; }
	public void setDiffuse(Color diffuse) 	{ this.diffuse = diffuse; }
	public void setSpecular(Color specular) { this.specular = specular; }
} //end of Metal class
