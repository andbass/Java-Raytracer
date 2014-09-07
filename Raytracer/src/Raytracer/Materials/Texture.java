package Raytracer.Materials;

import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Texture extends Material implements Serializable {
	

	private BufferedImage tex;
	private Color specular;
	private double ambientMultipler;
	
	public Texture(String filePath){
		this(filePath, Color.WHITE);
	}
	
	public Texture(String filePath, Color specular){
		super(Material.DEFAULT_SHININESS, Material.DEFAULT_REFLECTIVITY);

		setImage(filePath);
		this.ambientMultipler = 0.01;
		this.specular = specular;
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
	
	public void setImage(String filePath){
		BufferedImage texture = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		try {
			texture = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.tex = texture;
	}
	
	private Color getColorFromTexture(double x, double y){
		int sX = (int)(x*tex.getWidth());
		int sY = (int)(y*tex.getHeight());

		return new Color(tex.getRGB(sX, sY));
	}
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
	    out.writeObject(specular);
	    out.writeDouble(ambientMultipler);
	    ImageIO.write(tex,"png",ImageIO.createImageOutputStream(out));
  	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
	  	specular=(Color)in.readObject();
	  	ambientMultipler = in.readDouble();
	    tex=ImageIO.read(ImageIO.createImageInputStream(in));
	}
}
