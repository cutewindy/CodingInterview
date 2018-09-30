/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game 
 * when you guess the number I picked.
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * Hint:
 * 1. The best strategy to play the game is to minimize the maximum loss you could possibly face. 
 * 2. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
 * Take a small example (n = 3). What do you end up paying in the worst case?
 * 3. Check out this article if you're still stuck.
 * 4. The purely recursive implementation of minimax would be worthless for even a small n. You MUST 
 * use dynamic programming.
 * 5. As a follow-up, how would you modify your code to solve the problem of minimizing the expected 
 * loss, instead of the worst-case loss?
 * 
 * Tags: DP
 * @author wendi
 *
 */
public class GuessNumberHigherorLowerII {

	/**
	 * DP + MinMax:
	 * Definition of dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
	 * Target: dp[1][n].
	 * Corner case: dp[i][i] = 0 (because the only element must be correct).
	 * Equation: we can choose k (i<=k<=j) as our guess, and pay price k. After our guess, the 
	 * problem is divided into two subproblems. Notice we do not need to pay the money for both 
	 * subproblems. We only need to pay the worst case (because the system will tell us which side 
	 * we should go) to guarantee win. So dp[i][j] = min(i<=k<=j){k + max(dp[i][k-1], dp[k+1][j])}.
	 * @param int n
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n^2)
	 */
	public int guessNumberHigherorLowerII(int n) {
		if (n <= 0) {
			return 0;
		}
		int[][] costs = new int[n + 1][n + 1];
		for (int l = 2; l <= n; l++) {
			for (int i = 1; i + l - 1 <= n; i++) {
				int j = i + l - 1;
				costs[i][j] = Integer.MAX_VALUE;
//				System.out.println("i: " + j + " j: " + j);
				for (int k = i; k <= j; k++) {
					costs[i][j] = Math.min(k + Math.max(k - 1 < i ? 0 : costs[i][k - 1],
														k + 1 > j ? 0 : costs[k + 1][j]), 
							 			   costs[i][j]);
				}
//				for (int z = 0; z < n + 1; z++) {
//					System.out.println(Arrays.toString(costs[z]));
//				}
//				System.out.println("==============");
			}
		}
		return costs[1][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessNumberHigherorLowerII result = new GuessNumberHigherorLowerII();
		System.out.println(result.guessNumberHigherorLowerII(7));
	}

}
