package com.sirma.itt.javacourse.io;

import java.io.File;
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
	 * Returns a list with all folders, subfolders and files contained in the
	 * given directory, or an empty list if the folder is empty. Uses depth
	 * first search recursion to iterate over all subdirectories, if any.
	 * 
	 * @return a List<String> with all contents of the folder
	 * @param path
	 *            is the file path to check for. It can be an absolute path for
	 *            the OS, or a relative path for the program's home dir
	 */
	public static List<String> getContent(String path) {
		List<String> contents = new ArrayList<String>();
		File file = new File(path);
		File[] subDirectories = file.listFiles();
		for (File temp : subDirectories) {
			contents.add(temp.getName());
			getContent(temp.toString(), contents);
		}
		return contents;
	}

	/**
	 * Recursive method. Adds to the list all subfolders of the given path. If
	 * the path points to a file, the method returns.
	 * 
	 * @param path
	 *            is the relative path to get the contents of
	 * @param contents
	 *            is the list to fill with the found subfolders and files
	 */
	private static void getContent(String path, List<String> contents) {
		File file = new File(path);
		File[] subDirectories = file.listFiles();
		if (subDirectories == null) {
			return;
		}
		for (File temp : subDirectories) {
			contents.add(temp.getName());
			getContent(temp.toString(), contents);
		}
	}

	/**
	 * Entry point for self-testing.
	 * 
	 * @param args
	 *            are the cmd args
	 */
	public static void main(String[] args) {
		List<String> contents = getContent("sampleFolder");
		System.out.println(contents);
	}
}
