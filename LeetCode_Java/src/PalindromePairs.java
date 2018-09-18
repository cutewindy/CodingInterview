import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so 
 * that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1:
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * @author wendi
 *
 */
public class PalindromePairs {
	
	/**
	 * Approach2: Trie
	 * @param String[] words
	 * @return List<List<Integer>>
	 * Time: O()
	 * Space: O()
	 */
//	public List<List<Integer>> palindromePairsI(String[] words) {
//        
//    }
//	
//	class TrieNode {
//		
//	}
	
	/**
	 * Approach1: HashMap
	 * There are several cases to be considered that isPalindrome(s1 + s2):
	 * Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 
	 * are palindrome.
	 * Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
	 * Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:], 
	 * then s2+s1 is palindrome.
	 * Case 4: Similar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing 
	 * string of s1[0:cut] , then s1+s2 is palindrome.
	 * To make the search faster, build a HashMap to store the word-index pairs.
	 * @param String[] words
	 * @return List<List<Integer>>
	 * Time: O(n*k^2) n: length of words, k: average length of word in words
	 * Space: O(n)
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>(); // (key, value): (word, index)
        for (int i = 0; i < words.length; i++) {
        	map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
        	for (int j = 0; j <= words[i].length(); j++) {    //handle empty string in the input. like ["a", ""];
        		String word1 = words[i].substring(0, j);  
        		String word2 = words[i].substring(j);
        		if (isPalindrome(word1)) {
        			String reverseWord2 = new StringBuilder(word2).reverse().toString();
        			if (map.containsKey(reverseWord2) && map.get(reverseWord2) != i) {
        				res.add(Arrays.asList(map.get(reverseWord2), i));
        			}
        		}
        		if (word2.length() != 0 && isPalindrome(word2)) {    // put word2.length()!=0 to avoid duplicates
        			String reverseWord1 = new StringBuilder(word1).reverse().toString();
        			if (map.containsKey(reverseWord1) && map.get(reverseWord1) != i) {
        				res.add(Arrays.asList(i, map.get(reverseWord1)));
        			}
        		}
        	}
        }
        return res;
    }	
	
	private boolean isPalindrome(String s) {
		if (s.length() <= 1) return true;
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePairs result = new PalindromePairs();
		System.out.println(result.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));
//		System.out.println(result.palindromePairsI(new String[] {"abcd","dcba","lls","s","sssll"}));

	}

}
