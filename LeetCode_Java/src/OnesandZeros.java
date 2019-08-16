/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we 
 * always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is 
 * an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 
 * 1s. Each 0 and 1 can be used at most once.
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * Example 1:
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are 
 * “10,”0001”,”1”,”0”
 * Example 2:
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 * @author wendi
 *
 */
public class OnesandZeros {
	
	
	/**
	 * DP
	 * This problem is a typical 0-1 knapsack problem
	 * we need to pick several strings in provided strings to get the maximum number of strings 
	 * using limited number 0 and 1. We can create a three dimensional array, in which dp[i][j][k] 
	 * means the maximum number of strings we can get from the first i argument strs using limited 
	 * j number of '0's and k number of '1's.
	 * For dp[i][j][k], we can get it by fetching the current string i or discarding the current 
	 * string, which would result in dp[i][j][k] = dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] 
	 * and dp[i][j][k] = dp[i-1][j][k]; We only need to treat the larger one in it as the largest 
	 * number for dp[i][j][k].
	 * 
	 * @param String[] strs, int m, int n
	 * @return int
	 * Time: O(l*m*n)
	 * Space: O(l*m*n)
	 */
    public int onesandZeros(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int l = strs.length;
        int[][] counts = new int[l][2];
        for (int i = 0; i < l; i++) {
            counts[i] = getCount(strs[i]);
        }
        int[][][] dp = new int[l + 1][m + 1][n + 1];
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= counts[i - 1][0] && k >= counts[i - 1][1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - counts[i - 1][0]][k - counts[i - 1][1]] + 1, dp[i][j][k]);
                    }
                }
            }
        }
        return dp[l][m][n];
    }
    
    private int[] getCount(String str) {
        int[] res = new int[2];
        for (char c: str.toCharArray()) {
            if (c == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnesandZeros result = new OnesandZeros();
		System.out.println(result.onesandZeros(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
	}

}
