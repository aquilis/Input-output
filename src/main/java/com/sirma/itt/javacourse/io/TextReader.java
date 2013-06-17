package com.sirma.itt.javacourse.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reads a text from the user and writes in on a text file.
 */
public final class TextReader {
	/**
	 * Not designed to be instantiated.
	 */
	private TextReader() {
	}

	/**
	 * Reads a file name from the user and then reads line by line from the
	 * console and writes to the text file specified.
	 * 
	 * @throws IOException
	 *             If an I/O error occurs
	 */
	public static void exportInputText() throws IOException {
		Scanner scn = new Scanner(System.in);
		String filename = scn.nextLine();
		if (!filename.endsWith(".txt")) {
			filename += ".txt";
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));

		String lineBreaker = System.getProperty("line.separator");
		String line = "";
		while (!".".equals(line)) {
			line = scn.nextLine();
			out.write(line + lineBreaker);
		}
		out.close();
		scn.close();
	}

	/**
	 * Self-testing.
	 * 
	 * @param args
	 *            are the cmd args
	 * @throws IOException
	 *             If an I/O error occurs
	 */
	public static void main(String[] args) throws IOException {
		exportInputText();
	}
}
