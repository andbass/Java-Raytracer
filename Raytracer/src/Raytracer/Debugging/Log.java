package Raytracer.Debugging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Log {
	private String name;
	private String footNote = "";
	private List<LogEntry> entries;
	
	private List<LogTimeEntry> trackedEntries;
	private int depth = -1;
	
	public Log(String name){
		this.name = name;
		entries = new ArrayList<LogEntry>();
		trackedEntries = new ArrayList<LogTimeEntry>();
	}
	
	public void add(String name){
		entries.add(new LogEntry(name));
	}
	
	public void start(String name){
		LogTimeEntry entry = new LogTimeEntry(name);
		entries.add(entry);
		trackedEntries.add(entry);
		depth++;
	}

	public void end(){
		trackedEntries.get(depth).finish();
		trackedEntries.remove(depth);
		
		depth--;
	}
	
	public void footNote(String note) { this.footNote += note + "\n"; }
	
	public String toString(){
		String contents = "";
		
		for (LogEntry entry : entries){
			contents += entry + "\n";
		}
		
		return 	"-- " + name + " --" + "\n" + contents + "\n" + footNote + "\n" + "-- End of " + name + " --";
	}
}
