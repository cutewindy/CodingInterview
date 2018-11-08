package FB_onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * "第一题给的是word break ，不过是变种题，
 * 求最小合理分割次数"
 * @author wendi
 *
 */
public class WordBreakMinmumCut {
	
	/**
	 * Approach2: DP
	 * dp[i]: minimum cuts that split s[0,...,i] into words, which are in wordDict
	 * @param String s, List<String> wordDict
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int wordBreakMinmumCutI(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) return 0;
		Set<String> set = new HashSet<>();
		set.addAll(wordDict);
		int n = s.length();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (set.contains(word) && dp[j] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[j] + 1, dp[i]);
				}
			}
		}
		return dp[n] == Integer.MAX_VALUE ? 0 : dp[n];
	}
	
	
	/**
	 * Approach1: DFS + memorization
	 * @param String s, List<String> wordDict
	 * @return int
	 * Time: O(2^n)
	 * Space: O(n)
	 */
	public int wordBreakMinmumCut(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) return 0;
		Set<String> set = new HashSet<>();
		set.addAll(wordDict);
		int res = dfs(s, 0, set, new HashMap<Integer, Integer>());
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	
	private int dfs(String s, int start, Set<String> set, Map<Integer, Integer> map) {
		if (start == s.length()) return 0;
		if (map.containsKey(start)) return map.get(start);
		int res = Integer.MAX_VALUE;
		for (int i = start; i < s.length(); i++) {
			String word = s.substring(start, i + 1);
			if (set.contains(word)) {
				int cnt = dfs(s, i + 1, set, map);
				if (cnt == Integer.MAX_VALUE) continue;
				res = Math.min(cnt + 1, res);
			}
		}
		map.put(start, res);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreakMinmumCut result = new WordBreakMinmumCut();
		System.out.println("pine apple pen apple\n" + "pineapple pen apple\n" + "pine applepen apple\n");
		System.out.println(result.wordBreakMinmumCut("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
		System.out.println(result.wordBreakMinmumCut("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
		
		System.out.println();
		System.out.println(result.wordBreakMinmumCutI("pineapplepenapple", new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
		System.out.println(result.wordBreakMinmumCutI("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}

}
