package Raytracer.Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Raytracer.Debugging.Log;

public class JLogViewer extends JFrame implements ActionListener {


	public JTextArea contents;
	
	private Log log;
	
	private Timer updateTimer; 
	
	public JLogViewer(Log log){
		this(log, 500);
	}
	
	public JLogViewer(Log log, int refreshRate){
		super(log.name);

		this.log = log;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contents = new JTextArea();
		contents.setPreferredSize(new Dimension(480, 320));
		contents.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.add(contents);
		
		updateTimer = new Timer(refreshRate, this);
		updateTimer.start();
		
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		contents.setText(log.toString());
	}
}
