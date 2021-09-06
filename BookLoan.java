/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 18/07/2021
*/

package cst8284.assignment2;

// declaring BookLoan class instances, variables & methods based on UML Diagram

public class BookLoan {

	private User user;

	private Book book;

	private String dueDate;

//all variables put inside the constructor, different constructors don't require in other class & methods.

	public BookLoan(User user, Book book, String dueDate) {
		this.user = user;
		this.book = book;
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	// equals method to indicate whether some other object is "equal to" Book, if the instance variables of the class (the book, the user, and the duedate are equal.)
	@Override
	public boolean equals(Object obj) {
	 if (this == obj)
	  return true;
	 if (obj == null)
	  return false;
	 if (getClass() != obj.getClass())
	  return false;
	 BookLoan other = (BookLoan) obj;
	 if (book == null) {
	  if (other.book != null)
	   return false;
	 } else if (!book.equals(other.book))
	  return false;
	 if (dueDate == null) {
	  if (other.dueDate != null)
	   return false;
	 } else if (!dueDate.equals(other.dueDate))
	  return false;
	 if (user == null) {
	  if (other.user != null)
	   return false;
	 } else if (!user.equals(other.user))
	  return false;
	 return true;
	}
//invoking toString() method to describe the object with information demanded (class instance variables)
	@Override
	public String toString() {
		return "************ User name:" + getUser().getFirstname() + " " + getUser().getLastname() + "\n"
				+ "************ Title: " + getBook().getTitle() + "\n" + "************ Author: " + getBook().getAuthor()
				+ "\n" + "************ ISBN: " + getBook().getIsbnNumber() + "\n" + "************ Due date: "
				+ getDueDate();

	}
}
