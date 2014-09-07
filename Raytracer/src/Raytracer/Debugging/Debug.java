package Raytracer.Debugging;

import java.text.NumberFormat;

import Raytracer.Core.Scene;

public class Debug {
	public static boolean consoleEnabled = true;
	public static boolean loggingEnabled = true;
	
	public static final Log LOG = new Log("Java-Raytracer Debug Log");
	
	public static int raysCasted = 0;
	public static Scene lastSceneRendered = new Scene("No scene rendered");
	
	private static NumberFormat formatter = NumberFormat.getInstance();
	
	public static void write(Object obj){
		if (!consoleEnabled) return;
		
		System.out.println(obj);
	}
	
	public static void writeLog(){
		LOG.footNote("Scene rendered: " + lastSceneRendered.name);
		LOG.footNote("Rays casted: " + formatter.format(raysCasted));
		
		write(LOG);
	}
	
}
