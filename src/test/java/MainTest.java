package test.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import main.java.Analysis;
import main.java.FileReader;

/**
 * MainTest - Test the main functionality
 * 
 * @author yu
 *
 */
public class MainTest {
	private static final int MAX_N = 200000;

	/**
	 * test the worst case: the array is 1,2,3,...,200000 test if overflow or
	 * exceed the time limit
	 * @throws IOException 
	 * 
	 */
	@Test
	public void testWorstCase() throws IOException {
		System.out.println("[INFO ] Test the worest case");
		int[] kn = new int[] { MAX_N, MAX_N / 2 };
		int[] array = new int[MAX_N];
		for (int i = 0; i < MAX_N; i++) {
			array[i] = i + 1;
		}
		Analysis.analyze(kn[0], kn[1], array);
		/*
		 * for each window of size K = MAX_N /2, the sum should be 1 + 2 + ... +
		 * 99999 = (1 + 99999) * 99999 / 2 = 4999950000
		 */
	}
	
	/** test sample given */
	@Test
	public void testSampleText() {
		System.out.println("[INFO ] Test the sample text file");
		File inputFile = new File("./src/resource/sampleInput.txt");
		int[] kn = FileReader.getNK(inputFile);
		int[] array = FileReader.getArray(inputFile);
		Analysis.analyze(kn[0], kn[1], array);
	}

}
