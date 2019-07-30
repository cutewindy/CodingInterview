/**
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in 
 * a row, and each pile has a positive integer number of stones piles[i].  The objective of the game 
 * is to end with the most stones. 
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 
 * 1 <= X <= 2M.  Then, we set M = max(M, X).
 * The game continues until all the stones have been taken.
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 * Example 1:
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 
 * piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, 
 * then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we 
 * return 10 since it's larger. 
 * Constraints:
 * 1. 1 <= piles.length <= 100
 * 2. 1 <= piles[i] <= 10 ^ 4
 * @author wendi
 *
 */
public class StoneGameII {
	
	
	/**
	 * DFS + Memorization + minMax
	 * dp[i][j]: max stone can get start from index i with M = j.
	 * @param int[] piles
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n^2)
	 */
	public int stoneGameII(int[] piles) {
		if (piles == null || piles.length == 0) return 0;
		int n = piles.length;
		int[] lastSum = new int[n];  // the sum from piles[i] to the end
		lastSum[n - 1] = piles[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			lastSum[i] = lastSum[i + 1] + piles[i];
		}
		int[][] dp = new int[n][n]; 
		return dfs(lastSum, dp, 0, 1);
	}
	
	private int dfs(int[] lastSum, int[][] dp, int i, int M) {
		if (i >= lastSum.length) return 0;
		if (2 * M >= lastSum.length - 1) return lastSum[i];
		if (dp[i][M] != 0) return dp[i][M];
		int min = Integer.MAX_VALUE;
		for (int x = 1; x <= 2 * M; x++) {
			min = Math.min(dfs(lastSum, dp, i + x, Math.max(x, M)), min); //the min value the next player can get
		}
		dp[i][M] = lastSum[i] - min; //max stones = all the left stones - the min stones next player can get
		return dp[i][M];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoneGameII result = new StoneGameII();
		System.out.println(result.stoneGameII(new int[] {2,7,9,4,4}));
	}

}
