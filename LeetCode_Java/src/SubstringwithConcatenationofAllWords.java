import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in 
 * words exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * 
 * Tags: HashTable, Two pointeres, String
 * @author wendi
 *
 */
public class SubstringwithConcatenationofAllWords {

	/**
	 * Slide window: two hashTables + int start + int count
	 * @param String s, String[] words
	 * @return List<Integer>
	 * Time: O(n) n is the length of s(s.length() > words.length)
	 * Space: O(n)
	 */
	public List<Integer> substringwithConcatenationofAllWords(String s, String[] words) {
//		List<Integer> result = new ArrayList<>();
//		if (s == null || s.length() == 0 || words == null || words.length == 0) {
//			return result;
//		}
//		// 1 use counter to save the words needed to be find
//		Map<String, Integer> counter = new HashMap<>();
//		for (String word: words) {
//			if (counter.containsKey(word)) {
//				counter.put(word, counter.get(word) + 1);
//			}
//			else {
//				counter.put(word, 1);
//			}
//		}
//		// 2 find words and save first index at the same time
//		int x = words[0].length();  // x is the length of word in words
//		for (int i = 0; i < x; i++) {
//			int start = i;
//			int count = 0;  // use count to record how many words are found 
//			Map<String, Integer> hash = new HashMap<>(); // use hash to record the occurrence of each word that be find
//			for (int j = i; j < s.length() - x + 1;) {
//				String curr = s.substring(j, j + x);  // curr is word in s that might be the words in word 
//				// case 1: counter.containsKey(curr)
//				if (counter.containsKey(curr)) { // if curr is the word in words, save it in window(hash, count) and check occurrence, otherwise move window
//					count++;
//					if (hash.containsKey(curr)) {
//						hash.put(curr, hash.get(curr) + 1);
//					}
//					else {
//						hash.put(curr, 1);
//					}
//					while (hash.get(curr) > counter.get(curr)) { // out of words occurrence, move window, until satisfied, since need substring
//						String temp = s.substring(start, start + x);
//						hash.put(temp, hash.get(temp) - 1);
//						count--;
//						start += x;
//					}
//					if (count == words.length) { // if count equals to the words lenght, mean that find all the words in s
//						result.add(start);
//					}
//				}
//				// case 2: !counter.containsKey(curr)
//				else {
//					start = j + x;
//					count = 0;
//					hash.clear();
//				}
//				j += x;
//			}
//		}
//		return result;
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
        int n = s.length();
        int w = words.length;
        int wl = words[0].length();
        Map<String, Integer> counter = new HashMap<>();
        for (String word: words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            }
            else {
                counter.put(word, 1);
            }
        }
        for (int k = 0; k < wl; k++) {
            int start = k;
            int count = 0;
            Map<String, Integer> hash = new HashMap<>();
            for (int i = k; i <= n - wl;) {
                String curr = s.substring(i, i + wl);
                if (counter.containsKey(curr)) {
                    count++;
                    if (hash.containsKey(curr)) {
                        hash.put(curr, hash.get(curr) + 1);
                    }
                    else {
                        hash.put(curr, 1);
                    }
                    while (hash.get(curr) > counter.get(curr)) {
                        String temp = s.substring(start, start + wl);
                        hash.put(temp, hash.get(temp) - 1);
                        start += wl;
                        count--;
                    }
                    if (count == w) {
                        result.add(start);
                    }
                }
                else {
                    start = i + wl;
                    count = 0;
                    hash.clear();
                }
                System.out.println(i);
                i += wl;
            }
            System.out.println(k);
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringwithConcatenationofAllWords result = new SubstringwithConcatenationofAllWords();
//		System.out.println(result.substringwithConcatenationofAllWords("barfoobarthefoobarman", new String[] {"foo", "bar"}));
		System.out.println(result.substringwithConcatenationofAllWords("barfoofoobarthefoobarman", new String[] {"foo", "bar", "the"}));

	}

}
