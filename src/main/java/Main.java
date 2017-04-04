package main.java;

import java.io.File;
import java.util.Scanner;


/**
 * The main entry for the application
 * 
 * @author yu
 *
 */
public class Main {
	/**
	 * Execute the analysis with the input as the file name
	 * 
	 * @param args
	 *            the input command
	 */
	public static void main(String[] args) {
		System.out.println("[INFO ] Please give the correct file name in the following");
		Scanner cmdScanner = null;
		try {
			cmdScanner = new Scanner(System.in);
			File inputFile = new File(cmdScanner.nextLine());
			int[] kn = FileReader.getNK(inputFile);
			int[] array = FileReader.getArray(inputFile);
			Analysis.analyze(kn[0], kn[1], array);	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmdScanner != null) {
				cmdScanner.close();
			}
		}
	}

}
