import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters 
 * in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique 
 * minimum window in S.
 * 
 * Tags: HashTable, Two pointers, String
 * @author wendi
 *
 */
public class MinimumWindowSubstring {
	
	/**
	 * Method2: slide window, using one int[256] array instead of hash and two pointer instead of list
	 * @param String s, String t
	 * @return String
	 * Time: O(n)
	 * Space: O(256)
	 */
	public String minimumWindowSubstring(String s, String t) {
		if (s == null || t == null || s.length() < t.length() || t.length() == 0) return "";
		int[] charCnt = new int[256];
		int cnt = 0;  // the number of different characters in t
		for (char c: t.toCharArray()) {
			if (charCnt[c] == 0) cnt++;
			charCnt[c]++;
		}
		char[] S = s.toCharArray();
		String res = "";
		for (int start = 0, end = 0; start < S.length; start++) {
			while(end < S.length && cnt != 0) {
				charCnt[S[end]]--;
				if (charCnt[S[end]] == 0) cnt--;
				end++;
			}
			if (cnt == 0 && 
			    (res.length() == 0 || res.length() > end - start)) res = s.substring(start, end);
			if (charCnt[S[start]] == 0) cnt++;
			charCnt[S[start]]++;
		}
		return res;
	}
// another version
//    public String minWindow(String s, String t) {
//        char[] S = s.toCharArray();
//        char[] T = t.toCharArray();
//        int[] charCnts = new int[256];
//        for (char c: T) {
//            charCnts[c]++;
//        }
//        int cnt = 0;
//        String res = "";
//        for (int start = 0, end = 0; start < S.length; start++) {
//            while (end < S.length && cnt < T.length) {
//                if (charCnts[S[end]]-- > 0) cnt++;
//                end++;
//            }
//            if (cnt == T.length && (res.length() == 0 || end - start < res.length())) res = s.substring(start, end);
//            if (++charCnts[S[start]] > 0) cnt--;
//        }
//        return res;
//    }	
	
	
	/**
	 * Method1: slide window + hash table + list:
	 * Using a window to save the valid index of character and a hash to save the list of character's 
	 * index, which is in the window, update window and hash, and check list size using counter 
	 * when doing the iteration.
	 * @param String s, String t
	 * @return String
	 * Time: O(n + m), n is the length of s, m is the length of t, in fact, n > m
	 * Space: O(n + m), n is the length of s, m is the length of t
	 */
//	public String minimumWindowSubstring(String s, String t) {
//		String result = new String();
//		if (s == null || t == null || s.length() < t.length() || t.length() == 0) {
//			return result;
//		}
//		Map<Character, Integer> counter = new HashMap<>(); // record the occurrence of Character in t
//		for (int i = 0; i < t.length(); i++) {
//			char c = t.charAt(i);
//			if (counter.containsKey(c)) {
//				counter.put(c, counter.get(c) + 1);
//			}
//			else {
//				counter.put(c, 1);
//			}
//		}
//		List<Integer> window = new ArrayList<>();
//		Map<Character, List<Integer>> hash = new HashMap<>(); // integer is the index of character, list length is determine by counter           th
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (counter.containsKey(c)) {  // filter	
//				// 1. update character's list in hash
//				if (hash.containsKey(c)) { 
//					hash.get(c).add(i);
//				}
//				else {
//					List<Integer> list = new ArrayList<>(Arrays.asList(i));
//					hash.put(c, list);
//				}
//				// 2. update window
//				window.add(i);             
//				// 3. check list's size of each character is not large than counter, otherwise 
//				//    remove from both list of hash and window
//				if (hash.get(c).size() > counter.get(c)) {
//					window.remove(Integer.valueOf(hash.get(c).get(0))); // window remove the value hash.get(c).get(0)
//					hash.get(c).remove(0); // hash remove the first value in the list
//				}
//				// 4. update result
//				if (window.size() == t.length()
//				&& (result.length() == 0 || window.get(window.size() - 1) - window.get(0) + 1 < result.length())) {
//					result = s.substring(window.get(0), window.get(window.size() - 1) + 1);
//				}
//				if (window.size() == t.length()) {
//					System.out.println(s.substring(window.get(0), window.get(window.size() - 1) + 1));
//				}
//			}
//		}
//		return result;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring result = new MinimumWindowSubstring();
		System.out.println(result.minimumWindowSubstring("ADOBECODEBANC", "ABC"));
//		System.out.println(result.minimumWindowSubstring("bdab", "ab"));

	}

}
