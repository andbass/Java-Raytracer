package Raytracer.Debugging;

import java.text.NumberFormat;

public class Debug {
	public static boolean CONSOLE_ENABLED = true;
	public static Log log;
	
	public static void Write(Object obj){
		if (!CONSOLE_ENABLED) return;
		
		System.out.println(obj);
	}

	
}
