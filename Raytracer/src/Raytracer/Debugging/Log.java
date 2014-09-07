package Raytracer.Debugging;

import java.util.ArrayList;
import java.util.List;

import Raytracer.Swing.JLogViewer;

public class Log {
	public String name;
	private String footNote = "";
	private List<LogEntry> entries;
	
	private List<LogTimeEntry> trackedEntries;
	private int depth = -1;
	
	private JLogViewer logViewer;
	
	public Log(String name){
		this(name, true);
	}
	
	public Log(String name, boolean useLogViewer){
		this.name = name;
		entries = new ArrayList<LogEntry>();
		trackedEntries = new ArrayList<LogTimeEntry>();
	}
	
	public void add(Object obj){
		entries.add(new LogEntry(obj.toString()));
		updateLogViewer();
	}
	
	public void start(Object obj){
		LogTimeEntry entry = new LogTimeEntry(obj.toString());
		entries.add(entry);
		trackedEntries.add(entry);
		depth++;
		
		updateLogViewer();
	}

	public void end(){
		trackedEntries.get(depth).finish();
		trackedEntries.remove(depth);
		
		depth--;
		updateLogViewer();
	}
	
	public void footNote(String note) { this.footNote += note + "\n"; }
	
	private void updateLogViewer() { this.logViewer.contents.setText(this.toString()); }
	
	public String toString(){
		String contents = "";
		
		for (LogEntry entry : entries){
			contents += entry + "\n";
		}
		
		return 	"-- " + name + " --" + "\n" + contents + "\n" + footNote + "\n" + "-- End of " + name + " --";
	}
	
	public void setLogViewer(JLogViewer logViewer) {
		logViewer.setTitle(name);
		this.logViewer = logViewer;
	}
}
