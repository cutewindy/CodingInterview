import java.util.HashMap;
import java.util.Map;



/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 
 * symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * 1.The length of the given array is positive and will not exceed 20.
 * 2.The sum of elements in the given array will not exceed 1000.
 * 3.Your output answer is guaranteed to be fitted in a 32-bit integer.
 * @author wendi
 *
 */
public class TargetSum {

	/**
	 * Method3: DP
	 * @param int[] nums, int S
	 * @return int
	 * Time: O(n*sum) n=nums.length, sum=nums[0]+..+nums[n-1]
	 * Space: O(sum)
	 */
	public int findTargetSumWaysII(int[] nums, int S) {
		if (nums == null || nums.length == 0) return 0;
		int sum = 0;
		for (int n: nums) sum += n;
		int[] dp = new int[2 * sum + 1];
		
		// init
		dp[nums[0] + sum] += 1;
		dp[-nums[0] + sum] += 1;
		
		// update
		for (int i = 1; i < nums.length; i++) {       // i: index of nums
			int[] newDp = new int[2 * sum + 1];
			for (int j = 0; j < 2 * sum  + 1; j++) {  // j: nums[0]+nums[1]+..+nums[i-1]
				if (dp[j] == 0) continue;             // dp[j]: the count of sum(j), which equals to j
				newDp[nums[i] + j] += dp[j];          // newDp[+/-nums[i]] += dp[j]
				newDp[-nums[i] + j] += dp[j];
			}
			dp = newDp;
		}
		
		return sum >= dp.length - S ? 0 : dp[sum + S];  // take care
	}

	
	/**
	 * Method2: DFS + Memoization
	 * used a map to record the intermediate result while we are walking along the recursion tree
	 * @param int[] nums, int S
	 * @return int
	 * Time: O(2^n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public int findTargetSumWaysI(int[] nums, int S) {
		if (nums == null || nums.length == 0) return 0;
		return getTargetSumWays(nums, 0, 0, S, new HashMap<String, Integer>());
	}
	
	private int getTargetSumWays(int[] nums, int index, int sum, int target, Map<String, Integer> map) {
		if (index == nums.length && sum == target) return 1;
		if (index == nums.length) return 0;
		
		String key = index + "->" + sum;
		if (map.containsKey(key)) return map.get(key);
		
		int add = getTargetSumWays(nums, index + 1, sum + nums[index], target, map);
		int minus = getTargetSumWays(nums, index + 1, sum - nums[index], target, map); 
		
		map.put(key, add + minus);
		
		return add + minus;
	}
	
	/**
	 * Method1: BruteForce DFS
	 * @param int[] nums, int S
	 * @return int
	 * Time: O(2^n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	private int res;
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) return 0;
		res = 0;
		findSum(nums, 0, 0, S);
		return res;
	}
	
	private void findSum(int[] nums, int i, int sum, int S) {
		if (i == nums.length && sum == S) {
			res++;
			return;
		}
		if (i == nums.length) return;
		findSum(nums, i + 1, nums[i] + sum, S);
		findSum(nums, i + 1, -nums[i] + sum, S);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetSum result = new TargetSum();
		System.out.println(result.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(result.findTargetSumWaysI(new int[] {1, 1, 1, 1, 1}, 3));
		System.out.println(result.findTargetSumWaysII(new int[] {1, 1, 1, 1, 1}, 3));
	}

}
