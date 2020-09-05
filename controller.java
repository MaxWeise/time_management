package organisationsprogramm_v2_java;

import java.util.ArrayList;
import java.util.Scanner; // Import for user input

public class controller {

	// Static reference used as global variables
	static ArrayList<Task> taskCollection = new ArrayList<Task>();

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		//Default tasks | will be deleted as soon as t.name == input error is solved
		Task x = new Task("x", 'p', 0, false, 0);
		taskCollection.add(x);
		Task y = new Task("y", 'p', 0, false, 0);
		taskCollection.add(y);
		Task z = new Task("z", 'p', 0, false, 0);
		taskCollection.add(z);
		/**
		 * Three steps:
		 * 		1. Load saved data
		 * 		2. Interact with program
		 * 		3. Save all relevant data
		 */

		// Necessary declarations here

		// TODO: Load data here

		// ==========================================

		// TODO: Implement program here

		boolean CONTINUE = true;
		Scanner user = new Scanner(System.in);

		do {

			printList(); // print taskCollection
			System.out.println("Please enter command: ");
			String userInput = user.next().toLowerCase();

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

				Task t = new Task(n, m, 0, false, p);

				taskCollection.add(t);

				break;

			case "delete":
				// TODO: implement task destruction
				// TODO: name of task and input are not the same, why??

				// This is just a workaround
				Scanner input_index = new Scanner(System.in);
				for (int i = 0; i < taskCollection.size(); i++) {
					System.out.print((i + 1) + ":   ");
					System.out.println(taskCollection.get(i));
				}

				System.out.println("Please input number of task you want to delete:");
				int index = input_index.nextInt();

				taskCollection.remove(index - 1);

				// ==========================================

				// for (Task a : taskCollection) {
				// if (a.name == delete_element) {
				// taskCollection.remove(a);
				// break;
				// }
				// }
				//
				// System.out.println("Could not find task. Please try again");

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
