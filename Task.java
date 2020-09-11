package organisationsprogramm_v2_java;

import java.util.Scanner;

/**
 * @author Max Weise
 * 
 *         Created on 04.09.2020 Class to model all the given tasks in the
 *         program.
 */
class Task implements I_Time {

	String name;
	char module;
	int time;
	boolean work_in_progress;
	int priority;

	public Task() {
		// Empty constrctor
	}

	public Task(String name, int time, boolean wip, int priority) {
		this();
		this.name = this.setName(name);
		this.module = '-';
		this.time = time;
		this.work_in_progress = wip;
		this.priority = priority;
	}

	public Task(String name, char module, int time, boolean wip, int priority) {
		this.name = this.setName(name);
		this.module = setModule(module);
		this.time = time;
		this.work_in_progress = wip;
		this.priority = priority;
	}

	/**
	 * Sets name for task. (May not contain spaces, but has yet to be implemented)
	 * 
	 * @param nameToChange (Will later be processed for spaces)
	 * @return nameToChange
	 */
	String setName(String nameToChange) {
		return nameToChange;
	}

	char setModule(char moduleToChange) {
		if (!(moduleToChange == 'p' || moduleToChange == 'c' || moduleToChange == 'd')) {
			return '-';
		} else {
			return moduleToChange;
		}
	}

	/**
	 * Used to measure time in milliseconds, ms gets converted into seconds. Time
	 * gets started automatically, when key is pressed time will stop and measured
	 * time gets added to total time spent on Task
	 * 
	 * @return time passed in seconds
	 */
	@SuppressWarnings("resource")
	public void stopwatch() {
		int seconds = 0;
		long t0 = 0;
		long t1 = 0;

		System.out.println("Started stopwatch");

		t0 = System.currentTimeMillis();

		System.out.println("Press enter to stop the stopwatch");
		Scanner endStopwatch = new Scanner(System.in);
		String a = endStopwatch.nextLine();

		if (a == "") { // Stop time when key is pressed
		}

		t1 = System.currentTimeMillis();

		seconds = (int) (t1 - t0) / 1000;
		this.time += seconds;
		System.out
				.println("Time spent: " + I_Time.timeDelta(seconds) + " | Total time: " + I_Time.timeDelta(this.time));
		return;
	}

	/**
	 * overrides build in toString method
	 * 
	 * @return Task in following format: [priority] name (module | time )
	 */
	@Override
	public String toString() {
		String output = String.format("[%d] %s (%c |T: %s)", this.priority, this.name, this.module,
				I_Time.timeDelta(this.time));
		return output;
	}
} // End of Class