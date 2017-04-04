package main.java;

/**
 * Analysis - The class finish the analysis work. This class will get the
 * decreasing and increasing sub array
 * 
 * @author yu
 *
 */
public class Analysis {
	/**
	 * Get the sum for increasing and decreasing sub array
	 * 
	 * @param n
	 *            the total size of the array
	 * @param k
	 *            the size of the sliding window
	 * @param array
	 *            the array
	 */
	public static void analyze(int n, int k, int[] array) {
		// should delete n for safety consideration
		if (k <= 0 || k > n || n <= 0 || array == null || array.length != n) {
			throw new IllegalArgumentException();
		}

		int[] countLeft = new int[n];
		int[] countRight = new int[n];

		// init the 2 count from different direction
		for (int i = 1; i < n; i++) {
			if (array[i] > array[i - 1]) {
				if (countLeft[i - 1] > 0) {
					countLeft[i] = countLeft[i - 1] + 1;
					countLeft[i] = Math.min(countLeft[i], k);
				} else {
					countLeft[i] = 1;
				}
			} else if (array[i] < array[i - 1]) {
				if (countLeft[i - 1] < 0) {
					countLeft[i] = countLeft[i - 1] - 1;
					countLeft[i] = Math.max(countLeft[i], -k);
				} else {
					countLeft[i] = -1;
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				if (countRight[i + 1] > 0) {
					countRight[i] = countRight[i + 1] + 1;
					countRight[i] = Math.min(countRight[i], k);
				} else {
					countRight[i] = 1;
				}
			} else if (array[i] < array[i + 1]) {
				if (countRight[i + 1] < 0) {
					countRight[i] = countRight[i + 1] - 1;
					countRight[i] = Math.max(countRight[i], -k);
				} else {
					countRight[i] = -1;
				}
			}
		}

		// init the sliding window
		double sum = 0; // use double to avoid overflow
		for (int i = 0; i < k; i++) {
			sum += countLeft[i];
		}
		System.out.printf("%.0f\n", sum);

		// slide the window
		for (int i = k; i < n; i++) {
			sum += countLeft[i];
			sum += countRight[i - k];
			/*
			 * the increasing array from right actually is the decreasing array
			 * from left direction. So -(-) = +
			 */
			System.out.printf("%.0f\n", sum);
		}

	}
}
