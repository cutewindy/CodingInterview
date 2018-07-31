import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The 
 * longest uncommon subsequence is defined as the longest subsequence of one of these strings and 
 * this subsequence should not be any subsequence of the other strings.
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters 
 * without changing the order of the remaining elements. Trivially, any string is a subsequence of 
 * itself and an empty string is a subsequence of any string.
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon 
 * subsequence. If the longest uncommon subsequence doesn't exist, return -1.
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 * Note:
 * 1. All the given strings' lengths will not exceed 10.
 * 2. The length of the given list will be in the range of [2, 50].
 * @author wendi
 *
 */
public class LongestUncommonSubsequenceII {
	
	
	/**
	 * Sort the strings in the reverse order. If there is not duplicates in the array, then the 
	 * longest string is the answer.
	 * But if there are duplicates, and if the longest string is not the answer, then we need to 
	 * check other strings. But the smaller strings can be subsequence of the bigger strings.
	 * For this reason, we need to check if the string is a subsequence of all the strings bigger 
	 * than itself. If it's not, that is the answer.
	 * @param String[] strs
	 * @return int
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public int longestUncommonSubsequenceII(String[] strs) {
		if (strs == null || strs.length == 0) return 0;
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if (a.length() != b.length()) return b.length() - a.length();
				return a.compareTo(b);
			}
		});
		Set<String> duplicates = getDuplicate(strs);
		for (int i = 0; i < strs.length; i++) {
			if (duplicates.contains(strs[i])) continue;
			if (i == 0) return strs[0].length();
			for (int j = 0; j < i; j++) {
				if (isSubsequence(strs[i], strs[j])) break;
				if (j == i - 1) return strs[i].length();
			}
		}
		return -1;
	}
	
	// check whether a is subsequence of b
	private boolean isSubsequence(String a, String b) {
		if (a == null || a.length() == 0) return true;
		int ai = 0;
		int bi = 0;
		while (ai < a.length() && bi < b.length()) {
			if (a.charAt(ai) == b.charAt(bi)) ai++;
			bi++;
		}
		return ai == a.length();
	}
	
	private Set<String> getDuplicate(String[] strs) {
		Set<String> duplicates = new HashSet<>();
		Set<String> set = new HashSet<>();
		for (String str: strs) {
			if (set.contains(str)) duplicates.add(str);
			else set.add(str);
		}
		return duplicates;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUncommonSubsequenceII result = new LongestUncommonSubsequenceII();
		System.out.println(result.longestUncommonSubsequenceII(new String[] {"abcd", "abd", "cdc", "eae", "abcd"}));
	}

}
