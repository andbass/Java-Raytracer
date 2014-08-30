package Raytracer.Core;

public class Debug {
	public static boolean CONSOLE_ENABLED = true;
	
	public static void Write(Object obj){
		if (!CONSOLE_ENABLED) return;
		
		System.out.println(obj);
	}
	
	
	
	
}
