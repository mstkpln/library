/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 20/07/2021
*/
package cst8284.assignment2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.assignment2.Book;
import cst8284.assignment2.BookLoan;
import cst8284.assignment2.User;

public class BookLoanTest {
	// declaring variables to compare & test the instance objects of the BookLoan
	// class
	private static int ID = 1001;
	private static String FIRSTNAME = "Rodin Baris";
	private static String LASTNAME = "Kaplan";
	private static String ADDRESS = "Ottawa ON Canada";
	private static int AGE = 4;
	private static String TITLE = "The Savage Detectives";
	private static String AUTHOR = "Roberto Bolaño";
	private static String PUBLICATION_YEAR = "1998";
	private static String ISBN_NUMBER = "9780307476";
	private static String DUE_DATE = "2021-10-20";
	private static User user;
	private static Book book;
	private static BookLoan bookLoan;

	// an auto method, execute 1st in all; and only once in the beginning
	@BeforeClass
	public static void setupBeforeClass() {

		book = new Book(TITLE, AUTHOR, PUBLICATION_YEAR, ISBN_NUMBER);
		user = new User(ID, FIRSTNAME, LASTNAME, ADDRESS, AGE);
	}

	// an auto method, execute last in all; and only once in the end
	@AfterClass
	public static void setupAfterClass() {

	}

	// it will run before every test method executes
	@Before
	public void setupBeforeEveryTest() {
		bookLoan = new BookLoan(user, book, DUE_DATE);
	}

	// will run after every test method executes
	@After
	public void setupAfterEveryTest() {
		bookLoan = null;
	}

// boolean method checks for a condition that user equals object equal to the bookloan getUser object. To testing 
	// the equality of expected value of the user and the value of the bookloan user
	// testing be made by assertEquals
	// both return true
	@Test
	public void testUser_True() {
		assertTrue(user.equals(bookLoan.getUser()));
		assertEquals(user, bookLoan.getUser());
	}

// creating a user with no name and comparing it to the the user of this test class above, returns false
	@Test
	public void testUser_False() {
		User currentUser = new User(ID, "No Name", LASTNAME, ADDRESS, AGE);
		assertFalse(user.equals(currentUser));
		assertNotEquals(user, currentUser);
	}

	// boolean method checks for a condition that book equals object equal to the bookloan getbook object. To testing
	// the equality of expected value of the book and the value of the bookloan getbook testing be made by assertEquals.
	// Both of them return true
	@Test
	public void testBook_True() {
		assertTrue(book.equals(bookLoan.getBook()));
		assertEquals(book, bookLoan.getBook());
	}
	// creating a book with Java Programming and comparing it to the the book of this test class above, returns false
	@Test
	public void testBook_False() {
		Book currentBook = new Book("Java Programming", AUTHOR, PUBLICATION_YEAR, ISBN_NUMBER);
		assertFalse(book.equals(currentBook));
		assertNotEquals(book, currentBook);
	}
// comparing bookloan getduedate to the due date above, returns true
	@Test
	public void testDueDate_True() {
		assertEquals(DUE_DATE, bookLoan.getDueDate());
	}
	// comparing bookloan getduedate to different date, returns false
	@Test
	public void testDueDate_False() {
		bookLoan.setDueDate("2021-01-01");
		assertNotEquals(DUE_DATE, bookLoan.getDueDate());
	}
	// comparing whole bookloan's attributes (called above) to the bookloan's equals method object, returns true
	@Test
	public void testBookLoan_True() {
		BookLoan newBookLoan = new BookLoan(user, book, DUE_DATE);
		assertTrue(bookLoan.equals(newBookLoan));
		assertNotNull(bookLoan);
		assertNotNull(newBookLoan);
		assertEquals(newBookLoan, bookLoan);
	}
	// comparing bookloan's attributes (called above but has different due date) to the bookloan's object, returns false
	@Test
	public void testBookLoan_False() {
		BookLoan newBookLoan = new BookLoan(user, book, "2021-02-02");
		assertFalse(bookLoan.equals(newBookLoan));
		assertNotNull(bookLoan);
		assertNotNull(newBookLoan);
		assertNotEquals(newBookLoan, bookLoan);
	}
}
