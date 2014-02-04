
package com.analemma.list_select;

public class Contact {

	private String firstName;
	private String lastName;
	private String email;

	public Contact(String firstName, String lastName, String email) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFullName() {

		return firstName + " " + lastName;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public String getEmail() {

		return email;
	}

}
