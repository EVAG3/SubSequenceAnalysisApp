package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileReader - The file reader that return k,n and the array of int from the
 * file
 * 
 * @author yu
 *
 */
public class FileReader {
	/**
	 * The function read the file and return the N and K
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the N and K
	 */
	public static int[] getNK(File inputFile) {
		Scanner input = null;
		try {
			input = new Scanner(inputFile);
			input.useDelimiter(" |\n");
			int[] nk = new int[2];
			nk[0] = input.nextInt();
			nk[1] = input.nextInt();
			return nk;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	/**
	 * The function read the file and return the array
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the array
	 */
	public static int[] getArray(File inputFile) {
		Scanner input = null;
		try {
			int[] nk = getNK(inputFile);
			input = new Scanner(inputFile);
			input.nextLine();

			// as one int is 4 bytes, and N <= 200,000, so the max memory should
			// around 0.8 MB for this array
			int[] array = new int[nk[0]];
			input.useDelimiter(" |n");
			for (int i = 0; i < nk[0]; i++) {
				array[i] = input.nextInt();
			}
			if (input.hasNextInt()){
				throw new IllegalArgumentException();
			}
			return array;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}
