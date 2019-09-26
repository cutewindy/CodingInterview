/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s 
 * will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p 
 * are present in s. In particular, your input is the string p and you need to output the number of 
 * different non-empty substrings of p in the string s.
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * Example 1:
 * Input: "a"
 * Output: 1
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the 
 * string s.
 * @author wendi
 *
 */
public class UniqueSubstringsinWraparoundString {
	
	
	
	
	/**
	 * dp
	 * 我们看abcd这个字符串，以d结尾的子字符串有abcd, bcd, cd, d，那么我们可以发现bcd或者cd这些以d结尾的字符串的子字符
	 * 串都包含在abcd中，那么我们知道以某个字符结束的最大字符串包含其他以该字符结束的字符串的所有子字符串，说起来很拗口，但
	 * 是理解了我上面举的例子就行。那么题目就可以转换为分别求出以每个字符(a-z)为结束字符的最长连续字符串就行了，我们用一个
	 * 数组cnts记录下来，最后在求出数组cnts的所有数字之和就是我们要的结果啦
	 * @param String p
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int uniqueSubstringsinWraparoundString(String p) {
		if (p == null || p.length() == 0) return 0;
		int len = 1; // dp[i]: max number of valid substring end at p[i], dp[i] = dp[i-1]+1 if p[i]-p[i - 1] = 1
		int[] cnts = new int[26];
		for (int i = 0; i < p.length(); i++) {
			if (i != 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) len++;
			else len = 1;
			cnts[p.charAt(i) - 'a'] = Math.max(len, cnts[p.charAt(i) - 'a']);
		}
		int res = 0;
		for (int cnt: cnts) res += cnt;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueSubstringsinWraparoundString result = new UniqueSubstringsinWraparoundString();
		System.out.println(result.uniqueSubstringsinWraparoundString("cac"));
	}

}
