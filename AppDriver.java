/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 18/07/2021
*/

// repo added to github
package cst8284.assignment2;

// calling scanner to use main loop of the program
import java.util.Scanner;

public class AppDriver {

// declaring AppDriver class instances, variables & methods based on UML Diagram

	private Scanner keyboard = new Scanner(System.in);

	private static final int APP_EXIT = 0;

	private static final int APP_ADD_BOOK = 1;

	private static final int APP_MOD_BOOK = 2;

	private static final int APP_FIND_BOOK = 3;

	private static final int APP_LIST_BOOKS = 4;

	private static final int APP_ADD_USER = 5;

	private static final int APP_MOD_USER = 6;

	private static final int APP_FIND_USER = 7;

	private static final int APP_LIST_USERS = 8;

	private static final int APP_ADD_LOAN = 9;

	private static final int APP_MOD_LOAN = 10;

	private static final int APP_FIND_LOAN = 11;

	private static final int APP_LIST_LOANS = 12;

	private static final int APP_DEL_BOOK = 13;
	private static final int APP_DEL_USER = 14;
	private static final int APP_DEL_LOAN = 15;

// calling LLC class to all methods of the library 
	public LendingLibraryController appControl = new LendingLibraryController(keyboard);

// creating a method for appControl which is in LendingLibraryController class.
	public LendingLibraryController appControl() {
		return appControl;
	}

// Based on the displayAppMenu below chosen, it executes the initial method requested by the user.
	public void executeMenuItem(int choice) {
		if (choice == APP_ADD_BOOK) {
			appControl.addBook();
		} else if (choice == APP_MOD_BOOK) {
			appControl.changeBook();
		} else if (choice == APP_FIND_BOOK) {
			appControl.findBook();
		} else if (choice == APP_LIST_BOOKS) {
			appControl.listBooks();
		} else if (choice == APP_ADD_USER) {
			appControl.addUser();
		} else if (choice == APP_MOD_USER) {
			appControl.changeUser();
		} else if (choice == APP_FIND_USER) {
			appControl.findUser();
		} else if (choice == APP_LIST_USERS) {
			appControl.listUsers();
		} else if (choice == APP_ADD_LOAN) {
			appControl.addBookLoan();
		} else if (choice == APP_MOD_LOAN) {
			appControl.changeBookLoan();
		} else if (choice == APP_FIND_LOAN) {
			appControl.findBookLoan();
		} else if (choice == APP_LIST_LOANS) {
			appControl.listBookLoans();
		}else if (choice == APP_DEL_USER) {
			appControl.deleteUser();
		 } else if (choice == APP_DEL_BOOK) {
			 appControl.deleteBook();
		 } else if (choice == APP_DEL_LOAN) {
			 appControl.deleteLoan();}

	}

// Shows the menu items that the user can choose from.
	private int displayAppMenu() {

		StringBuilder sb = new StringBuilder("Enter a selection from the following menu:\n");
		sb.append(APP_ADD_BOOK + ". Enter a new book\n" + APP_MOD_BOOK
				+ ". Modify book details. Enter the book isbn number\n" + APP_FIND_BOOK
				+ ". Find a book by isbn number\n" + APP_LIST_BOOKS + ". Display list of all books\n" + "\n"
				+ APP_ADD_USER + ". Add a new user\n" + APP_MOD_USER + ". Modify user details\n" + APP_FIND_USER
				+ ". Find a user by name\n" + APP_LIST_USERS + ". Display all users\n" + "\n" + APP_ADD_LOAN
				+ ". Add a loan. Link a user name to a book by isbn number\n" + APP_MOD_LOAN
				+ ". Modify a loan. Loan is identified by isbn number \n" + APP_FIND_LOAN
				+ ". Find a loan. Loan is identified by isbn number\n" + APP_LIST_LOANS + ". Display all loans\n" + "\n" + APP_DEL_BOOK + ". Delete a book\n" 
				+ APP_DEL_USER + ". Delete a user\n"+ APP_DEL_LOAN + ". Delete a loan\n" + "\n" + APP_EXIT + ". Exit program\n");

		int c = 0;
		try {

			System.out.println(sb.toString());

			String ch = keyboard.nextLine();

			c = Integer.parseInt(ch);
		} catch (Exception ex) {
			// Any invalid command will be just ignored
			c = -1;
		}
		return c;
	}

// to call the two methods to run the main menu of the program (displayAppMenu & executeMenuItem)
	public void startApp() {
		// starting the input from -1 to avoid automatically closing of the program
		int choice = -1;
		do {
			choice = displayAppMenu(); // calling the method to show main menu to the user
			executeMenuItem(choice); // with the choose of the user, method runs
		} while (choice != APP_EXIT); // only exit option has written inside the startapp. others are above, inside
										// the executeMenuItem
		System.out.println("Good Bye!");
	}

}
