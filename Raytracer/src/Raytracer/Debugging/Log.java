package Raytracer.Debugging;

import java.util.ArrayList;
import java.util.List;

public class Log {
	private String name;
	private String footNote = "";
	private List<LogEntry> entries;
	
	private LogTimedEntry lastTimedEntry;
	
	public Log(String name){
		this.name = name;
		entries = new ArrayList<LogEntry>();
	}
	
	public void add(String name){
		entries.add(new LogEntry(name));
	}
	
	public void start(String name){
		lastTimedEntry = new LogTimedEntry(name);
		entries.add(lastTimedEntry);
	}
	
	public void end(){
		lastTimedEntry.finish();
	}
	
	public void addFootNote(String note) { this.footNote += note + "\n"; }
	
	public String toString(){
		String contents = "";
		
		for (LogEntry entry : entries){
			contents += entry + "\n";
		}
		
		return 	"-- " + name + " --" + "\n" + contents + "\n" + footNote + "\n" + "-- End of " + name + " --";
	}
}
