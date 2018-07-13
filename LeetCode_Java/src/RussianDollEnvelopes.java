import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope
 *  is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can
 *  Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * Tags: Binary Search, DP
 * @author wendi
 *
 */
public class RussianDollEnvelopes {

	/**
	 * DP: 
	 * dp[i]: the max envelopes within at e[i];
	 * dp[i] = max(dp[j]+1) (j=0,...,i-1), where e[j][0]<e[i][0] && e[j][1] < e[i][1]
	 * res = max(dp[i]) (i=0,...,n-1)
	 * @param int[][] envelopes
	 * @return int
	 * Time: O(n^2) use binary search to reduce time to O(nlog(n))
	 * Space: O(n)
	 */
	public int russianDollEnvelopesI(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) return 0;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) return a[0] - b[0];
				return a[1] - b[1];
			}
		});		
		int n = envelopes.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			res = Math.max(dp[i], res);
		}
		return res;
	}
	
	
	/**
	 * DFS + MEMOIZATION
	 * @param int[][] envelopes
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public int russianDollEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) return 0;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) return a[0] - b[0];
				return a[1] - b[1];
			}
		});
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < envelopes.length; i++) {
			res = Math.max(dfs(envelopes, i + 1, envelopes[i], map), res);
		}
		return res;
	}	
	
	private int dfs(int[][] envelopes, int start, int[] prev, Map<Integer, Integer> map) {
		if (start == envelopes.length) return 1;
		if (map.containsKey(start)) return map.get(start);
		int res = 1;
		for (int i = start; i < envelopes.length; i++) {
			if (prev[0] < envelopes[i][0] && prev[1] < envelopes[i][1]) {
				res = Math.max(dfs(envelopes, i + 1, envelopes[i], map) + 1, res);
			}
		}
		map.put(start, res);
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RussianDollEnvelopes result = new RussianDollEnvelopes();
		System.out.println(result.russianDollEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
		System.out.println(result.russianDollEnvelopesI(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
	}

}
