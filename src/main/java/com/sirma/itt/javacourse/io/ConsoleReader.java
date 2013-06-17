package com.sirma.itt.javacourse.io;

import java.util.Scanner;

/**
 * A static class designed to read user inputs from the console via its public
 * methods.
 */
public final class ConsoleReader {

	private static Scanner scn = new Scanner(System.in);

	/**
	 * Not designed to be instantiated.
	 */
	private ConsoleReader() {
	}

	/**
	 * Reads a single string from the console.
	 * 
	 * @return the string read from the user
	 */
	public static String readString() {
		return scn.nextLine();
	}

	/**
	 * Reads a single character from the console.
	 * 
	 * @return the char read from the user
	 */
	public static char readChar() {
		return scn.nextLine().charAt(0);
	}

	/**
	 * Reads a single inetger from the console.
	 * 
	 * @return the int value read from the user
	 */
	public static int readInt() {
		return scn.nextInt();
	}

	/**
	 * Reads a single floating-point variable from the console.
	 * 
	 * @return the float value read from the user
	 */
	public static float readFloat() {
		return scn.nextFloat();
	}
}
