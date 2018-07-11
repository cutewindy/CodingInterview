import java.util.HashMap;
import java.util.Map;

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
	 * Method2 : DFS + MEMOIZATION
	 * The idea is to use each number i as root node, then the left branch will be what's less than 
	 * i, the right branch will be what's larger than i. The total number of distinct structure is 
	 * their product. Thus, sum up the product for all numbers. Use a map to memorize the visited 
	 * number.
	 * @param int n
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public int uniqueBinarySearchTreesI(int n) {
		if (n == 0) return 0;
		return dfs(n, new HashMap<Integer, Integer>());
	}

	private int dfs(int n, Map<Integer, Integer> map) {
		if (n == 0 || n == 1) return 1;
		if (map.containsKey(n)) return map.get(n);
		int res = 0;
		for (int root = 1; root <= n; root++) {
			int left = dfs(root - 1, map);
			int right = dfs(n - root, map);
			res += left * right;
		}
		map.put(n, res);
		return res;
	}
	
	
	
	/**
	 * Method1 : DP
	 * dp[j] means use j as root, then dp[j-1] is the number of left BST, dp[i-j] is the number of
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
		System.out.println(result.uniqueBinarySearchTreesI(5));
	}

}
