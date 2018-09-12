import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty string, encode the string such that its encoded length is the shortest.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
 * being repeated exactly k times.
 * Note:
 * 1. k will be a positive integer and encoded string will not be empty or have extra space.
 * 2. You may assume that the input string contains only lowercase English letters. The string's 
 * length is at most 160.
 * 3. If an encoding process does not make the string shorter, then do not encode it. If there are 
 * several solutions, return any of them is fine.
 * Example 1:
 * Input: "aaa"
 * Output: "aaa"
 * Explanation: There is no way to encode it such that it is shorter than the input string, so we do 
 * not encode it.
 * Example 2:
 * Input: "aaaaa"
 * Output: "5[a]"
 * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
 * Example 3:
 * Input: "aaaaaaaaaa"
 * Output: "10[a]"
 * Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, 
 * which is the same as "10[a]".
 * Example 4:
 * Input: "aabcaabcd"
 * Output: "2[aabc]d"
 * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 * Example 5:
 * Input: "abbbabbbcabbbabbbc"
 * Output: "2[2[abbb]c]"
 * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one 
 * answer can be "2[2[
 * @author wendi
 *
 */
public class EncodeStringwithShortestLength {
	
	/**
	 * 
	 * @param String s
	 * @return String
	 * Time: O()
	 * Space: O()
	 */
//	public String encodeStringwithShortestLength(String s) {
//		if (s == null || s.length() <= 4) return s;
//		Map<Integer, String> seen = new HashMap<>();
//		return dfs(s, 0, seen);
//	}
//	
//	private String dfs(String s, int start, Map<Integer, String> seen) {
//		if (start + 4 >= s.length()) return s.substring(start, s.length());
//		if (seen.containsKey(start)) return seen.get(start);
//		String res = null;
//		StringBuilder sb = new StringBuilder();
//		for (int i = start; i < s.length(); i++) {
//			String subStr = s.substring(start, i + 1);
//			int cnt = repeatNum(s, start, subStr);
//			System.out.println("s: " + subStr + " cnt: " + cnt);
//			for (int j = 1; j <= cnt; j++) {
//				if (j == 1) sb.append(subStr).append(dfs(s, i + 1, seen));
//				else sb.append(j).append("[").append(subStr).append(dfs(s, start + (i - start + 1) * j, seen)).append("]");
//				if (res == null || res.length() > sb.length()) res = sb.toString();
//				System.out.println(res);
//			}
//		}
//		seen.put(start, res);
//		return res;
//	}
//	
//	private int repeatNum(String s, int start, String subStr) {
//		int cnt = 0;
//		int n = subStr.length();
//		for (int i = start; i + n <= s.length(); i += n) {
//			if (!s.substring(i, i + n).equals(subStr)) {
//				break;
//			}
//			cnt++;
//		}
//		return cnt;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncodeStringwithShortestLength result = new EncodeStringwithShortestLength();
		System.out.println(result.encodeStringwithShortestLength("abbbabbbcabbbabbbc"));
		
	}

}
