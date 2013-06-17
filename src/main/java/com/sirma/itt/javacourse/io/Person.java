package com.sirma.itt.javacourse.io;

import java.io.Serializable;

/**
 * A sample data class made to be serialized by the Serializer class.
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private String address;

	/**
	 * Constructs the person with an initial name, age and address.
	 * 
	 * @param name
	 *            is the new name
	 * @param age
	 *            is the new age of the person
	 * @param address
	 *            is the new address of the person
	 */
	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * a getter for the person's name.
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

	/**
	 * a getter for the person's age.
	 * 
	 * @return the age of the person
	 */
	public int getAge() {
		return age;
	}

	/**
	 * a getter for the person's address.
	 * 
	 * @return the address of the person
	 */
	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\nAge: " + this.age + "\nAddress: "
				+ this.address;
	}

}
