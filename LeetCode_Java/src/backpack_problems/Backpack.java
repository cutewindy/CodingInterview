package backpack_problems;
/**
 * Lintcode 92: Backpack
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill 
 * this backpack?
 * Example
 * Example 1:
 * 	Input:  [3,4,8,5], backpack size=10
 * 	Output:  9
 * Example 2:
 * 	Input:  [2,3,5,7], backpack size=12
 * 	Output:  12
 * Challenge
 * O(n x m) time and O(m) memory.
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * Notice
 * You can not divide any item into small pieces.
 * @author wendi
 *
 */
public class Backpack {
	
	
	/**
	 * Approach2: DP
	 * dp[i][j]: 前i个物品可不可以装满j的空间
	 * dp[i][j] = dp[i-1][j-A[i]] || dp[i-1][j]
	 * dp[i-1][j-A[i]]:前(i-1)个物品可以装满(j-A[i])的空间
	 * dp[i-1][j]:前i个物品可以装满j的空间
	 * res = 最大可以装满的空间
	 * @param int m, int[] A
	 * @return int
	 * Time: O(mn)
	 * Space: O(m) rolling array
	 */
    public int backPackI(int m, int[] A) {
        int n = A.length;
        boolean[][] canFill = new boolean[2][m + 1];
        int res = 0;
        // init
        canFill[0][0] = true;
        // update
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j <= m; j++) {
        		if (j - A[i - 1] >= 0) canFill[i % 2][j] = canFill[(i - 1) % 2][j - A[i - 1]] || canFill[(i - 1) % 2][j];
        		else canFill[i % 2][j] = canFill[(i - 1) % 2][j];
        		if (canFill[i % 2][j] && j > res) res = j;
        	}
        }
        return res;
    }
	
    
	/**
	 * Approach1: DP 0-1背包问题
	 * Same like backpackII, V = A
	 * @param int m, int[] A
	 * @return int
	 * Time: O(mn)
	 * Space: O(m)
	 */
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[2][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - A[i - 1] >= 0) dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j - A[i - 1]] + A[i - 1], dp[(i - 1) % 2][j]);
                else dp[i % 2][j] = dp[(i - 1) % 2][j];
            }
        }
        return dp[n % 2][m];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Backpack result = new Backpack();
		System.out.println(result.backPack(10, new int[] {3,4,8,5}));
		System.out.println(result.backPackI(10, new int[] {3,4,8,5}));
	}

}
