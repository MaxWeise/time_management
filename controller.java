package organisationsprogramm_v2_java;

import java.util.ArrayList;
import java.util.Scanner; // Import for user input

public class controller {

	// Static reference used as global variables
	static ArrayList<Task> toDoList = new ArrayList<Task>();
	static boolean CONTINUE = true;
	static int totalTime = 0; // in s

	public static void main(String[] args) {

		// Default tasks
		// solved
		Task x = new Task("x", 0, false, 0);
		toDoList.add(x);
		Task y = new Task("y", 'p', 0, false, 0);
		toDoList.add(y);
		Task z = new Task("z", 'a', 0, false, 0);
		toDoList.add(z);
		/**
		 * Three steps:
		 * 		1. Load saved data
		 * 		2. Interact with program
		 * 		3. Save all relevant data
		 */

		// TODO: Load data here

		// ==========================================

		// TODO: Implement program here

		do {

			// Update total time
			totalTime = 0;
			for (Task t : toDoList) {
				totalTime += t.time;
			}

			@SuppressWarnings("resource")
			Scanner user = new Scanner(System.in);

			if (toDoList.isEmpty()) {
				System.out.println("There are no tasks in this List");
			} else {
				printToDoList(); // print taskCollection
			}

			System.out.println("\nPlease enter command: ");
			String userInput = user.nextLine().toLowerCase();

			// Keywords / Methods get selected here
			switch (userInput) {
			case "new":
				Scanner S_name = new Scanner(System.in);
				System.out.println("Please enter name of task:");
				String n = S_name.nextLine();

				System.out.println("Please enter module of task (p | c | d):");
				Scanner S_module = new Scanner(System.in);
				char m = S_module.next().charAt(0);

				System.out.println("Please enter priority (-1 | 0 | 1):");
				Scanner S_priority = new Scanner(System.in);
				int p = S_priority.nextInt();

				Task newTask = new Task(n, m, 0, false, p);

				toDoList.add(newTask);

				break;

			case "delete":
				if (deleteTask()) {
					System.out.println("Task has been sucessfully removed");
				} else {
					System.out.println("Something went wrong!\nPlease try again.");
				}

				break;

			case "work":
				// TODO: implement code to work on task
				System.out.println("Please enter name of Task:");
				Scanner input_name = new Scanner(System.in);
				String element = input_name.next();

				for (Task workTask : toDoList) {
					if (workTask.name.equalsIgnoreCase(element)) {
						workTask.stopwatch();
					}
				}

				break;

			case "exit":
				CONTINUE = false;
				break;

			default:
				System.out.println("Invalid input, please try again\n");
			}

		} while (CONTINUE);

		// ==========================================

		// TODO: Save data here

		System.out.println("END");

	} // End of main

	/** Auxiliary function to easily print all the Task elements in the Task list */
	static void printToDoList() {
		for (Task a : toDoList) {
			System.out.println(a);
		}

		System.out.println("\nTotal time " + I_Time.timeDelta(totalTime));
		System.out.println("=======================");
	}

	@SuppressWarnings("resource")
	static boolean deleteTask() {
		System.out.println("Please enter name of Task to delete:");
		Scanner input_name = new Scanner(System.in);
		String delete_element = input_name.next();

		for (Task a : toDoList) {
			if (a.name.equalsIgnoreCase(delete_element)) {
				toDoList.remove(a);
				return true;
			}
		}

		return false;
	}

} // End of Class
