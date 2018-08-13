package google_intern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a 
 * list of n items, where n is either a very large or unknown number. Typically n is large enough 
 * that the list doesn’t fit into main memory. For example, a list of search queries in Google and 
 * Facebook.
 * So we are given a big array (or stream) of numbers (to simplify), and we need to write an 
 * efficient function to randomly select k numbers where 1 <= k <= n. Let the input array be stream[].
 * @author wendi
 *
 */
public class ReservoirSampling {
	// Ref: https://www.geeksforgeeks.org/reservoir-sampling/	
	
	/**
	 * Approach2: select k from a stream of n items randomly
	 * 1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
	 * 2) Now one by one consider all items from (k+1)th item to nth item.
	 *    a) Generate a random number from 0 to i where i is index of current item in stream[]. Let 
	 *    the generated random number is j.
 	 *    b) If j is in range 0 to k-1, replace reservoir[j] with stream[i]
	 * @param int[] stream, int k
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] reservoirSamplingI(int[] stream, int k) {
		int[] reservoir = new int[k];
		int n = stream.length;
		for (int i = 0; i < k; i++) reservoir[i] = stream[i];
		Random r = new Random();
		for (int i = k; i < n; i++) {
			int j = r.nextInt(i);
			if (j < k) reservoir[j] = stream[i];
		}
		return reservoir;
	}

	/**
	 * Approach1: Brute force + set
	 * Create an array reservoir[] of maximum size k. One by one randomly select an item from 
	 * stream[0..n-1]. If the selected item is not previously selected, then put it in reservoir[]. 
	 * To check if an item is previously selected or not, we use a set to save the previous selected
	 * items. This is not efficient if each time the random pick is previous selected items.
	 * @param int[] stream, int k
	 * @return int[]
	 * Time: O(?)
	 * Space: O(k)
	 */	
	public int[] reservoirSampling(int[] stream, int k) {
		int[] reservoir = new int[k];
		int n = stream.length;
		Set<Integer> set = new HashSet<>();
		Random r = new Random();
		for (int i = 0; i < k;) {
			int j = r.nextInt(n);
			if (set.contains(j)) continue;
			reservoir[i] = stream[j];
			set.add(j);
			i++;
		}
		return reservoir;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReservoirSampling result = new ReservoirSampling();
		int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int k = 5;
		System.out.println(Arrays.toString(result.reservoirSampling(stream, k)));
		System.out.println(Arrays.toString(result.reservoirSamplingI(stream, k)));
	}

}
