package Raytracer.Swing;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Raytracer.Math.Color;

public class JLogViewer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea contents;
	private Dimension resolution;
	
	public JLogViewer(int width, int height) { this(new Dimension(width, height)); }
	
	public JLogViewer(Dimension resolution){
		super();
		this.resolution = resolution;


		
		contents = new JTextArea();
		contents.setEditable(false);
		contents.setPreferredSize(resolution);
		contents.setPreferredSize(resolution);
		contents.setBorder(new EmptyBorder(10,10,10,10));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(contents);
		this.pack();
		this.setVisible(true);
	}

}
