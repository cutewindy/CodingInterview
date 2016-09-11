import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 */
public class ShuffleanArray {
	
	/**
	 * Using an int[] array to save the original nums
	 * reset(): just return array
	 * shuffle(): using a list to save the array, each time choose a num randomly from list, then 
	 * 	 		  remove it from list, until size = 0;
	 */
	int[] array;
	public ShuffleanArray(int[] nums) {
		array = nums;
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return array;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] result = new int[array.length];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			int index = (int) (Math.random() * list.size());
//			System.out.println(index);
			result[i] = list.get(index);
			list.remove(index);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShuffleanArray result = new ShuffleanArray(new int[] {1, 2, 3, 4, 5});
		System.out.println(Arrays.toString(result.reset()));
		System.out.println(Arrays.toString(result.shuffle()));
		System.out.println(Arrays.toString(result.shuffle()));
		System.out.println(Arrays.toString(result.reset()));
	}

}
