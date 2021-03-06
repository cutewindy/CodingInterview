/**
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of 
 * two strings. The longest uncommon subsequence is defined as the longest subsequence of one of 
 * these strings and this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters 
 * without changing the order of the remaining elements. Trivially, any string is a subsequence of 
 * itself and an empty string is a subsequence of any string.
 * The input will be two strings, and the output needs to be the length of the longest uncommon 
 * subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * Example 1:
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
 * because "aba" is a subsequence of "aba", 
 * but not a subsequence of any other strings in the group of two strings. 
 * Note:
 * Both strings' lengths will not exceed 100.
 * Only letters from a ~ z will appear in input strings.
 * @author wendi
 *
 */
public class LongestUncommonSubsequenceI {

	/**
	 * Math
	 * Simple analysis of this problem can lead to an easy solution.
	 * These three cases are possible with string a and b:
	 * 1. a=b. If both the strings are identical, it is obvious that no subsequence will be uncommon.
	 * Hence, return -1.
	 * 2. length(a)=length(b)length(a)=length(b) and a != b. Example: abc and abd. In this case we 
	 * can consider any string i.e. abc or abd as a required subsequence, as out of these two strings 
	 * one string will never be a subsequence of other string. Hence, return length(a) or length(b).
	 * 3. length(a) != length(b). Example abcd and abc. In this case we can consider bigger string 
	 * as a required subsequence because bigger string can't be a subsequence of smaller string. 
	 * Hence, return max(length(a),length(b)).
	 * @param String a, String b
	 * @return int
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int longestUncommonSubsequenceI(String a, String b) {
		if (a == null || b == null) return -1;
		if (a.equals(b)) return -1;
		return Math.max(a.length(), b.length());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUncommonSubsequenceI result = new LongestUncommonSubsequenceI();
		System.out.println(result.longestUncommonSubsequenceI("aba", "cbc"));
	}

}
