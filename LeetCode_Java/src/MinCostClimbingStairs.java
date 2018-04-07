/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to 
 * reach the top of the floor, and you can either start from the step with index 0, or the step with 
 * index 1.
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 8 Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * 1. cost will have a length in the range [2, 1000].
 * 2. Every cost[i] will be an integer in the range [0, 999].
 * @author wendi
 *
 */
public class MinCostClimbingStairs {
	
	
	/**
	 * DP
	 * @param int[] cost
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length == 0) return 0;
		if (cost.length == 1) return cost[0];
		int n = cost.length;
		int dp1 = 0;
		int dp2 = 0;
		for (int i = 0; i < n; i++) {
			int dp0 = Math.min(dp1, dp2) + cost[i];
			dp2 = dp1;
			dp1 = dp0;
		}
		return Math.min(dp1, dp2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostClimbingStairs result = new MinCostClimbingStairs();
		System.out.println(result.minCostClimbingStairs(new int[] {10, 15, 20}));
		System.out.println(result.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
