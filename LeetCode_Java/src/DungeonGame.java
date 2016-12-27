/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of 
 * a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight 
 * (K) was initially positioned in the top-left room and must fight his way through the dungeon 
 * to rescue the princess.
 * The knight has an initial health point represented by a positive integer. If at any point his
 *  health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon
 *  entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase
 *   the knight's health (positive integers).
 * In order to reach the princess as quickly as possible, the knight decides to move only 
 * rightward or downward in each step.
 * Write a function to determine the knight's minimum initial health so that he is able to rescue 
 * the princess.
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if
 *  he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
		-2 (K)	-3		3
		-5		-10		1
		10		30		-5 (P)
 * 
 * Notes:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the 
 * bottom-right room where the princess is imprisoned.
 * 
 * Tags: BinarySearch, DP
 * @author wendi
 *
 */
public class DungeonGame {
	
	/**
	 * DP: dp[i][j]: min health point needed at position (i, j), then do the calculation from 
	 * right-bottom to left-up.
	 * The remaining health value should be at least 1, that is, healthPoint + dungeon >= 1, we 
	 * have dp[i][j] = max(lastHealthPoint - dungeon[i][j], 1).
	 * If dp[i][j] can go both dp[i+1][j] and dp[i][j+1], we should choose a path with less health 
	 * point between dp[i+1][j] and dp[i][j+1] since it require less health point of dp[i][j]. Go 
	 * from right-bottom to left-up can make sure that the passed dp[i][j] will not below 1.
	 * @param int[][] dungeon
	 * @return int
	 * Time: O(m * n)
	 * Space: O(m * n) can be optimized by using dungeon
	 */
	public int dungeonGame(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0) {
			return 0;
		}
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		// init
		dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
		}
		for (int j = n - 2; j >= 0; j--) {
			dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
		}
		// update
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
				dp[i][j] = Math.max(dp[i][j], 1);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DungeonGame result = new DungeonGame();
		System.out.println(result.dungeonGame(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
	}

}
