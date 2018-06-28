/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little 
 * match girl has, please find out a way you can make one square by using up all those matchsticks. 
 * You should not break any stick, but you can link them up, and each matchstick must be used exactly 
 * one time.
 * Your input will be several matchsticks the girl has, represented with their stick length. Your 
 * output will either be true or false, to represent whether you could make one square using all the 
 * matchsticks the little match girl has.
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with 
 * length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * 1. The length sum of the given matchsticks is in the range of 0 to 10^9.
 * 2. The length of the given matchstick array will not exceed 15.
 * @author wendi
 *
 */
public class MatchstickstoSquare {
	
	/**
	 * DFS
	 * The partition problem (or number partitioning) is the task of deciding whether a given 
	 * multiset S of positive integers can be partitioned into two subsets S1 and S2 such that the 
	 * sum of the numbers in S1 equals the sum of the numbers in S2. The partition problem is 
	 * NP-complete. But the input will not be very large, can solve it with DFS
	 * @param int[] nums
	 * @return boolean
	 * Time: O(4^n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public boolean matchstickstoSquare(int[] nums) {
		if (nums == null || nums.length < 4) return false;
		int sum = 0;
		for (int n: nums) sum += n;
		if (sum % 4 != 0) return false;
		int target = sum / 4;
		return canMakeSquare(nums, 0, new int[4], target);
	}
	
	private boolean canMakeSquare(int[] nums, int index, int[] sums, int target) {
		if (index == nums.length) {
			return sums[0] == target && sums[1] == target && sums[2] == target;
		}
		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[index] > target) continue;
			sums[i] += nums[index];
			if (canMakeSquare(nums, index + 1, sums, target)) return true;
			sums[i] -= nums[index];
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchstickstoSquare result = new MatchstickstoSquare();
		System.out.println(result.matchstickstoSquare(new int[] {1,1,2,2,2}));
	}

}
