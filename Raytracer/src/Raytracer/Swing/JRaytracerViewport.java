package Raytracer.Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import Raytracer.Core.Camera;
import Raytracer.Core.Scene;
import Raytracer.Renderers.SimpleRenderer;

public class JRaytracerViewport extends JComponent {
		
		private static final long serialVersionUID = 1L;
		
		private Image image; // the render from the SimpleRenderer 
		private SimpleRenderer renderer;
		private Dimension resolution;
		
		public JRaytracerViewport(Dimension res){
			super();
			setPreferredSize(res);
			resolution = res;
			
			image = getWaitImage();
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}
		
		public void render(Scene scene, Camera cam){
			image = getWaitImage("Please wait: Now rendering...");
			super.repaint();
			
			image = renderer.render(scene, cam);
			super.repaint();
		}
		
		private Image getWaitImage(){
			return getWaitImage("");
		}
		
		private Image getWaitImage(String string) {
			image = new BufferedImage(resolution.width, resolution.height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, resolution.width, resolution.height);
			
			int size = (resolution.width + resolution.height) / 50;
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, size);
			
			g.setColor(Color.WHITE);
			g.setFont(font);
			
			g.drawString(string, 15, resolution.height-15);
			return image;
		}

		public void setPreferredSize(Dimension resolution){
			super.setPreferredSize(resolution);
			this.resolution = resolution;
			renderer = new SimpleRenderer(resolution, 1, 4);
		}
		
		

}
