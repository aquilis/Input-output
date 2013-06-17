package com.sirma.itt.javacourse.io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Lists the content of the given folder from the OS file system.
 */
public final class DirectoryBrowser {
	/**
	 * Not designed to be instantiated.
	 */
	private DirectoryBrowser() {
	}

	/**
	 * Checks if the given path points to a file. If yes, displays a message,
	 * otherwise returns a list of string containnig the names of all files and
	 * fiolders contained in the path
	 * 
	 * @return a List<String> with all contents of the folder, or an empty list
	 *         if the path points to a file
	 * @param path
	 *            is the file path to check for. It can be an absolute path for
	 *            the OS, or a relative path for the program's home dir
	 */
	public static List<String> listContent(String path) {
		Path dir = Paths.get(path);
		List<String> contents = new ArrayList<String>();
		if (!Files.isDirectory(dir)) {
			System.out.println("The specified path points to a file.");
		} else {
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
				for (Path file : stream) {
					contents.add(file.getFileName().toString());
				}
			} catch (IOException | DirectoryIteratorException x) {
				System.err.println(x);
			}
		}
		return contents;
	}

	/**
	 * Entry point for self-testing.
	 * 
	 * @param args
	 *            are the cmd args
	 */
	public static void main(String[] args) {
		List<String> contents = listContent("sampleFolder");
		System.out.println(contents);
	}
}
