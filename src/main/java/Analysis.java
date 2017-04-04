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

		// i is the last range (included)
		for (int i = k - 1; i < n; i++) {
			// what if N = 200,000 and the array is 1,2,3,4,..., 200,000?
			// use double instead of int to avoid overflow
			double sum = 0;
			double pre = 0;

			// j is the first range (first range not included)
			for (int j = i - k + 2; j <= i; j++) {
				if (array[j] > array[j - 1]) {
					if (pre > 0) {
						pre++;
					} else {
						pre = 1;
					}
				} else if (array[j] < array[j - 1]) {
					if (pre < 0) {
						pre--;
					} else {
						pre = -1;
					}
				} else {
					pre = 0;
				}
				sum += pre;
			}
			System.out.printf("%.0f\n", sum);
		}
	}
}
