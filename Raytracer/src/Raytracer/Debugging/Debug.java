package Raytracer.Debugging;

import java.text.NumberFormat;

public class Debug {
	public static boolean consoleEnabled = true;
	public static boolean loggingEnabled = true;
	
	public static final Log LOG = new Log("Java-Raytracer Debug Log");
	
	public static int raysCasted = 0;
	
	private static NumberFormat formatter = NumberFormat.getInstance();
	
	public static void write(Object obj){
		if (!consoleEnabled) return;
		
		System.out.println(obj);
	}
	
	public static void writeLog(){
		LOG.addFootNote("Rays casted: " + formatter.format(raysCasted));
		
		write(LOG);
	}
	
}
