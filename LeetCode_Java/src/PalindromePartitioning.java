import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class PalindromePartitioning {

	/**
	 * Backtracking:
	 * @param String s
	 * @return List<List<Integer>>
	 * Time:O(n * n!)
	 * Space: O(n) n = s.length()
	 * Stack space: O(n)
	 */
	public List<List<String>> palindromePartitioning(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		helper(s, 0, new ArrayList<String>(), result);
		return result;
	}
	
	private void helper(String s, int start, List<String> combo, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<>(combo));
			return;
		}
		for (int end = start; end < s.length(); end++) {
			if (isPalindrome(s, start, end)) {
				combo.add(s.substring(start, end + 1));
				helper(s, end + 1, combo, result);
				combo.remove(combo.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning result = new PalindromePartitioning();
		System.out.println(result.palindromePartitioning("aab"));
	}

}
