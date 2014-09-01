package Raytracer.Renderers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;

import Raytracer.Core.Camera;
import Raytracer.Core.Debug;
import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Math.Vec2;

public class SimpleRenderer {
	private int width, height;
	private double ratio;
	
	private int samples, sqrtSamples;
	private double subPixelSize;
	
	private int threadCount, threadRenderHeight;

	private int raysCasted = 0;
	
	/**
	 * Constructs a SimpleRenderer with a given resolution and
	 * number of samples. The number of samples must be a perfect square
	 * as to properly subdivide a pixel (which we assume to be 1x1 units)
	 */
	public SimpleRenderer(Dimension resolution, int samples, int threadCount){
		this.width = resolution.width;  this.height = resolution.height;
		this.ratio = (double)width / height;
		
		setThreadCount(threadCount);
		setSamples(samples);

	}
	
	/**
	 * Renders a scene using the provided camera.
	 */
	public Image render(Scene scene, Camera cam){
		NumberFormat formatter = NumberFormat.getInstance();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Vec2 coords = new Vec2(0,0);
		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				double ndcX = ((double)x / width * 2 - 1) * ratio * cam.getFovMultipler();
				double ndcY = ((double)(height-y) / height * 2 - 1) * cam.getFovMultipler();
				coords.set(ndcX, ndcY);
				
				Ray camRay = cam.getRay(ndcX, ndcY);
				
				RaycastResult result = scene.raycast(camRay);
				raysCasted++;
				
				Color pixelColor = scene.getColor(result, cam, coords).toAwtColor();
				image.setRGB(x, y, pixelColor.getRGB());
			}
		}
		
		Debug.Write(formatter.format(raysCasted));
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
	
	public int getThreadCount() { return threadCount; }
	
	public void setThreadCount(int threadCount){
		this.threadCount = threadCount;
		
	}
}
