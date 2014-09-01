package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Checkered extends Material {

	public static final Checkered WHITE_BLACK 	= new Checkered(10, Color.WHITE, Color.BLACK);
	public static final Checkered WHITE_RED	  	= new Checkered(10, Color.WHITE, Color.RED);
	public static final Checkered YELLOW_GREEN 	= new Checkered(10, Color.YELLOW, Color.GREEN);
	
	public static final Checkered SMALL_WHITE_BLACK 	= new Checkered(1, Color.WHITE, Color.BLACK);
	public static final Checkered SMALL_WHITE_RED		= new Checkered(1, Color.WHITE, Color.RED);
	public static final Checkered SMALL_YELLOW_GREEN 	= new Checkered(1, Color.YELLOW, Color.GREEN);
	
	public static final Checkered LARGE_WHITE_BLACK 		= new Checkered(250, Color.WHITE, Color.BLACK);
	public static final Checkered LARGE_WHITE_RED		= new Checkered(250, Color.WHITE, Color.RED);
	public static final Checkered LARGE_YELLOW_GREEN 	= new Checkered(250, Color.YELLOW, Color.GREEN);
	
	private Color ambient, diffuse1, diffuse2, specular;
	private double size; 
	
	public Checkered(double size, Checkered checkered){
		this(size, checkered.getAmbient(Vec3.ZERO), checkered.getFirstDiffuse(), checkered.getSecondDiffuse(), checkered.getSpecular(Vec3.ZERO), 5, 5);
	}
	
	public Checkered(double size, Color diffuse1, Color diffuse2){
		this(size, Color.BLACK, diffuse1, diffuse2, Color.WHITE, 5, 5);
	}

	public Checkered(double size, Color ambient, Color diffuse1, Color diffuse2, Color specular, double shininess, double reflectivity){
		super(shininess, reflectivity);
		
		this.size = 100 / size;
		this.ambient = ambient;
		this.diffuse1 = diffuse1;  this.diffuse2 = diffuse2;  this.specular = specular;
	}
	
	public Color getAmbient(Vec3 uv) {
		return ambient;
	}

	public Color getDiffuse(Vec3 uv) {
		
		uv = uv.scale(size);
		
		boolean x = (int)uv.x % 2 == 0;
		boolean y = (int)uv.y % 2 == 0;
		boolean z = (int)uv.z % 2 == 0;
		
		return (x ^ y ^ z) ? diffuse1 : diffuse2;
		
	}

	public Color getFirstDiffuse(){
		return diffuse1;
	}
	
	public Color getSecondDiffuse(){
		return diffuse2;
	}
	
	public Color getSpecular(Vec3 uv) {
		return specular;
	}
}
