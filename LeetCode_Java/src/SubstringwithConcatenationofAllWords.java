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
	 * Method2: Slide window: (25 ms)
	 * Travel all the words combinations to maintain a window, there are len times travel. Each time, 
	 * n/len words,
	 * For each travel time, move window by one word instead of one char
	 * @param String s, String[] words
	 * @return List<Integer>
	 * Time: O(n) n = s.length(), len = words[0].length()
	 * Space: O(m) m = words.length
	 */
	public List<Integer> substringwithConcatenationofAllWordsI(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
		
		// init word occurence
		Map<String, Integer> wordsMap = new HashMap<>();
		for (String w: words) wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
		
		int len = words[0].length();
		int n = words.length;
		// travel all sub string combinations
		for (int i = 0; i < len; i++) {
			Map<String, Integer> currMap = new HashMap<>();
			int count = 0;
			boolean noWord = false;
			for (int l = i, r = i; l <= s.length() - len;) {
				while (r <= s.length() - len && count < n) { // move right window to find satisfied words
					String str = s.substring(r, r + len);
					if (!wordsMap.containsKey(str)) {
						noWord = true;
						break;
					}
					if (wordsMap.get(str) < currMap.getOrDefault(str, 0) + 1) break;
					currMap.put(str, currMap.getOrDefault(str, 0) + 1);
					count++;
					r += len;
				}
				
				if (noWord) { // !wordsMap.containsKey(str), restart from next word
					currMap.clear();
					count = 0;
					noWord = false;
					l = r + len;
					r = l;
				}
				else {
					if (count == n) res.add(l);  // find all words in s
					String removeStr = s.substring(l, l + len);
					currMap.put(removeStr, currMap.get(removeStr) - 1); // move left window
					if (currMap.get(removeStr) == 0) currMap.remove(removeStr);
					count--;
					l += len;
				}
				
			}			
		}
		return res;
	}
	
	
	/**
	 * Method1: Brute force using hashmap (120 ms)
	 * for each start in s, check whether the substring contains all words 
	 * @param String s, String[] words
	 * @return List<Integer> 
	 * Time: O(n * m) n=s.length(), m = words.length
	 * Space: O(m)
	 */
    public List<Integer> substringwithConcatenationofAllWords(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String w: words) wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        int len = words[0].length();
        int n = words.length;
        for (int l = 0; l <= s.length() - len * n; l++) {
            Map<String, Integer> currMap = new HashMap<>();
            int count = 0;
            for (int r = l; r <= s.length() - len; r += len) {
                String str = s.substring(r, r + len);
                if (!wordsMap.containsKey(str) || wordsMap.get(str) < currMap.getOrDefault(str, 0) + 1) break;
                currMap.put(str, currMap.getOrDefault(str, 0) + 1);
                count++;
                if (count == n) {
                    res.add(l);
                    break;
                }
            }
        }
        return res;
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringwithConcatenationofAllWords result = new SubstringwithConcatenationofAllWords();
//		System.out.println(result.substringwithConcatenationofAllWords("barfoobarthefoobarman", new String[] {"foo", "bar"}));
		System.out.println(result.substringwithConcatenationofAllWords("barfoofoobarthefoobarman", new String[] {"foo", "bar", "the"}));
		System.out.println(result.substringwithConcatenationofAllWordsI("barfoothefoobarman", new String[] {"foo", "bar"}));
		System.out.println(result.substringwithConcatenationofAllWordsI("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
		System.out.println(result.substringwithConcatenationofAllWordsI("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));

	}

}
