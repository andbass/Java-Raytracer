package Raytracer.Debugging;

import java.time.Instant;

public class LogEntry {
	public Instant timeOfEntry;
	public String name;
	
	public LogEntry(String name) {
		this.name = name;
		timeOfEntry = Instant.now();
	}
	
	public String toString(){
		return timeOfEntry.toString() + "\t" + name;
	}
}
