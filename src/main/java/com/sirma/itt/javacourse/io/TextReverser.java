package com.sirma.itt.javacourse.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class reversing the content of a text file backwards using buffers.
 */
public final class TextReverser {
	/**
	 * Not designed to be instantiated.
	 */
	private TextReverser() {
	}

	/**
	 * Reverses the text contetnt of the file specified.
	 * 
	 * @param filename
	 *            is the name of the file to be reversed
	 * @throws IOException
	 *             if there is problem with the I/O
	 */
	public static void reverseFile(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		StringBuffer buffer = new StringBuffer();
		String line;
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		in.close();
		buffer.reverse();
		PrintWriter writer = new PrintWriter(filename);
		writer.print(buffer.toString());
		writer.close();
		System.out.println(filename + " reversed successfully");
	}

	/**
	 * Entry point for self-testing.
	 * 
	 * @param args
	 *            are the cmd args
	 * @throws IOException
	 *             if tehre's a problem wit hthe I/O
	 */
	public static void main(String[] args) throws IOException {
		reverseFile("in.txt");
	}
}
