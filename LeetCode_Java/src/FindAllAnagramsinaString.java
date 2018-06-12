import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will 
 * not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Tags: Hash Table
 * @author wendi
 *
 */
public class FindAllAnagramsinaString {
	
	/**
	 * Sliding window
	 * @param String s, String p
	 * @return List<Integer>
	 * Time: O()
	 * Space: O()
	 */
	public List<Integer> findAllAnagramsinaString(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null && p == null) return res;
		char[] P = p.toCharArray();
		Arrays.sort(P);
		int n = P.length;
		for (int i = 0; i <= s.length() - n; i++) {
			char[] str = s.substring(i, i + n).toCharArray();
			Arrays.sort(str);
			if (Arrays.equals(str, P)) res.add(i);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllAnagramsinaString result = new FindAllAnagramsinaString();
		System.out.println(result.findAllAnagramsinaString("abab", "ab"));
	}

}
