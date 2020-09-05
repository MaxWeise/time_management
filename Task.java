package organisationsprogramm_v2_java;

import java.util.Scanner;

// import org.apache.commons.lang.time.StopWatch;

/**
 * @author Max Weise
 * 
 * Created on 04.09.2020
 * Class to model all the given tasks in the programm.
 */
class Task {

	/**
	 * name     -> descriptive name of the task
	 * module   -> code, plan, debug
	 * time     -> time in seconds, total time spent on task
	 * wip      -> is task in progress?
	 * priority -> -1, 0, 1; 0 is normal, the higher, the more important
	 */

	String name;
	char module;
	int time;
	boolean work_in_progress;
	int priority;

	public Task(String name, char module, int time, boolean wip, int priority) {
		this.name = this.setName(name);
		this.module = module;
		this.time = time;
		this.work_in_progress = wip;
		this.priority = priority;
	}

	/**
	 * Sets name for task. (May not contain spaces, but has yet to be implemented)
	 * @param nameToChange (Will later be processed for spaces)
	 * @return nameToChange
	 */
	String setName(String nameToChange) {
		return nameToChange;
	}

	/**
	 * Used to measure time in milliseconds, ms gets converted into seconds. 
	 * @return time passed in seconds
	 */
	int stopwatch() {
		int seconds = 0;
		long t0 = 0;
		long t1 = 0;
		
		System.out.println("Started stopwatch");
		
		t0 = System.currentTimeMillis();
		
		System.out.println("Type <end> to stop the stopwatch");
		Scanner endStopwatch = new Scanner(System.in);
		String a = endStopwatch.nextLine();
		
		if(a == "")
		
		endStopwatch.close();
		t1 = System.currentTimeMillis();
			
		seconds = (int) (t1 - t0) / 1000;
		this.time += seconds;
		
		return seconds;
	}

	/**
	 * overrides build in toString method 
	 * @return Task in following format: [priority] name (module | time )
	 */
	@Override
	public String toString() {
		return "[" + this.priority + "] " + this.name + " (" + this.module + "| T: " + this.time + " )";

	}
} // End of Class