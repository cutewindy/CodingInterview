import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * dfs + memorization:
	 * @param String s
	 * @return List<List<Integer>>
	 * Time:O(n * n^2)
	 * Space: O(n) n = s.length()
	 * Stack space: O(n)
	 */
    public List<List<String>> palindromePartitioningI(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<Integer, List<List<String>>> map = new HashMap<>(); // [index, {possible palindrome partition of s[i,..,n-1]}]
        return dfs(s, 0, map);
    }
    
    private List<List<String>> dfs(String s, int start, Map<Integer, List<List<String>>> map) {
        List<List<String>> res = new ArrayList<>();
        if (start == s.length()) {
            res.add(new ArrayList<String>());
            return res;
        }
        if (map.containsKey(start)) return map.get(start);
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrom(str)) {
                List<List<String>> nexts = dfs(s, i + 1, map);
                for (List<String> next: nexts) {
                    List<String> list = new ArrayList<>(next); // take care
                    list.add(0, str);
                    res.add(list);
                }
            }
        }
        map.put(start, res);
        return res;
    }
    
    private boolean isPalindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    
    

	/**
	 * Backtracking:
	 * @param String s
	 * @return List<List<Integer>>
	 * Time:O(n * n^2)
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
		System.out.println(result.palindromePartitioningI("aab"));
	}

}
