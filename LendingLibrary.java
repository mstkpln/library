/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 18/07/2021
*/
package cst8284.assignment2;

import java.util.ArrayList;
import java.util.List;

// declaring LendingLibrary class constants, instances, arraylists & methods based on UML Diagram. Final constants show the limitation of different array types
// , book, user, loan and loan books per users e.g.

public class LendingLibrary {

	private static final int MAX_LOAN_PER_USER = 2;
	private List<Book> bookReg;
	private List<User> userReg;
	private List<BookLoan> loanReg;

//created a method to call all the arraylists by other classes

	public LendingLibrary() {
		bookReg = new ArrayList<Book>();
		userReg = new ArrayList<User>();
		loanReg = new ArrayList<BookLoan>();
	}

// a user constructor to return user's instances 
	public User makeUser(int id, String firstname, String lastname, String address, int age) {
		return new User(id, firstname, lastname, address, age);
	}

//getter & setter methods for all arraylists of the class
	public List<Book> getBookReg() {
		return bookReg;
	}

	public void setBookReg(List<Book> bookReg) {
		this.bookReg = bookReg;
	}

	public List<User> getUserReg() {
		return userReg;
	}

	public void setUserReg(List<User> userReg) {
		this.userReg = userReg;
	}

	public List<BookLoan> getLoanReg() {
		return loanReg;
	}

	public void setLoanReg(List<BookLoan> loanReg) {
		this.loanReg = loanReg;
	}

//a boolean method for incrementing User in the userReg arraylist
	public boolean addUser(User u) {
		return userReg.add(u);
	}

//a boolean method for incrementing book in the bookReg arraylist
	public boolean addBook(Book b) {
		return bookReg.add(b);
	}

//a boolean method for incrementing bookloan in the loanReg arraylist
	public boolean addLoan(BookLoan l) {
		return loanReg.add(l);
	}

// method to search user in the userReg with for each loop with user's first and last name
	public User findUser(String firstname, String lastname) {
		for (User user : userReg) {
			if (user.getFirstname().equals(firstname) && user.getLastname().equals(lastname)) {
				return user;
			}
		}
		return null;
	}

//method to find book in the bookReg with for each loop with books' ISBN numbers
	public Book findBook(String isbnNumber) {
		for (Book book : bookReg) {
			if (book.getIsbnNumber().equals(isbnNumber)) {
				return book;
			}
		}
		return null;
	}

// method to check books in the loanReg with for loop with books' isbn numbers
	public BookLoan findLoan(String isbnNumber) {
		for (BookLoan bookLoan : loanReg) {
			if (bookLoan.getBook().getIsbnNumber().equals(isbnNumber)) {
				return bookLoan;
			}
		}
		return null;
	}

//a boolean method for incrementing bookLoan by user in the loanReg until the number of books per users' reach at max loan per user which is 2(checking it with a ternary operator)
	public boolean userCanBorrow(User u) {
		int count = 0;
		for (BookLoan bookLoan : loanReg) {
			User user = bookLoan.getUser();
			if (user.getFirstname().equals(u.getFirstname()) && user.getLastname().equals(u.getLastname())) {
				count++;
			}
		}
		return count != MAX_LOAN_PER_USER ? true : false;
	}

// a boolean method for checking the book is available or on loan in the Book class. Using the for each loop to check and find the book in loanReg arraylist.
	public boolean isBookLoaned(Book b) {
		for (BookLoan bookLoan : loanReg) {
			Book book = bookLoan.getBook();
			if (book.getIsbnNumber().equals(b.getIsbnNumber())) {
				return true;
			}
		}
		return false;
	}

// a method to delete users in the userReg arraylist if user is found and user doesnt have any loan
	public boolean deleteUser(String firstname, String lastname) {
		User searchUser = findUser(firstname, lastname);
		boolean isNoneLoanedBook = true;
		for (BookLoan loan : loanReg) {
			User user = loan.getUser();
			if (user.equals(searchUser)) {
				isNoneLoanedBook = false;
				break;
			}
		}
		if (isNoneLoanedBook)
			userReg.remove(searchUser);
		return isNoneLoanedBook;
	}

// a method to delete books in the bookReg arraylist if book is in the bookReg and if it is not currently borrowed
	public boolean deleteBook(String isbnNumber) {
		Book searchBook = findBook(isbnNumber);
		boolean isNoneBorrowed = true;
		for (BookLoan loan : loanReg) {
			Book book = loan.getBook();
			if (book.equals(searchBook)) {
				isNoneBorrowed = false;
				break;
			}
		}
		if (isNoneBorrowed)
			bookReg.remove(searchBook);
		return isNoneBorrowed;
	}

// a method to delete loan condition of the books in the loanReg arraylist if book is in the bookReg and if it is currently borrowed
	public boolean deleteLoan(String isbnNumber) {
		Book searchBook = findBook(isbnNumber);
		for (BookLoan loan : loanReg) {
			Book book = loan.getBook();
			if (book.equals(searchBook)) {
				loanReg.remove(loan);
				return true;
			}
		}
		return false;
	}
}
