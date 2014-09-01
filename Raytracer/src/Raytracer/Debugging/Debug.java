package Raytracer.Debugging;

import java.text.NumberFormat;

public class Debug {
	public static boolean consoleEnabled = true;
	public static boolean loggingEnabled = true;
	
	public static final Log LOG = new Log("Java-Raytracer Debug Log");
	public static int raysCasted;
	
	public static void write(Object obj){
		if (!consoleEnabled) return;
		
		System.out.println(obj);
	}
	
	
	public static void writeLog(){
		if (!consoleEnabled) return;
		
		System.out.println(LOG);
	}

	
}
