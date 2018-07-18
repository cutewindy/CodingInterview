package google_intern;
/**
 * Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. 
 * An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 * Each item may be chosen unlimited number of times
 * Example
 * Given candidate items [2,3,6,7] and target 7,
 * A solution set is: 
 * [7]
 * [2, 2, 3]
 * return 2
 * @author wendi
 *
 */
public class BackpackIV {
	
	
	/**
	 * Same like LeetCode: "Combination Sum"
	 * DP
	 * 重复选择（+唯一排列） => 装满可能性总数
	 * 在n个物品中挑选(可重复)若干物品装入体积为m的背包，有几种装法
	 * dp[i][j]: ways to pick a few from first i items (multiple times allowed) with a exact backpack size of j 
	 * @param int m, int[] A
	 * @return int
	 * Time: O(m*n)
	 * Space: O(m*n) can reduce to O(m)
	 */
	public int backPackIV(int m, int[] A) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        // init
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        
        // update
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		dp[i][j] = dp[i - 1][j] +                            // not pick ith item
        				   (j >= A[i - 1] ? dp[i][j - A[i - 1]] : 0);// pick ith item
        	}
        }
        
        return dp[n][m];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackpackIV result = new BackpackIV();
		System.out.println(result.backPackIV(7, new int[] {2,3,6,7}));
	}

}
