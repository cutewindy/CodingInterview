import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will 
 * not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * Tags: Hash Table
 * @author wendi
 *
 */
public class FindAllAnagramsinaString {
	
	/**
	 * Sliding window, same like "567. Permutation in String"
	 * @param String s, String p
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> findAllAnagramsinaString(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] cnts = new int[26];  // number of each char in p 
        for (char c: p.toCharArray()) cnts[c - 'a']++;
        
        char[] array = s.toCharArray();
        int n = p.length();
        int cnt = 0;
        // init, initiate the first n-1 characters of window
        for (int i = 0; i < n - 1; i++) {
            if (cnts[array[i] - 'a']-- > 0) cnt++;
        }
        
        // update
        int start = 0;
        int end = n - 1;
        while (end < array.length) {
        	// move right every time, if the character exists in p's hash, increase the count
            // current hash value > 0 means the character is existing in p
            if (cnts[array[end] - 'a']-- > 0) cnt++; 
            
            // when the count equals to n(p.length()), means we found the anagram of p
            // then add window's left to result list
            if (cnt == n) res.add(start);
            
            // move left (narrow the window) to find the new match window
            // if the character exists in p's hash, decrease the count
            if (++cnts[array[start] - 'a'] > 0) cnt--;
            start++;
            end++;
        }
        
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllAnagramsinaString result = new FindAllAnagramsinaString();
		System.out.println(result.findAllAnagramsinaString("cbaebabacd", "abc"));
		System.out.println(result.findAllAnagramsinaString("abab", "ab"));
	}

}
