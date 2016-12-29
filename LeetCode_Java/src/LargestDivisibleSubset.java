import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair 
 * (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 * 
 * Tags: DP, Math
 * @author wendi
 *
 */
public class LargestDivisibleSubset {
	
	/**
	 * DP: dp[i] means the LDS of nums[i], index[i] means the previous index of nums[s] that satisfied
	 * LDS. If nums[i]%nums[j]==0 and dp[i]<dp[j]+1, should choose j as the previous index of nums[i],
	 * then dp[i]=dp[j]+1, index[i]=j.
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n];
		int[] index = new int[n];
		int maxLength = 1;
		int lastIndex = 0;
		// init
		dp[0] = 1;
		Arrays.fill(index, -1);
		// update
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					index[i] = j;	
				}
			}
			// save the beginning index of LDS
			if (dp[i] > maxLength) {
				maxLength = dp[i];
				lastIndex = i;
			}
		}
		while (lastIndex != -1) {
			result.add(0, nums[lastIndex]);
			lastIndex = index[lastIndex];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestDivisibleSubset result = new LargestDivisibleSubset();
		System.out.println(result.largestDivisibleSubset(new int[] {1, 2, 3, 4, 5, 6, 8, 9, 72}));

	}

}
