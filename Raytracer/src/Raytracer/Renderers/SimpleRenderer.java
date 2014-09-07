package Raytracer.Renderers;

import Raytracer.BRDFs.BRDF;
import Raytracer.Core.Camera;
import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Sampling.Sampler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class SimpleRenderer implements Serializable {
	private int width, height;
	private double ratio;
	
	private Sampler sampler;
	private BRDF brdf;
	
	private int threadCount, threadRenderHeight;
	private int samples, sqrtSamples;
	
	/**
	 * Constructs a SimpleRenderer with a given resolution and
	 * number of samples. The number of samples must be a perfect square
	 * as to properly subdivide a pixel (which we assume to be 1x1 units)
	 */
	public SimpleRenderer(Dimension resolution, BRDF brdf, Sampler sampler, int threadCount){
		this.width = resolution.width;  this.height = resolution.height;
		this.sampler = sampler;
		this.brdf = brdf;
		this.samples = sampler.getSamples();  this.sqrtSamples = (int)Math.sqrt(samples);
		this.ratio = (double)width / height;
		
		setThreadCount(threadCount);
	}
	
	/**
	 * Renders a scene using the provided camera.
	 */
	public Image render(Scene scene, Camera cam){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				Color pixelColor = getPixel(x, y, scene, cam);
				image.setRGB(x, y, pixelColor.getRGB());
			}
		}
		return image;
	}
	
	public Color getPixel(int x, int y, Scene scene, Camera cam){
		Color pixelColor = Color.BLACK;
		Vec2 coords = new Vec2(0,0);
		
		for (int sample = 1; sample <= samples; sample++){
			Vec2 mod = sampler.getModXY(1, 1);
			
			double tX = x + mod.x;
			double tY = y + mod.y;
			
			double sX = (double)tX / width;
			double sY = (double)(height - tY) / height;
			
			double ndcX = (sX * 2 - 1) * ratio * cam.getFovMultipler();
			double ndcY = (sY * 2 - 1) * cam.getFovMultipler();
			coords.set(sX*ratio, sY);
			
			Ray camRay = cam.getRay(ndcX, ndcY);
			
			RaycastResult result = scene.raycast(camRay);
					
			pixelColor = pixelColor.add(brdf.getColor(result, scene, cam, coords));
		}
		pixelColor = pixelColor.descale(samples);
		return pixelColor;
	}
	
	
	public int getThreadCount() { return threadCount; }
	
	public void setThreadCount(int threadCount){
		this.threadCount = threadCount;
		
	}
}
