package Raytracer.Debugging;

import java.time.Instant;
import java.time.Duration;
import java.time.LocalTime;


/**
 * This class functions identical to a LogEntry with a twist, it can keep track of how long an
 * entry took to complete or to terminate.  This is used to measure how long parts of a program take to
 * complete.
 */
public class LogTimedEntry extends LogEntry {

	private long startTime;
	private long endTime;
	
	public LogTimedEntry(String name) {
		super(name);
		startTime = System.nanoTime();
	}
	
	public void finish(){
		endTime = System.nanoTime();	
	}
	
	public String toString(){
		long nano = endTime - startTime;
		String sec = String.format("%.5g", nano * 1e-9);
		
		return super.toString() + " - " + sec + "s";
	}
	
}
