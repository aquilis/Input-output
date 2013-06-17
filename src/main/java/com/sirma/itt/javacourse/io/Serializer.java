package com.sirma.itt.javacourse.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serializes and deserializes the sample data class - Person.
 */
public final class Serializer {
	/**
	 * the class is static.
	 */
	private Serializer() {
	}

	/**
	 * Serializes the given object to the file specified.
	 * 
	 * @param path
	 *            is the path of the file to be created
	 * @param obj
	 *            is the object to be serialized
	 * @throws FileNotFoundException
	 */
	public static void saveObject(String path, Person obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(obj);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	/**
	 * Locates and deserializes the object stored in the given file.
	 * 
	 * @param path
	 *            is the path to the .ser file
	 * @return the object stored in the file
	 */
	public static Person getObject(String path) {
		Person obj = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = (Person) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
		}
		return obj;
	}

	/**
	 * Entry point.
	 * 
	 * @param args
	 *            are the cmd args
	 */
	public static void main(String[] args) {
		Person myObj = new Person("John", 30, "55 foo str.");
		saveObject("tempObj", myObj);
		System.out.println(getObject("tempObj"));
	}
}
