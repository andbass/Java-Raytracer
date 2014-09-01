package Raytracer.Debugging;

import java.time.Instant;
import java.time.Duration;


/**
 * This class functions identical to a LogEntry with a twist, it can keep track of how long an
 * entry took to complete or to terminate.  This is used to measure how long parts of a program take to
 * complete.
 */
public class LogTimedEntry extends LogEntry {

	public Instant startTime;
	public Instant finishTime;
	
	public Duration duration;
	
	public LogTimedEntry(String name) {
		super(name);
		startTime = Instant.now();
	}
	
	public void finish(){
		finishTime = Instant.now();
		duration = Duration.ofNanos(finishTime.getNano() - startTime.getNano());
	}
	
	public String toString(){
		return super.toString() + " - " + (duration.toMillis() * 1e-3);
	}
	
}
