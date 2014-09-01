package Raytracer.Debugging;

import java.text.NumberFormat;

public class Debug {
	public static boolean consoleEnabled = true;
	public static boolean loggingEnabled = true;
	
	public static final Log LOG = new Log();
	public static int raysCasted;
	
	public static void Write(Object obj){
		if (!consoleEnabled) return;
		
		System.out.println(obj);
	}

	
}
