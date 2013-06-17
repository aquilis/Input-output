package com.sirma.itt.javacourse.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Transfers the content of an input stream into an output stream.
 */
public class TransferObject {
	private final InputStream input;
	private final OutputStream output;

	/**
	 * Constructs the transferrer instance with 2 I/O streams to work with.
	 * 
	 * @param input
	 *            is the input stream to read from.
	 * @param output
	 *            is the output stream to write to
	 */
	public TransferObject(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * Transfer the content of the input stream to the output.
	 * 
	 * @param numberOfBytes
	 *            is the number of bytes to be transferred.
	 * @param offset
	 *            is the front offset of the bytes to be transferred
	 * @return the number of bytes taht have been read from the Input stream
	 * @throws IOException
	 *             if a problem with the I/O occurs
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		byte[] buffer = new byte[256];
		int bytesRead = 0;
		int temp = 0;
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, offset, bytesRead - offset);
			temp = bytesRead;
		}
		return temp - offset;
	}
}
