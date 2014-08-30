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
	
	public FlatColor(Color diffuse){
		this(Color.BLACK, diffuse, Color.WHITE);
	}
	
	public FlatColor(Color ambient, Color diffuse, Color specular){
		this.ambient = ambient;  this.diffuse = diffuse;  this.specular = specular;
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
		// TODO Auto-generated method stub
		return 0;
	}

	public double getShininess(Vec3 point) {
		// TODO Auto-generated method stub
		return 0;
	}

}
