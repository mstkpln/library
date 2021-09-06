/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 20/07/2021
*/
package cst8284.assignment2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.assignment2.User;

public class UserTest {
	// declaring variables to compare & test the instance objects of the User class
	private static int ID = 1001;
	private static String FIRSTNAME = "Rodin Baris";
	private static String LASTNAME = "Kaplan";
	private static String ADDRESS = "Ottawa ON Canada";
	private static int AGE = 4;
	private static User user;

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
		user = new User(ID, FIRSTNAME, LASTNAME, ADDRESS, AGE);
	}

	// will run after every test method executes
	@After 
	public void setupAfterEveryTest() {
		user = null;
	}

	// comparing user ID with int id which created for the test above, returns true
	@Test
	public void testId_True() {
		int id = user.getId();
		assertEquals(ID, id);
	}

	// comparing user ID, with int ID setting 1000 that created for the test above, returns false
	@Test
	public void testId_False() {
		user.setId(1000);
		int id = user.getId();
		assertNotEquals(ID, id);
	}

	// comparing user fname with String fname which created for the test above, returns true
	@Test
	public void testFirstname_True() {
		String firstname = user.getFirstname();
		assertEquals(FIRSTNAME, firstname);
	}
	
	// comparing user fname, with String fname setting Bruce which created for the test above, returns false
	@Test
	public void testFirstname_False() {
		user.setFirstname("Bruce");
		String firstname = user.getFirstname();
		assertNotEquals(FIRSTNAME, firstname);
	}

	// comparing user lname with String lname which created for the test above, returns true
	@Test
	public void testLastname_True() {
		String lastname = user.getLastname();
		assertEquals(LASTNAME, lastname);
	}

	// comparing user lname,  with String lname setting Willis which created for the test above, returns false
	@Test
	public void testLastname_False() {
		user.setLastname("Willis");
		String lastname = user.getLastname();
		assertNotEquals(LASTNAME, lastname);
	}

	// comparing user address with String address which created for the test above, returns true
	@Test
	public void testAddress_True() {
		String address = user.getAddress();
		assertEquals(ADDRESS, address);
	}
	// comparing user address with String address setting which created for the test above, returns false
	@Test
	public void testAddress_False() {
		user.setAddress("Turkey");
		String address = user.getAddress();
		assertNotEquals(ADDRESS, address);
	}

	// comparing user age with int age which created for the test above, returns true
	@Test
	public void testAge_True() {
		int age = user.getAge();
		assertEquals(AGE, age);
	}
	// comparing user age with int age setting 40 which created for the test above, returns false
	@Test
	public void testAge_False() {
		user.setAge(40);
		int age = user.getAge();
		assertNotEquals(AGE, age);
	}
// comparing whole user's attributes (called above) to the user's equals method object, returns true
	@Test
	public void testUser_True() {
		User newUser = new User(ID, FIRSTNAME, LASTNAME, ADDRESS, AGE);
		assertTrue(user.equals(newUser));
		assertNotNull(user);
		assertNotNull(newUser);
		assertEquals(newUser, user);
	}

	// comparing null user's attributes (called above) to the user's not null object, returns notequals' test false
	@Test
	public void testUser_False() {
		User newUser = null;
		assertNotNull(user);
		assertNull(newUser);
		assertNotEquals(newUser, user);
	}
}
