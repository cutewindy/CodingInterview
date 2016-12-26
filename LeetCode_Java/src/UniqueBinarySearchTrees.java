/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 * 
 * Tags: Tree, DP
 * @author wendi
 *
 */
public class UniqueBinarySearchTrees {

	/**
	 * DP:dp[j] means use j as root, then dp[j-1] is the number of left BST, dp[i-j] is the number of
	 * right BST. dp[i]+=dp[j-1]*dp[i-j], where 1<=j<=i.
	 * @param int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int uniqueBinarySearchTrees(int n) {
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}	
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees result = new UniqueBinarySearchTrees();
		System.out.println(result.uniqueBinarySearchTrees(5));
	}

}
