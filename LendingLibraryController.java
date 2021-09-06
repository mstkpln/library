/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 18/07/2021
*/
package cst8284.assignment2;

import java.util.List;
import java.util.Scanner;

public class LendingLibraryController {

// a variable to call LendingLibrary class to reach all methods & instances of the class. A scanner method to get user input and show the output
	private static final String AGE = "18";
	private LendingLibrary bookLib;

	private static Scanner input;

// using 2 chain contructors to reach two variables of the class (booklib and input) by the other methods & classes.
	public LendingLibraryController() {
		bookLib = new LendingLibrary();
	}

	public LendingLibraryController(Scanner input) {
		LendingLibraryController.input = input;
		bookLib = new LendingLibrary();
	}

// a boolean method to check for the age inputs are suitable for parsing to int via try & catch method.
	private static boolean isValidNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			System.err.println("Invalid string in argument");
			return false;
		}
	}

// a void method to add user in the User instance, to get its firstname, lastname, age and adress information
	public void addUser() {
		System.out.println("New User Entry");
		String lastname = getResponseTo("Last Name ");
		String firstname = getResponseTo("First Name ");
		int age = 0;
		// a loop to automatically declare 18 to age when user just enter the age input (not entering anything for age)
		 while (true) {
		String StringAge = getResponseTo("Age ");
		if (Integer.parseInt(StringAge) <= Integer.parseInt(AGE)) 
		{StringAge = AGE;}
		// a loop to check the age should greater than zero
		else if (StringAge =="0") {System.out.println("Age should greater than 0");}
		 {//sending inputs to boolean method to verify the input parsing to int
		  boolean ageNum = isValidNumber(StringAge);
		  if (ageNum) {
		   age = Integer.parseInt(StringAge);
		   break;
		  }
		 }}
		String userAddress = getResponseTo("User address ");
		System.out.println(" ");
		//call the constructor to get the inputs and save it to the userReg array with Lending Library addUser method
		User user = new User(firstname, lastname, userAddress, age);
		boolean userAdded = bookLib.addUser(user);
		if (userAdded)
			System.out.println("User was added! \n");}

// a void method to change user address in the library system
	public void changeUser() {
		System.out.println("Modify User details.");
		String lastname = getResponseTo("Enter user lastname you want to modify");
		String firstname = getResponseTo("Enter user firstname you want to modify");
		// calling user constructor to get first & last name of the user
		User user = bookLib.findUser(firstname, lastname);
		// a non-null condition for user to show the information of it
		if (user != null) {
			System.out.println("*************** User id: " + user.getId());
			System.out.println("*************** User name: " + user.getLastname() + " " + user.getFirstname());
			System.out.println("*************** Age: " + user.getAge());
			System.out.println("*************** Address: " + user.getAddress());
			// then get user input to change the adress information of the user with user's
			// setter method
			String address = getResponseTo("Change user address (Hit enter key for no change): ");
			if (address != null && !address.equals("")) {
				user.setAddress(address);
				System.out.println("User address modified.");
			}
		} else {
			System.out.println("User not found."); // use if there is no info about the user in the system
		}
	}

// a void method to find user in the library system
	public void findUser() {
		System.out.println("Find User");
		String lastname = getResponseTo("Last Name");
		String firstname = getResponseTo("First Name");
		// by calling user's constructor and not null if condition, the system prompts
		// the user which entered the first & last name
		User user = bookLib.findUser(firstname, lastname);
		if (user != null) {
			System.out.println("*************** User ID: " + user.getId());
			System.out.println("*************** User Name: " + user.getLastname() + " " + user.getFirstname());
			System.out.println("*************** Age: " + user.getAge());
			System.out.println("*************** Address: " + user.getAddress());
		} else {
			System.out.println("No user with this name!"); // use if there is no info about the user in the system
		}
	}

// a void method to list all users in the library system by calling the userReg arraylist and show all of them by getters of the user's attributes
	public void listUsers() {
		List<User> list = bookLib.getUserReg();
		int index = 0;
		for (User user : list) {
			System.out.println("User#" + (++index));
			System.out.println("*************** User id: " + user.getId());
			System.out.println("*************** User name: " + user.getLastname() + " " + user.getFirstname());
			System.out.println("*************** Age: " + user.getAge());
			System.out.println("*************** Address: " + user.getAddress());
			System.out.println();
		}
	}

// a method to delete the user if user is in the system & does not have a loan book	
	public void deleteUser() {
		System.out.println("Delete User");
		String lastname = getResponseTo("Last Name");
		String firstname = getResponseTo("First Name");
		User user = bookLib.findUser(firstname, lastname);
		if (user != null) {
			boolean isDeleted = bookLib.deleteUser(firstname, lastname);
			if (isDeleted) {
				System.out.println("User was deleted.");
			} else {
				System.out.println("User found with loaned book.");
			}
		} else {
			System.out.println("No user found with this firstname and lastname.");
		}
	}

// a void method to add books
	public void addBook() {

		System.out.println("New Book Entry");
		String title = getResponseTo(("Title: "));
		String author = getResponseTo(("Author: "));
		String pub = getResponseTo(("Publication date (year in NNNN format) "));
		String isbn = getResponseTo(("ISBN number (10 digits): "));
		System.out.println(" ");
		// getting all information of the book from the user and verify the ISBN (10
		// digits) & dates (4 digits) with the initial methods below from the Book class
		Book book = new Book(title, author, pub, isbn);
		if (book.verifyIsbnNumber(isbn) && book.verifyPublicationDate()) {
			boolean bookAdded = bookLib.addBook(book);
			if (bookAdded) // other condition to show the output to user that system saved the book
				System.out.println("Book was added! \n");
		}
	}

	// a method to change the information of the book except the ISBN.
	public void changeBook() {
		System.out.println("Modify Book details.");
		String isbnNumber = getResponseTo("Enter book isbn number you want to modify");
		// checking the ISBN to find the book by the findBook method from the Book class
		Book book = bookLib.findBook(isbnNumber);
		if (book != null) { // a condition about not null book record then get the infos in the system by
							// getters of the book.
			System.out.println("*************** Book title: " + book.getTitle());
			System.out.println("*************** Book author: " + book.getAuthor());
			System.out.println("*************** Book isbn number: " + book.getIsbnNumber());
			System.out.println("*************** Book publication date: " + book.getPublicationDate());
			// getting which information want to change by the user
			String title = getResponseTo("Change book title (Hit enter key for no change): ");
			String author = getResponseTo("Change book author (Hit enter key for no change): ");
			String publicationDate = getResponseTo("Change book publication date (Hit enter key for no change): ");
			// if the inputs are not null and not equal the old information in the library
			// system (.equals method match the old & new info to check the changing
			// if conditions will meet, system give the information that data modified
			if (title != null && !title.equals("")) {
				book.setTitle(title);
				System.out.println("Book title modified.");
			}
			if (author != null && !author.equals("")) {
				book.setAuthor(author);
				System.out.println("Book author modified.");
			}
			if (publicationDate != null && !publicationDate.equals("")) {
				book.setPublicationDate(publicationDate);
				System.out.println("Book publication date modified.");
			}
		} else {
			System.out.println("Book not found."); // if all information is null or user enter the same information in
													// the system
		}
	}

// a void method to find a book by ISBN number
	public void findBook() {
		System.out.println("Find Book");
		String isbnNumber = getResponseTo("Book isbn number");
		// after getting the number calling findbook method to check the number is match
		// or not in the system information
		Book book = bookLib.findBook(isbnNumber);
		if (book != null) { // if the input not null program gives the all information of the book
			System.out.println("*************** Book title: " + book.getTitle());
			System.out.println("*************** Book author: " + book.getAuthor());
			System.out.println("*************** Book isbn number: " + book.getIsbnNumber());
			System.out.println("*************** Book publication date: " + book.getPublicationDate());
		} else {
			System.out.println("No book found with this isbn number."); // gives it if the isbn number is incorrect
		}
	}

// a void method to list the books in the library system
	public void listBooks() {
		// system calls the getBookreg method and with for loop, the program prompts all
		// the books in the book list with all
		// information about them
		List<Book> list = bookLib.getBookReg();
		int index = 0;
		for (Book book : list) {
			System.out.println("Book#" + (++index));
			System.out.println("*************** Title: " + book.getTitle());
			System.out.println("*************** Author: " + book.getAuthor());
			System.out.println("*************** Publication Year: " + book.getPublicationDate());
			System.out.println("*************** ISBN: " + book.getIsbnNumber());
			System.out.println("");
		}
	}

	// a method for deleting the books if it is in the system & not on loan
	public void deleteBook() {
		System.out.println("Delete Book Entry");
		String isbnNumber = getResponseTo("ISBN number (10 digits)");
		Book book = bookLib.findBook(isbnNumber);
		if (book != null) {
			boolean isDeleted = bookLib.deleteBook(isbnNumber);
			if (isDeleted) {
				System.out.println("Book was deleted.");
			} else {
				System.out.println("Book found user loaned.");
			}
		} else {
			System.out.println("No book found with this isbn number.");
		}
	}

// a void method to add book loan to the library system
	public void addBookLoan() {
		// getting some information about the book & user
		System.out.println("New Loan Entry");
		String lastName = getResponseTo("User Last name");
		String firstName = getResponseTo("User First Name");
		String isbnNumber = getResponseTo("Book ISBN number");
		String publicationDate = getResponseTo("Loan date (format yyyy-mm-dd)");
		// checking the book & user information match or not to the system information
		// for saving the loan
		User user = bookLib.findUser(firstName, lastName);
		Book book = bookLib.findBook(isbnNumber);
		// userCanBorrow method for checking if the user has already 2 loans
		boolean canBorrow = bookLib.userCanBorrow(user);
		boolean isBooked = bookLib.isBookLoaned(book); // check if the book is available for loan or not
		// a condition to check the user and book information are not null
		if (user != null && book != null) {
			if (!isBooked) { // nested conditions use to, first is an available book condition, when it is
								// met, the user borrowing option checked
				if (canBorrow) {
					BookLoan bookLoan = new BookLoan(user, book, publicationDate); // after 2 conditions met, the system
																					// loaned the book by addloan method
					boolean isAdded = bookLib.addLoan(bookLoan); // added the book to loanReg and saved
					if (isAdded) {
						System.out.println("Loan added");
						System.out.println(
								"*************** User name: " + user.getLastname() + " " + user.getFirstname());
						System.out.println("*************** Book title: " + book.getTitle());
						System.out.println("*************** Book author: " + book.getAuthor());
						System.out.println("*************** Book isbn number: " + book.getIsbnNumber());
						System.out.println("*************** Book publication date: " + book.getPublicationDate());
					}
				} else {
					System.out.println("This user not allowed to borrow more books."); // it works when user has already
																						// loaned 2 books
				}
			} else {
				System.out.println("Book is already loaned.");
			} // works if the book is loaned before
		}
	}

// a method for changing the due date of loan of the book
	public void changeBookLoan() {
		System.out.println("Modify Book loan details.");
		// getting the isbn from the user to find the book in the system
		String isbnNumber = getResponseTo("Enter loan isbn number you want to modify");
		// calling the method to check the book is on loan
		BookLoan bookLoan = bookLib.findLoan(isbnNumber);
		if (bookLoan != null) { // if the book is on loan, the system prompts the borrower and book information
								// in the system with getters from the user & book classes.
			User user = bookLoan.getUser();
			Book book = bookLoan.getBook();

			System.out.println("*************** User name: " + user.getLastname() + " " + user.getFirstname());
			System.out.println("*************** Book title: " + book.getTitle());
			System.out.println("*************** Book author: " + book.getAuthor());
			System.out.println("*************** Book isbn number: " + book.getIsbnNumber());
			System.out.println("*************** Book publication date: " + book.getPublicationDate());

			// getting the user input from the user to change the date
			String dueDate = getResponseTo("Change loan due date (Hit enter key for no change): ");
			if (dueDate != null && !dueDate.equals("")) { // checking the date format is correct by .equals method
				bookLoan.setDueDate(dueDate); // setting the new duedate with the initial setter of the bookloan class
				System.out.println("Loan due date modified.");
			}
		} else {
			System.out.println("Loan not found."); // if the book is not on loan
		}
	}

// a method for finding a book which is on loan with its isbn number
	public void findBookLoan() {
		System.out.print("Find a book loan. ");
		// getting the isbn number from the user
		String isbnNumber = getResponseTo("Enter ISBN number: ");
		BookLoan bookLoan = bookLib.findLoan(isbnNumber); // searching the number in the loanReg array to find the book
		if (bookLoan != null) { // if the system find the book, shows the information of the borrower and book
								// to the user with getters of user & book classes.
			User user = bookLoan.getUser();
			Book book = bookLoan.getBook();
			System.out.println("*************** User name: " + user.getLastname() + " " + user.getFirstname());
			System.out.println("*************** Book title: " + book.getTitle());
			System.out.println("*************** Book author: " + book.getAuthor());
			System.out.println("*************** Book ISBN number: " + book.getIsbnNumber());
			System.out.println("*************** Book publication date: " + book.getPublicationDate());

		} else {
			System.out.println("No book loan found with this ISBN number."); // book is not on loan
		}
	}

// a method to list all books on loan
	public void listBookLoans() {
		// directly reach to getters of loanReg and making a for loop to show the
		// user the information of the books which are on loan
		 List<BookLoan> list = bookLib.getLoanReg();
		 int index = 0;
		 for (BookLoan bookLoan : list) {
		  User user = bookLoan.getUser();
		  Book book = bookLoan.getBook();
		  System.out.println("Loan#" + (++index));
		  System.out.println("*************** User name: " + user.getLastname() + " " + user.getFirstname());
		  System.out.println("*************** Title: " + book.getTitle());
		  System.out.println("*************** Author: " + book.getAuthor());
		  System.out.println("*************** ISBN: " + book.getIsbnNumber());
		  System.out.println("*************** Due date: " + bookLoan.getDueDate());
		 }
	}
// a method to delete loan if the book & loan is found in the system
	public void deleteLoan() {
		 System.out.println("Delete loan");
		 String isbnNumber = getResponseTo("Book ISBN number");
		 BookLoan bookLoan = bookLib.findLoan(isbnNumber);
		 if (bookLoan != null) {
		  boolean isDeleted = bookLib.deleteLoan(isbnNumber);
		  if (isDeleted) {
		   System.out.println("Loan was deleted.");
		  } else {
		   System.out.println("Book found no user loaned.");
		  }
		 } else {
		  System.out.println("No book loan found with this isbn number.");
		 }
		}
// a useful method to get input and show output on the same line from and to the user at the same time. Used lots of examples above in the methods
	private static String getResponseTo(String s) {
		System.out.println(s);
		return input.nextLine();
	}
}
