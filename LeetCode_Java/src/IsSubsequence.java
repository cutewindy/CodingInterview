import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a 
 * very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting 
 * some (can be none) of the characters without disturbing the relative positions of the remaining 
 * characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by 
 * one to see if T has its subsequence. In this scenario, how would you change your code?
 * 
 * Tags: BinarySearch, DP, Greedy
 * @author wendi
 *
 */
public class IsSubsequence {

	/**
	 * Method2: Binary Search (follow up)
	 * Using hash<Character, List<Integer>> to record the index of T, and then find possible index.
	 * @param String s, String t
	 * @return boolean
	 * Time: O(kmlog(n))
	 * Space: O(n)
	 */
	public boolean isSubsequenceI(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.length() > t.length()) return false;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        
        int index = -1;
        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) return false;
            int indexInT = getNextIndexInT(map.get(c), index);
            if (indexInT == -1) return false;
            index = indexInT;
        }
        
        return true;
	}
	
	
	// Binary Search to find the possible minimum index in T, otherwise return -1
	private int getNextIndexInT(List<Integer> list, int index) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == index) return mid + 1 < list.size() ? list.get(mid + 1) : -1;
            else if (list.get(mid) < index) start = mid;
            else end = mid;
        } 
        if (list.get(start) > index) return list.get(start);
        if (list.get(end) > index) return list.get(end);
        if (end + 1 < list.size()) return list.get(end + 1);
        return -1;
	}
	
	
	/**
	 * Method1: Brute Force
	 * @param String s, String t
	 * @return boolean
	 * Time: O(k(m + n))  k is the times to call isSubsequence(), m is the length of s, n is the length of t
	 * Space: O(1)
	 */
	public boolean isSubsequence(String s, String t) {
		if (s == null || s.length() > t.length()) {
			return false;
		}
//		int is = 0;
//		int it = 0;
//		char[] S = s.toCharArray();
//		char[] T = t.toCharArray();
//		while (is < s.length() && it < t.length()) {
//			if (S[is] == T[it]) {
//				is++;
//			}
//			it++;
//		}
//		return is == s.length();
//		
//		// or (faster:2ms)
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			index = t.indexOf(s.charAt(i), index);
			if (index == -1) {
				return false;
			}
			index++;
		}
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubsequence result = new IsSubsequence();
		System.out.println(result.isSubsequence("ace", "abcde"));
		System.out.println(result.isSubsequenceI("acd", "ccbbcacadbadc"));
	}

}
