package organisationsprogramm_v2_java;

import java.util.ArrayList;
import java.util.Scanner; // Import for user input

public class controller {

	// Static reference used as global variables
	static ArrayList<Task> taskCollection = new ArrayList<Task>();

	public static void main(String[] args) {

		/**
		 * Three steps:
		 * 		1. Load saved data
		 * 		2. Interact with program
		 * 		3. Save all relevant data
		 */

		// Necessary declarations here

		// TODO: Load data here

		// ==========================================

		// TODO: Implement programm here

		boolean CONTINUE = true;
		Scanner user = new Scanner(System.in);

		do {

			printList();
			System.out.println("Please enter command:");
			String userInput = user.nextLine().toLowerCase();

			// Keywords / Methods get selected here
			switch (userInput) {
			case "new":
				// TODO: implement task construction
				// Scanner userData_name = new Scanner(System.in);
				// Scanner userData_module = new Scanner(System.in);
				//
				// System.out.println("Please enter name of task:");
				// String taskName = userData_name.nextLine();
				//// char taskModule = userData_module.nextLine();

				// taskCollection.add(t = new Task(taskName, taskModule, 0,
				// false, 0));
				break;

			case "delete":
				// TODO: implement task destruction
				break;

			case "work":
				// TODO: implement code to work on task
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
		user.close();

	} // End of main

	static void printList() {
		for (Task a : taskCollection) {
			System.out.println(a);
		}
	}

} // End of Class
