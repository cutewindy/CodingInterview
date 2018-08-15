import java.util.HashSet;
import java.util.Set;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3. The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5. The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {

	
	/**
	 * Method2: Divide and Conquer + char array: 
	 * 先统计出字符串中每个字符出现的次数，对于出现次数少于k的字符，任何一个包含该字符的字符串都不是符合要求的子串，因此这样
	 * 的字符就是分隔符，应该以这些出现次数少于k次的字符做分隔符打断原字符串，然后对各个打断得到的字符串进行递归统计，得到最
	 * 长的符合要求的字符串。如果一个字符串中不包含分隔符(即每个字符出现的次数都达到了k次及以上次数)，那么这个字符串就是符合
	 * 要求的子串。
	 * @param String s, int k
	 * @return int
	 * Time: O(n^2)
	 * Space: O(26)
	 * Stack space: O(n)
	 */
	public int longestSubstringwithAtLeastKRepeatingCharactersI(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k) return 0;
		if (k <= 1) return s.length();
		return dfs(s, k);
	}
	
	private int dfs(String s, int k) {
		if (s.length() == 0 || s.length() < k) return 0;
		int[] counts = new int[26];
		for (char c: s.toCharArray()) counts[c - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (counts[s.charAt(i) - 'a'] < k) {
				return Math.max(dfs(s.substring(0,  i), k), dfs(s.substring(i + 1), k)); 
			}
		}
		return s.length();
	}
	
	
	/**
	 * Method1: Brute Force + window + set
	 * @param String s, int k
	 * @return int
	 * Time: O(n^2)
	 * Space: O(26)
	 */
	public int longestSubstringwithAtLeastKRepeatingCharacters(String s, int k) {
		if (s == null || s.length() == 0) return 0;
		if (k <= 1) return s.length();
		int res = 0;
		char[] S = s.toCharArray();
		for (int i = 0; i < S.length; i++) {
			int[] counts = new int[26];
			int cnt = 0;
			Set<Character> set = new HashSet<>();
			for (int j = i; j < S.length; j++) {
				set.add(S[j]);
				counts[S[j] - 'a']++;
				if (counts[S[j] - 'a'] == k) cnt++;
				if (set.size() == cnt && j - i + 1 > res) res = j - i + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtLeastKRepeatingCharacters result = new LongestSubstringwithAtLeastKRepeatingCharacters();
		System.out.println(result.longestSubstringwithAtLeastKRepeatingCharacters("abcababbdabae", 2));
		System.out.println(result.longestSubstringwithAtLeastKRepeatingCharactersI("abcababbdabae", 2));
	}

}
