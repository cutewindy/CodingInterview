/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or 
 * green. The cost of painting each house with a certain color is different. You have to paint all 
 * the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For 
 * example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of 
 * painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * Note:
 * All costs are positive integers.
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class PaintHouse {
	
	/**
	 * DP: dp[i][j]: paint house i with color j
	 * dp[i][j] = cost[i][j] + min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])
	 * @param int[][] cost
	 * @return int
	 * Time: O(3n)
	 * Space: O(3n) can use costs or just three int r, b, and g(only need row of i-1) 
	 * instead of int[][] to save space
	 */
	public int paintHouse(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int n = costs.length;
		int[][] dp = new int[n][3];
		// init
		for (int j = 0; j < 3; j++) {
			dp[0][j] = costs[0][j];
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintHouse result = new PaintHouse();
		System.out.println(result.paintHouse(new int[][] {{1, 2, 1}, {3, 1, 2}, {2, 1, 1}, {3, 2, 1}, {1, 2, 1}}));
	}

}
