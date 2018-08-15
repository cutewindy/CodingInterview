import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated 
 * words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter 
 * words in the given array.
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * 1. The number of elements of the given array will not exceed 10,000
 * 2. The length sum of elements in the given array will not exceed 600,000.
 * 3. All the input string will only include lower case letters.
 * 4. The returned elements order does not matter.
 * @author wendi
 *
 */
public class ConcatenatedWords {
	
	/**
	 * Approach2: DP
	 * We iterate through each word and see if it can be formed by using other words. Same as the 
	 * "WordBreak"
	 * (Of course it is also obvious that a word can only be formed by words shorter than it. So we 
	 * can first sort the input by length of each word, and only try to form one word by using words 
	 * in front of it.)
	 * @param String[] words
	 * @return List<String>
	 * Time: O(nlog(n) + n*l^2) n=words.length, l=words[i].length()
	 * Space: O(n)
	 */
	public List<String> concatenatedWordsI(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		return a.length() - b.length();
        	}
        });
        
        for (String word: words) {
        	if (canFormI(word, dict)) {
        		res.add(word);
        	}
        	dict.add(word);
        }
        
        return res;
	}
	
	
	private boolean canFormI(String word, Set<String> dict) {
		if (word == null || word.length() == 0) return false;
		int n = word.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (i == n && j == 0) continue;    // at least two words
				if (dict.contains(word.substring(j, i)) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
	
	
	/**
	 * Approach1: Brute Force: DFS(TLE)
	 * Iterate through each word and see if it can be formed by using other words.
	 * @param String[] words
	 * @return List<String>
	 * Time: O(n*l) n=words.length, l=words[i].length()
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	public List<String> concatenatedWords(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        for (String word: words) {
        	if (canForm(word, dict, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }
	
	
	private boolean canForm(String word, Set<String> dict, int start, int count) {
		if (start == word.length() && count > 1) return true;
		for (int i = start; i < word.length(); i++) {
			if (dict.contains(word.substring(start, i + 1)) && canForm(word, dict, i + 1, count + 1)) {
                return true;
			}
		}  
        return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcatenatedWords result = new ConcatenatedWords();
		System.out.println(result.concatenatedWords(
				new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
		System.out.println(result.concatenatedWordsI(
				new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat","cat"}));
	}

}
