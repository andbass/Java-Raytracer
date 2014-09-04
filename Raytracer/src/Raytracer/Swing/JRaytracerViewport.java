package Raytracer.Swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Math.Color;
import Raytracer.Renderers.SimpleRenderer;
import Raytracer.Sampling.Sampler;


public class JRaytracerViewport extends JComponent {
		
		private static final long serialVersionUID = 1L;
		
		private BufferedImage image; // the render from the SimpleRenderer 
		private SimpleRenderer renderer;
		private Dimension resolution;
		
		private int threadCount;
		
		private Sampler sampler;
		
		public JRaytracerViewport(Dimension res, Sampler sampler, int threadCount){
			super();
			this.sampler = sampler;  this.threadCount = threadCount;
			setPreferredSize(res);
			resolution = res;
			
			image = getWaitImage();
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}
		
		// TODO Fix fullscreen
		public void render(Scene scene, Camera cam){
			image = getWaitImage("Please wait: Now rendering...");
			this.repaint();
			
			int height = getHeight();
			int width = getWidth();
			
			for (int y = 0; y < height; y++)
			{
				for (int x = 0; x < width; x++)
				{
					Color pixelColor = renderer.getPixel(x, y, scene, cam);
					image.setRGB(x, y, pixelColor.getRGB());
					repaint();
				}
			}
		}
		
		private BufferedImage getWaitImage(){
			return getWaitImage("");
		}
		
		private BufferedImage getWaitImage(String string) {
			image = new BufferedImage(resolution.width, resolution.height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.setColor(Color.BLACK.toAwtColor());
			g.fillRect(0, 0, resolution.width, resolution.height);
			
			int size = (resolution.width + resolution.height) / 50;
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, size);
			
			g.setColor(Color.WHITE.toAwtColor());
			g.setFont(font);
			
			g.drawString(string, 15, resolution.height-15);
			return image;
		}

		public void setPreferredSize(Dimension resolution){
			super.setPreferredSize(resolution);
			this.resolution = resolution;
			
			renderer = new SimpleRenderer(resolution, sampler, threadCount);
		}
		
		

}
