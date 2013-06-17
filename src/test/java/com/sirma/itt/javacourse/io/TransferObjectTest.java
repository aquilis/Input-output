package com.sirma.itt.javacourse.io;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * Tests the transferring of the I/O buffers.
 */
public class TransferObjectTest {
	/**
	 * Create input and output streams and test the work of the transfer method.
	 * 
	 * @throws IOException
	 *             when problem with the I/O occurs
	 */
	@Test
	public void test() throws IOException {
		String str = "This is some test content.";
		int transferOffset = 0;
		
		InputStream in = new ByteArrayInputStream(str.getBytes());
		OutputStream out = new ByteArrayOutputStream();
		TransferObject transferrer = new TransferObject(in, out);
		int transferred = transferrer.transfer(str.length(), transferOffset);
		assertEquals(str, out.toString());
		assertEquals(transferred, str.length() - transferOffset);
	}
}
