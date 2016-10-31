import java.util.ArrayList;
import java.util.Arrays;
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
		if (s == null || s.length() > t.length()) {
			return false;
		}
		Map<Character, List<Integer>> hash = new HashMap<>();
		char[] T = t.toCharArray();
		char[] S = s.toCharArray();
		for (int i = 0; i < T.length; i++) {
			if (hash.containsKey(T[i])) {
				hash.get(T[i]).add(i);
			}
			else {
				hash.put(T[i], new ArrayList<>(Arrays.asList(i)));
			}
		}
		for (Character c: hash.keySet()) {
			System.out.println(c + ": " + hash.get(c));
		}
		int index = -1;
		for (int i = 0; i < S.length; i++) {
			if (!hash.containsKey(S[i])) {
				return false;
			}
			index = binarySearchFirstEqualOrLarger(hash, S[i], index) + 1;
			if (index == -1) return false;
		}
		return true;
	}
	
	
	// Binary Search to find the possible minimum index in T, otherwise return -2
	private int binarySearchFirstEqualOrLarger(Map<Character, List<Integer>> hash, char c, int index) {
		if (!hash.containsKey(c)) return -2;
		Integer[] array = hash.get(c).toArray(new Integer[hash.get(c).size()]);
		int start = 0;
		int end = array.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == index) {
				return array[mid];
			}
			else if (array[mid] < index) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		if (array[start] >= index) return array[start];
		if (array[end] >= index) return array[end];
		return -2;
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
