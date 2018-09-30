import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence 
 * of S.
 * Example :
 * Input: 
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 * @author wendi
 *
 */
public class NumberofMatchingSubsequences {
	
	/**
	 * Approach3: HashMap + Queue
	 * using map to record the words start with same character. 
	 * then iterate string s to find whether subword's length is 1, 
	 * if it is, add count,
	 * else put the subsubstring into queue of map
	 * @param String S, String[] words
	 * @return int
	 * Time: O(w + s*l) s = s.length(), l = words[i].length(), w = words.length
	 * Space: O(w)
	 */
	public int numberofMatchingSubsequencesII(String S, String[] words) {
		Map<Character, Queue<String>> map = new HashMap<>();
		for (String word: words) {
			Character startChar = word.charAt(0);
			if (!map.containsKey(startChar)) map.put(startChar, new LinkedList<String>());
			map.get(startChar).add(word);
		}
		int res = 0;
		for (char c: S.toCharArray()) {
			if (!map.containsKey(c)) continue;
			int size = map.get(c).size();
			while (size-- > 0) {
				String word = map.get(c).poll();
				if (word.length() == 1) {
					res++;
					continue;
				}
				String subWord = word.substring(1);
				Character startChar = subWord.charAt(0);
				if (!map.containsKey(startChar)) map.put(startChar, new LinkedList<String> ());
				map.get(startChar).add(subWord);
			}
		}
		return res;
	}
	
	
	
	/**
	 * Approach2: Indexing(HashMap) + Binary Search
	 * using List[] array to record the index of char int S. 
	 * when check each word in words, can use binary search to find the next index, and check whether
	 * it is valid.
	 * @param String S, String[] words
	 * @return int
	 * Time: O(s + w*l*log(s)) s = s.length(), l = words[i].length(), w = words.length
	 * Space: O(s)
	 */
	public int numberofMatchingSubsequencesI(String S, String[] words) {
		Map<Character, List<Integer>> indexes = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (!indexes.containsKey(S.charAt(i))) indexes.put(S.charAt(i), new ArrayList<Integer>());
			indexes.get(S.charAt(i)).add(i);
		}
		int res = 0;
		for (String word: words) {
			if (found(indexes, word)) res++;
		}
		return res;
	}
	
	private boolean found(Map<Character, List<Integer>> indexes, String word) {
		int index = -1;
		for (char c: word.toCharArray()) {
			if (!indexes.containsKey(c)) return false;
			index = getNextIndex(indexes.get(c), index);
			if (index == -1) return false;
		}
		return true;
	}
	
	private int getNextIndex(List<Integer> list, int index) {
		int start = 0;
		int end = list.size() - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (list.get(mid) <= index) start = mid;
			else end = mid;
		}
		if (list.get(start) > index) return list.get(start);
		if (list.get(end) > index) return list.get(end);
		return -1;
	}
	
	
	/**
	 * Approach1: Brute force (TLE)
	 * @param String S, String[] words
	 * @return int
	 * Time: O((s+l) * w) s = s.length(), l = words[i].length(), w = words.length
	 * Space: O(1)
	 */
	public int numberofMatchingSubsequences(String S, String[] words) {
        int res = 0;
        for (String word: words) {
            if (match(S, word)) res++;
        }
        return res;
    }
    
    private boolean match(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) j++;
            i++;
        }
        return j == word.length();		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofMatchingSubsequences result = new NumberofMatchingSubsequences();
		System.out.println(result.numberofMatchingSubsequences("abcde", new String[] {"a", "bb", "acd", "ace"}));
		System.out.println(result.numberofMatchingSubsequencesI("abcde", new String[] {"a", "bb", "acd", "ace"}));
		System.out.println(result.numberofMatchingSubsequencesII("abcde", new String[] {"a", "bb", "acd", "ace"}));
	}

}
