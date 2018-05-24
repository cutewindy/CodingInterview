import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its 
 * minimum value is exactly 1.
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence 
 * among all its possible subsequences.
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 * @author wendi
 *
 */
public class LongestHarmoniousSubsequence {
	
	
	
	/**
	 * Method3: HashMap
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int longestHarmoniousSubsequenceIII(int[] nums) {
		if (nums == null || nums.length == 0) return 0;                
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num: nums) {
			if (!map.containsKey(num)) map.put(num, 0);
			map.put(num, map.get(num) + 1);
			if (map.containsKey(num - 1)) res = Math.max(map.get(num) + map.get(num - 1), res);
			if (map.containsKey(num + 1)) res = Math.max(map.get(num) + map.get(num + 1), res);
		}
		return res;
	}
	
	
	
	/**
	 * Method2: Array sort
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int longestHarmoniousSubsequenceII(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		int prev = 0;
		int curr = 1;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 1) {
				prev = curr;
				curr = 1;
			}
			else if (nums[i] == nums[i - 1]) curr++;
			else {
				prev = 0;
				curr = 1;
			}
			if (prev > 0) res = Math.max(prev + curr, res);
		}
		return res;
	}
	
	
	
	/**
	 * Method1: Brute Force(TLE)
	 * @param int[] nums
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int longestHarmoniousSubsequenceI(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		for (int num: nums) {
			int count = 0;
			boolean find = false;
			for (int other: nums) {
				if (num == other) count++;
				else if (num - other == 1) {
					count++;
					find = true;
				}
			}
			if (find) res = Math.max(count, res);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestHarmoniousSubsequence result = new LongestHarmoniousSubsequence();
		System.out.println(result.longestHarmoniousSubsequenceI(new int[] {1,3,2,2,5,2,3,7}));
		System.out.println(result.longestHarmoniousSubsequenceII(new int[] {1,3,2,2,5,2,3,7}));
		System.out.println(result.longestHarmoniousSubsequenceIII(new int[] {1,3,2,2,5,2,3,7}));
	}

}
