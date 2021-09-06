/**
Author Name: Mesut Kaplan / 040990961
Class Name: CST 8284_300 Object Oriented Programming
Date: 18/07/2021
*/

// declaring Book class' instances, variables & methods based on UML Diagram
package cst8284.assignment2;

public class Book {

	private String title;

	private String author;

	private String publicationDate;

	private String isbnNumber;

//all variables put inside the constructor, different constructors don't require in other class & methods.

	public Book(String title, String author, String publicationDate, String isbnNumber) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.isbnNumber = isbnNumber;
	}

//all getters & setter methods for the class variables

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	// equals method to indicate whether some other object is "equal to" Book, if the instance variables of the class (the title, the author, the isbn number, and the publication
	// date are equal)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbnNumber == null) {
			if (other.isbnNumber != null)
				return false;
		} else if (!isbnNumber.equals(other.isbnNumber))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

// To ensure that the ISBN is exactly 10 digits long, isDigit method is used inside a for loop. 
// All i's should convert to char because the method only counts char type inside the loop. For method type verification these implementations put in 
// a boolean condition and true is the should be condition. The method returns the ISBN consists of 10 digits
	public boolean verifyIsbnNumber(String s) {
		boolean consistOf = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				consistOf = false;
				break;
			}
		}
		return s.length() == 10 && consistOf;
	}

//To ensure that the publication date has 4 digits, isDigit method is used inside a for loop. 
//All i's should convert to char because the method only counts char type inside the loop. For method type verification these implementations put in 
//a boolean condition and the return value should be true to verify. The method returns the 4 digits year.

	public boolean verifyPublicationDate() {
		boolean consistOfPub = true;
		for (int i = 0; i < publicationDate.length(); i++) {
			if (!Character.isDigit(publicationDate.charAt(i))) {
				consistOfPub = false;
				break;
			}
		}
		return publicationDate.length() == 4 && consistOfPub;
	}
	
	//invoking toString() method to describe the object with information demanded (class instance variables)
	@Override
	public String toString() {
		return "************ Title: " + getTitle() + "\n" + "************ Author: " + getAuthor() + "\n"
				+ "************ Publication Year: " + getPublicationDate() + "\n" + "************ ISBN: "
				+ getIsbnNumber();
	}
}
