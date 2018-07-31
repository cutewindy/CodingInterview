import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be 
 * formed by deleting some characters of the given string. If there are more than one possible 
 * results, return the longest word with the smallest lexicographical order. If there is no possible 
 * result, return the empty string.
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output: 
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * Output: 
 * "a"
 * Note:
 * 1. All the strings in the input will only contain lower-case letters.
 * 2. The size of the dictionary won't exceed 1,000.
 * 3. The length of all the strings in the input won't exceed 1,000.
 * @author wendi
 *
 */
public class LongestWordinDictionarythroughDeleting {
	
	/**
	 * Method2: sort
	 * sort the input dictionary by longest length and lexicography. Then, we iterate through the 
	 * dictionary exactly once. In the process, the first dictionary word in the sorted dictionary 
	 * which appears as a subsequence in the input string s must be the desired solution.
	 * @param String s, List<String> d
	 * @return String
	 * Time: O(nlog(n) + nk) n = d.size(), k = d[i].length()
	 * Space: O(1)
	 */
	public String longestWordinDictionarythroughDeletingI(String s, List<String> d) {
		if (d == null || d.size() == 0) return "";
		Collections.sort(d, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if (a.length() != b.length()) return b.length() - a.length();
				return a.compareTo(b);
			}
		});
		for (String str: d) {
			if (isSubSequence(str, s)) return str;
		}
		return "";
	}
	
	
	/**
	 * Method1: No sort
	 * For each string in d, check whether it is subsequence of s, find the longest one with the 
	 * smallest lexicographical order
	 * @param String s, List<String> d
	 * @return String
	 * Time: O(nk) n = d.size(), k = d[i].length()
	 * Space: O(1)
	 */
	public String longestWordinDictionarythroughDeleting(String s, List<String> d) {
		if (d == null || d.size() == 0) return "";
		String res = "";
		for (String str: d) {
			if (isSubSequence(str, s) && 
				(str.length() > res.length() || str.length() == res.length() && str.compareTo(res) < 0)) {
				res = str;
			}
		}
		return res;
	}
	
	// check whether a is subsequence of b
	private boolean isSubSequence(String a, String b) {
		if (a.length() > b.length()) return false;
		int ai = 0;
		int bi = 0;
		while (ai < a.length() && bi < b.length()) {
			if (a.charAt(ai) == b.charAt(bi)) ai++;
			bi++;
		}
		return ai == a.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWordinDictionarythroughDeleting result = new LongestWordinDictionarythroughDeleting();
		System.out.println(result.longestWordinDictionarythroughDeleting("abpcplea", new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"))));
		System.out.println(result.longestWordinDictionarythroughDeleting("abpcplea", new ArrayList<>(Arrays.asList("a","b","c"))));
		System.out.println(result.longestWordinDictionarythroughDeletingI("abpcplea", new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"))));
		System.out.println(result.longestWordinDictionarythroughDeletingI("abpcplea", new ArrayList<>(Arrays.asList("a","b","c"))));
	}

}
