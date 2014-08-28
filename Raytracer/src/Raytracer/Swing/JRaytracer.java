package Raytracer.Swing;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Raytracer.Camera;
import Raytracer.Scene;


/**
 * A custom JFrame that contains a JRaytracerViewport. Allows for easy usage of
 * the raytracing library.
 */
public class JRaytracer extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = -6839601427355790643L;
	
	private JRaytracerViewport viewport;
	private GraphicsDevice monitor;
	private GraphicsEnvironment localGE;
	
	private Dimension resolution;
	
	private boolean fullscreen = false;
	
	private Scene lastScene;
	private Camera lastCam;
	
	public JRaytracer(String title, int width, int height){
		this(title, new Dimension(width, height));
	}
	
	public JRaytracer(String title, Dimension resolution){
		super();
		
		localGE = GraphicsEnvironment.getLocalGraphicsEnvironment();
		monitor = localGE.getDefaultScreenDevice();
		
		this.resolution = resolution;
		viewport = new JRaytracerViewport(resolution);
		this.add(viewport);
		
		this.addKeyListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);

		setResizable(false);
		setFocusable(true);
		
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

	public void render(Scene scene, Camera cam) {
		// store last used scene and camera in the event the screen goes fullscreen and a rerender is needed
		lastScene = scene;  lastCam = cam;  
		
		long elapsedTime = System.nanoTime();
		viewport.render(scene, cam);
		long frameTime = System.nanoTime() - elapsedTime;
		
		double seconds = frameTime * 1e-9;
		
		setTitle(getTitle() + "  Render Time: " + String.format("%.4f",seconds) + "s");
		setTitle(getTitle() + "  Frame Rate: " + String.format("%.4f",1/seconds) + " FPS");
	}
	
	public boolean isFullscreen() { return fullscreen; }

	public void switchFullscren(){
		dispose(); // Make frame undisplayable to allow for decoration change
		if (fullscreen) // go windowed
		{
			setUndecorated(false);
			monitor.setFullScreenWindow(null);
			viewport.setPreferredSize(resolution);
		} 
		else // go fullscreen
		{
			setUndecorated(true);
			monitor.setFullScreenWindow(this);
			viewport.setPreferredSize(getContentPane().getSize()); // get the fullscreen resolution now
		}
		setVisible(true);
		viewport.render(lastScene, lastCam);
		fullscreen = !fullscreen;
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_ENTER:
			{
				if (e.isAltDown()) switchFullscren();
			}
			
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}	
}
