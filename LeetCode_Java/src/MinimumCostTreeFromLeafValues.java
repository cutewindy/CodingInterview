/**
 * Given an array arr of positive integers, consider all binary trees such that:
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  
 * (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and 
 * right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of 
 * each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 * Example 1:
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf 
 * node sum 32.
	    24            24
	   /  \          /  \
	  12   4        6    8
	 /  \               / \
	6    2             2   4
 * Constraints:
 * 1. 2 <= arr.length <= 40
 * 2. 1 <= arr[i] <= 15
 * 3. It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
 * @author wendi
 *
 */
public class MinimumCostTreeFromLeafValues {
	
	
	/**
	 * Approach1: DP
	 * dp[i][j]: answer of building a tree from a[i]...a[j]
	 * dp[i][j] = dp[i][k] + dp[k+1][j] + max(a[i],...,a[k])*max(a[k+1],...,a[j]), i<=k<j; 
	 * @param int[] arr
	 * @return int
	 * Time: O(n^3)
	 * Space: O(n^2)
	 */
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            int maxNum = arr[i];
            for (int j = i; j < n; j++) {
                maxNum = Math.max(arr[j], maxNum);
                max[i][j] = maxNum;
            }
        }
        int[][] dp = new int[n][n];
        for (int l = 2; l <= n; l++) {
            for (int s = 0; s < n - l + 1; s++) {
                int e = l + s - 1;
                dp[s][e] = Integer.MAX_VALUE;
                for (int k = s; k < e; k++) {
                    dp[s][e] = Math.min(dp[s][k] + dp[k + 1][e] + max[s][k] * max[k + 1][e], dp[s][e]);
                }
            }
        }
        return dp[0][n - 1];
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCostTreeFromLeafValues result = new MinimumCostTreeFromLeafValues();
		System.out.println(result.mctFromLeafValues(new int[] {1, 3, 4, 2, 1, 3}));
	}

}
