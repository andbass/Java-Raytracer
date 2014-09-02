package Raytracer.Renderers;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Raytracer.Core.Camera;
import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Sampling.Sampler;

public class SimpleRenderer {
	private int width, height;
	private double ratio;
	
	private int threadCount, threadRenderHeight;
	
	/**
	 * Constructs a SimpleRenderer with a given resolution and
	 * number of samples. The number of samples must be a perfect square
	 * as to properly subdivide a pixel (which we assume to be 1x1 units)
	 */
	public SimpleRenderer(Dimension resolution, Sampler sampler, int threadCount){
		this.width = resolution.width;  this.height = resolution.height;
		this.ratio = (double)width / height;
		
		setThreadCount(threadCount);
	}
	
	/**
	 * Renders a scene using the provided camera.
	 */
	public Image render(Scene scene, Camera cam){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Vec2 coords = new Vec2(0,0);
		
		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				Color pixelColor = Color.BLACK;
				double sX = (double)x / width;
				double sY = (double)(height - y) / height;
				
				double ndcX = (sX * 2 - 1) * ratio * cam.getFovMultipler();
				double ndcY = (sY * 2 - 1) * cam.getFovMultipler();
				coords.set(sX*ratio, sY);
				
				Ray camRay = cam.getRay(ndcX, ndcY);
				
				RaycastResult result = scene.raycast(camRay);
						
				pixelColor = pixelColor.add(scene.getColor(result, cam, coords));
				image.setRGB(x, y, pixelColor.toAwtColor().getRGB());
			}
		}
		return image;
	}
	
	
	public int getThreadCount() { return threadCount; }
	
	public void setThreadCount(int threadCount){
		this.threadCount = threadCount;
		
	}
}
