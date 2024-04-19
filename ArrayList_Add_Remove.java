import java.util.*;

public class ArrayList_Add_Remove {
	
	static Scanner input = new Scanner (System.in);
	static ArrayList <String> id = new ArrayList <>();
	
	public static void main(String[] args) {
		System.out.println("ArrayList - add/remove test. CS211 Winter 2024\n");
		initialized ();
		select();
	}
	
	public static void initialized () {
		id.add("a");
		id.add("b");
		id.add("c");
	}
	
	public static void showList () {
		System.out.println("Current List: " + id);
	}
	
	public static void select () {
		
		showList ();
		
		while (true) {
		
			try {
				
				System.out.println("Choose one: 1. add   2. remove   3. quit");
				int number = input.nextInt();
				
				if (number == 1) {
					addArray();
					
				} else if (number == 2) {
					removeArray ();
					
				} else if (number == 3) {
					System.out.println("bye!");
					break;
					
				} else {
					System.out.println("you can only choose between 1 and 3 \n");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("must input digit \n");
				input.nextLine();
			} 
		}
		
	}
	

    // Bonus Practice
	public static void addArray() {
		System.out.println("Enter a new ID:");
		String newID = input.next();

		// Check if the ID already exists in the ArrayList
		if (id.contains(newID)) {
			System.out.println(newID + " already exists in the list. No changes made.\n");
		} else {
			id.add(newID);
			System.out.println(newID + " successfully added to the list.\n");
		}

		showList();
	}
	
	// Bonus Practice
	public static void removeArray() {
		System.out.println("which ID do you want to remove?");
		
		// Check if the ArrayList is empty
		if (id.isEmpty()) {
			System.out.println("The list is already empty. Nothing to remove.\n");
		} else {
			String deleteID = input.next();

			// Check if the ID to be removed exists in the ArrayList
			if (id.contains(deleteID)) {
				id.remove(deleteID);
				System.out.println(deleteID + " successfully removed.\n");
			} else {
				System.out.println(deleteID + " not found in the list. No changes made.\n");
			}

			showList();
		}
	}
}
