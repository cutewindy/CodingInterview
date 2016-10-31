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
	 * DP + MinMax
	 * @param int n
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int guessNumberHigherorLowerII(int n) {
		if (n <= 0) {
			return 0;
		}
		int[][] cost = new int[n + 1][n + 1];
		return cost[1][n];
	}
	
	public void helper(int n, int[][] cost) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
