import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that 
 * they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and 
 * index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * Tags: Array, Two pointers, Binary Search
 * @author wendi
 *
 */
public class TwoSumII_InputArrayIsSorted {

	/**
	 * Two pointers
	 * @param int[] numbers, int target
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] twoSum_InputArrayIsSorted(int[] numbers, int target) {
		int[] result = {-1, -1};
		if (numbers == null || numbers.length < 2) return result;
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				result[0] = start + 1;  // result not zero based
				result[1] = end + 1;
				return result;
			}
			else if (numbers[start] + numbers[end] < target) start++;
			else end--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumII_InputArrayIsSorted result = new TwoSumII_InputArrayIsSorted();
		System.out.println(Arrays.toString(result.twoSum_InputArrayIsSorted(new int[] {2, 3, 4}, 6)));
	}

}
