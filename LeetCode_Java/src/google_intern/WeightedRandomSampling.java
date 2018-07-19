package google_intern;

import java.util.Random;

/**
 * Write a function that returns values randomly, according to their weight.
 * Let me give you an example. Suppose we have 3 elements with their weights: A (5), B (4) and C (1). 
 * The function should return A with probability 50%, B with 40% and C with 10% based on the weights.
 * @author wendi
 *
 */
public class WeightedRandomSampling {

	/**
	 * Method3:
	 * base on method1 with Binary search
	 * @param weights
	 * @return int
	 * Time: O(n + 1)  construct: O(n), query: O(1)
	 * Space: O(sum)
	 */
	public int weightedRandomSamplingII(int[] A, int[] W) {
		int sum = 0;
		for (int i = 0; i < W.length; i++) {
			sum += W[i];
			W[i] = sum;
		}
		int[] array = new int[sum];
		int index = 0;
		for (int i = 0; i < sum; i++) {
			if (i < W[index]) array[i] = A[index];
			else array[i] = A[++index];
		}
		
		// query
		Random rang = new Random();
		return array[rang.nextInt(sum)];
	}
	
	/**
	 * Method2:
	 * base on method1 with Binary search
	 * @param weights
	 * @return int
	 * Time: O(n + log(n)) construct: O(n), query: O(log(n))
	 * Space: O(1)
	 */
	public int weightedRandomSamplingI(int[] A, int[] W) {
		
		return -1;
	}
	
	/**
	 * Method1:
	 * In essence, we can denote the new set above as a horizontal line like this:
	 * {1,1,1,1,1,2,2,2,2,3}
	 * The sampling is like randomly select a point and see which area it falls into. Going into 
	 * this idea, we can have the following algorithm:
	 * Sum is the sum of all the weights (length of the horizontal line)
	 * Get a random number R from [0, sum) (randomly select a point)
	 * Go over each element in order and keep the sum of weights of visited elements. Once the sum 
	 * is larger than R, return the current element. This is finding which area includes the point.
	 * @param weights
	 * @return int
	 * Time: O(n+n) construct: O(n), query: O(n)
	 * Space: O(1)
	 */
	public int weightedRandomSampling(int[] A, int[] W) {
		int sum = 0;
		for (int i = 0; i < W.length; i++) {
			sum += W[i];
			W[i] = sum;
		}
		
		// query
		Random rang = new Random();
		int select = rang.nextInt(sum);
		for (int i = 0; i < W.length; i++) {
			if (select < W[i]) return A[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedRandomSampling result = new WeightedRandomSampling();
		System.out.println(result.weightedRandomSampling(new int[] {1, 2, 3}, new int[] {5, 4, 1}));
		System.out.println(result.weightedRandomSamplingII(new int[] {1, 2, 3}, new int[] {5, 4, 1}));
	}

}
