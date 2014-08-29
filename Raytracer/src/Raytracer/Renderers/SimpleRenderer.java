package Raytracer.Renderers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Raytracer.Camera;
import Raytracer.Ray;
import Raytracer.RaycastResult;
import Raytracer.Scene;

public class SimpleRenderer {
	private int width, height;
	private double ratio;
	
	private int samples, sqrtSamples;

	//private double subPixelSize;
	
	/*
	 * Construct a SimpleRenderer with a given resolution and
	 * number of samples. The number of samples must be a perfect square
	 * as to properly subdivide a pixel (which we assume to be 1x1 units)
	 */
	public SimpleRenderer(Dimension resolution, int samples){
		this.width = resolution.width;  this.height = resolution.height;
		this.ratio = (double)width / height;
		setSamples(samples);

	}
	
	/**
	 * Renders the objects in a scene using the provided camera.
	 */
	public Image render(Scene scene, Camera cam){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				double ndcX = ((double)x / width * 2 - 1) * ratio * cam.getFovMultipler();
				double ndcY = ((double)(height-y) / height * 2 - 1) * cam.getFovMultipler();
				
				Ray camRay = cam.getRay(ndcX, ndcY);
				
				RaycastResult result = scene.raycast(camRay);
				Color pixelColor = scene.getColor(result, ndcX, ndcY).toAwtColor();
				image.setRGB(x, y, pixelColor.getRGB());
			}
		}
		
		return image;
	}
	
	public int 	getSamples() { return this.samples; }
	
	public void setSamples(int samples) { 
		this.sqrtSamples = (int)Math.sqrt(samples);
		
		if (sqrtSamples*sqrtSamples != samples){  			
			throw new IllegalArgumentException("The number of samples to be a perfect square, as the supersampling uses a square grid to cast additional rays");
		}
		this.samples 		= samples;
	//	this.subPixelSize 	= 1.0 / sqrtSamples; 
	}
}
