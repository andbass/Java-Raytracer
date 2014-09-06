package Raytracer.Materials;

import java.awt.image.BufferedImage;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Texture extends Material {
	
	private BufferedImage tex;
	private Color specular;
	private double ambientMultipler;
	
	// TODO Add loading images from filepaths
	
	public Texture(String filePath){
		this(filePath, Color.WHITE);
	}
	
	public Texture(String filePath, Color specular){
		super(Material.DEFAULT_SHININESS, Material.DEFAULT_REFLECTIVITY);
	}
	
	public Texture(BufferedImage tex){
		this(tex, Material.DEFAULT_SHININESS, Material.DEFAULT_REFLECTIVITY);
	}
	
	public Texture(BufferedImage tex, Color specular){
		this(tex, specular, Material.DEFAULT_SHININESS, Material.DEFAULT_REFLECTIVITY);
	}
		
	public Texture(BufferedImage tex, double shiniess, double reflectivity){
		this(tex, Color.WHITE, shiniess, reflectivity);
	}
	
	public Texture(BufferedImage tex, Color specular, double shininess, double reflectivity){
		this(tex, 0.01, specular, shininess, reflectivity);
	}
	
	public Texture(BufferedImage tex, double ambientMultipler, Color specular, double shininess, double reflectivity){
		super(shininess, reflectivity);
		this.tex = tex;
		this.ambientMultipler = ambientMultipler;
		this.specular = specular;
	}

	public Color getAmbient(Vec3 uv) {
		return getColorFromTexture(uv.x, uv.y).scale(ambientMultipler);
	}

	public Color getDiffuse(Vec3 uv) {
		return getColorFromTexture(uv.x, uv.y);
	}

	public Color getSpecular(Vec3 uv) {
		return specular;
	}
	
	public void setSpecular(Color specular){
		this.specular = specular;
	}
	
	public void setImage(BufferedImage image) { this.tex = image; }
	
	// TODO Set image from filepath
	public void setImage(String filePath) { }
	
	private Color getColorFromTexture(double x, double y){
		int sX = (int)(x*tex.getWidth());
		int sY = (int)(y*tex.getHeight());
		
		return new Color(tex.getRGB(sX, sY));
	}
}
