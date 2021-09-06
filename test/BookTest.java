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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.assignment2.Book;

public class BookTest {
	// declaring variables to compare & test the instance objects of the Book class
	private static String TITLE = "The Savage Detectives";
	private static String AUTHOR = "Roberto Bolaño";
	private static String PUBLICATION_YEAR = "1998";
	private static String ISBN_NUMBER = "9780307476";
	private static Book book;

	// an auto method, execute 1st in all; and only once in the beginning
	@BeforeClass
	public static void setupBeforeClass() {
		
	}
	// an auto method, execute last in all; and only once in the end
	@AfterClass
	public static void setupAfterClass() {
		
	}
	// it will run before every test method executes
	@Before 
	public void setupBeforeEveryTest() {
		book = new Book(TITLE, AUTHOR, PUBLICATION_YEAR, ISBN_NUMBER);
	}
	// will run after every test method executes
	@After 
	public void setupAfterEveryTest() {
		book = null;
	}
	// comparing book author with String author which created for the test above, returns true
	@Test
	public void testAuthor_True() {
		String author = book.getAuthor();
		assertEquals(AUTHOR, author);
	}
	// comparing book author with String author setting Ursula Le Guin which created for the test above, returns false
	@Test
	public void testAuthor_False() {
		book.setAuthor("Ursula Le Guin");
		String author = book.getAuthor();
		assertNotEquals(AUTHOR, author);
	}

	// comparing book title with String title which created for the test above, returns true
	@Test
	public void testTitle_True() {
		String title = book.getTitle();
		assertEquals(TITLE, title);
	}
	// comparing book title with String title setting The Dispossessed which created for the test above, returns false
	@Test
	public void testTitle_False() {
		book.setTitle("The Dispossessed");
		String title = book.getTitle();
		assertNotEquals(TITLE, title);
	}
	// comparing book publishing date with String publication which created for the test above, returns true
	@Test
	public void testPublication_True() {
		String publication = book.getPublicationDate();
		assertEquals(PUBLICATION_YEAR, publication);
	}
	// comparing book publishing date with String publishing date setting 1974 which created for the test above, returns false
	@Test
	public void testPublication_False() {
		book.setPublicationDate("1974");
		String publication = book.getPublicationDate();
		assertNotEquals(PUBLICATION_YEAR, publication);
	}
	// comparing book isbn number with String isbn number which created for the test above, returns true
	@Test
	public void testIsbnNumber_True() {
		String isbn = book.getIsbnNumber();
		assertEquals(ISBN_NUMBER, isbn);
	}
	// comparing book isbn number with String isbn number setting 9876543210 which created for the test above, returns false
	@Test
	public void testIsbnNumber_False() {
		book.setIsbnNumber("9876543210");
		String isbn = book.getIsbnNumber();
		assertNotEquals(ISBN_NUMBER, isbn);
	}
	// comparing whole book's attributes (called above) to the book's equals method object, returns true
	@Test
	public void testBook_True() {
		Book newBook = new Book(TITLE, AUTHOR, PUBLICATION_YEAR, ISBN_NUMBER);
		assertTrue(book.equals(newBook));
		assertNotNull(book);
		assertNotNull(newBook);
		assertEquals(newBook, book);
	}
	// comparing null book's attributes (called above) to the book's not null object, returns notequals' test false
	@Test
	public void testBook_False() {
		Book newBook = null;
		assertNull(newBook);
		assertNotNull(book);
		assertNotEquals(newBook, book);
	}
	// creating a boolean test method to check the year of publishing of the book year is 1998, returns true
	@Test
	public void testDate_True() {
		boolean isValid = book.verifyPublicationDate();
		assertTrue(isValid);
	}
	// creating a boolean test method to check the year of publishing of the book (YYYY declared) is 1998, returns false
	@Test
	public void testDate_False() {
		book.setPublicationDate("YYYY");
		boolean isValid = book.verifyPublicationDate();
		assertFalse(isValid);
	}
	// creating a boolean test method to check the isbn number of the book (9780307476) is 10 digits returns true
	@Test
	public void verifyIsbnNumber_True() {
		String isbn = book.getIsbnNumber();
		boolean isValid = book.verifyIsbnNumber(isbn);
		assertTrue(isValid);
	}
	// creating a boolean test method to check the isbn number of the book (9780307476) is O123456789 returns false
	@Test
	public void verifyIsbnNumber_False() {
		book.setIsbnNumber("O123456789");
		String isbn = book.getIsbnNumber();
		boolean isValid = book.verifyIsbnNumber(isbn);
		assertFalse(isValid);
	}
}
