/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class IncreasingTripletSubsequence {

	/**
	 * start with two largest values, as soon as we find a number bigger than both, while both have 
	 * been updated, return true.
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean increasingTripletSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) { 
			return false;
		}
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int num: nums) {
			if (num <= firstMin) firstMin = num;  // update small if n is smaller than both
			else if (num <= secondMin) secondMin = num; // update big only if greater than small but smaller than big
			else return true; // return if you find a number bigger than both
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IncreasingTripletSubsequence result = new IncreasingTripletSubsequence();
		System.out.println(result.increasingTripletSubsequence(new int[] {2, 5, 3, 4, 1, 6}));
		System.out.println(result.increasingTripletSubsequence(new int[] {2, 5, 1, 4, 4}));
	}

}
