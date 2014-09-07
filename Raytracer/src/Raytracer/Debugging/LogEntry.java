package Raytracer.Debugging;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LogEntry {
	public Instant timeOfEntry;
	public String name;
	
	private LocalDateTime time;
	
	public LogEntry(String name) {
		this.name = name;
		timeOfEntry = Instant.now();
		time = LocalDateTime.ofInstant(timeOfEntry, ZoneId.systemDefault());
	}
	
	public String toString(){
		String date = time.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
		
		return "[" + date + "]" + "\t" + name;
	}
}
