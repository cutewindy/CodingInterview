/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * S was sorted in some custom order previously. We want to permute the characters of T so that they 
 * match the order that S was sorted. More specifically, if x occurs before y in S, then x should 
 * occur before y in the returned string.
 * Return any permutation of T (as a string) that satisfies this property.
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also 
 * valid outputs.
 * Note:
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * @author wendi
 *
 */
public class CustomSortString {
	
	
	/**
	 * Use bucket sort to achieve linear time.
	 * 1. Put string T into bucket;
	 * 2. Scan each character of S and construct the result string using bucket;
	 * 3. Scan bucket again to append the rest of characters which are not existing in string S.
	 * @param String S, String T
	 * @return String
	 * Time: O(s + t)
	 * Space: O(1)
	 */
	public String customSortString(String S, String T) {
		if (T == null || T.length() == 0) return null;
        if (S == null || S.length() == 0) return T;
        int[] counter = new int[26];
        for (char c: T.toCharArray()) {
        	counter[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
        	while (counter[c - 'a']-- > 0) sb.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
        	while (counter[c - 'a']-- > 0) sb.append(c);
        }
        return sb.toString();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomSortString result = new CustomSortString();
		System.out.println(result.customSortString("cba", "abcdac"));
	}

}
