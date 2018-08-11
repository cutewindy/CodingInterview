import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally 
 * likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * Tags: 
 * @author wendi
 * 
// FY Shuffle和Reservoir Sampling的比较：
// +--------------+----------------+-----------------------------+------+-------+
// | ALGORITHM    | INPUT(S)       | OUTPUT                      | TIME | SPACE |
// +--------------+----------------+-----------------------------+------+-------+
// | FISHER-YATES | n elements     | A list containing all n     | O(n) | O(n)  |
// | SHUFFLE      |                | elements in a random order  |      |       |
// +--------------+----------------+-----------------------------+------+-------+
// | RESERVOIR    | n elements and | A set containing k of the n | O(n) | O(k)  |
// | SAMPLING     | an integer k   | elements, selected randomly |      |       |
// +--------------+----------------+-----------------------------+------+-------+
 */
public class ShuffleanArray {
	
	int[] nums;
	public ShuffleanArray(int[] nums) {
		this.nums = nums;
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	/**
	 * Method2: array 
	 * using a array to keep the res, each time choose a index j from [0, i] randomly, swap (i, j), 
	 * the probability should be (n-1)/n * (n-2)/(n-1) * ... * i/(i+1) * 1/i = 1/n. Beside the last 
	 * one, they are the probability that j haven't been choose, and the last one is the probability 
	 * that j have been choose. Thus, the total probability of j can be choose is 1/n.
	 * Time: O(n)
	 * Space: O(1)
	 */	
	public int[] shuffleI() {
		int n = nums.length;
		int[] res = nums.clone();
		Random r = new Random();
		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			swap(res, i, j);
		}
		return res;
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/** Returns a random shuffling of the array. */
	/**
	 * Method1: List 
	 * using a array to save the array, each time choose a num randomly from list, then remove it 
	 * from list, until size = 0;
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int[] shuffle() {
		int[] result = new int[nums.length];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) list.add(nums[i]);
		for (int i = 0; i < nums.length; i++) {
			int index = (int) (Math.random() * list.size());
			result[i] = list.get(index);
			list.remove(index);
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuffleanArray result = new ShuffleanArray(new int[] {1, 2, 3, 4, 5});
		System.out.println("reset:   " + Arrays.toString(result.reset()));
		System.out.println("shuffle: " + Arrays.toString(result.shuffle()));
		System.out.println("shuffle: " + Arrays.toString(result.shuffle()));
		System.out.println("reset:   " + Arrays.toString(result.reset()));
		System.out.println("shuffle: " + Arrays.toString(result.shuffleI()));
		System.out.println("shuffle: " + Arrays.toString(result.shuffleI()));
		System.out.println("reset:   " + Arrays.toString(result.reset()));
	}

}
