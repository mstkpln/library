package cst8284.assignment2;

/**
Author Name: Mesut Kaplan / 040990961 
Class Name: CST 8284_300 Object Oriented Programming 
Date: 18/07/2021
*/

// declaring User class instances, variables & methods based on UML Diagram

public class User {

//a static counter that increments each time a User object is created.
	private static int userNextId = 1000;

	private int id;

	private String firstname;

	private String lastname;

	private String address;

	private int age;

// all variables put inside the constructors and chained in the class

	public User(int id, String firstname, String lastname, String address, int age) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.age = age;
	}

//equalize id to userNextId to call the constructor for id or userNextId
	public User(String firstname, String lastname, String address, int age) {
		this.id = userNextId++;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.age = age;
	}

	public User(String firstname, String lastname, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

//all getters & setter methods for the class variables

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
// equals method to indicate whether some other object is "equal to" User, if the instance variables of the class (the address, age, firstname, lastname
// are all equal)
	@Override
	public boolean equals(Object obj) {
	 if (this == obj)
	  return true;
	 if (obj == null)
	  return false;
	 if (getClass() != obj.getClass())
	  return false;
	 User other = (User) obj;
	 if (address == null) {
	  if (other.address != null)
	   return false;
	 } else if (!address.equals(other.address))
	  return false;
	 if (age != other.age)
	  return false;
	 if (firstname == null) {
	  if (other.firstname != null)
	   return false;
	 } else if (!firstname.equals(other.firstname))
	  return false;
	 if (lastname == null) {
	  if (other.lastname != null)
	   return false;
	 } else if (!lastname.equals(other.lastname))
	  return false;
	 return true;
	}
	//rewrite toString method
	@Override
	public String toString() {
		return "************ User id: " + getId() + "\n"
			+ "************ User name: " + getLastname() + " " + getFirstname() + "\n"
			+ "************ Age: " + getAge() + "\n"
			+ "************ Address: " + getAddress() + "\n";
	}
}
