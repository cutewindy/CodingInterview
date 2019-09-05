/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a 
 * different order. The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return 
 * true if and only if the given words are sorted lexicographicaly in this alien language.
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the 
 * sequence is unsorted.
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as 
 * the blank character which is less than any other character (More info).
 * Note:
 * 1. 1 <= words.length <= 100
 * 2. 1 <= words[i].length <= 20
 * 3. order.length == 26
 * 4. All characters in words[i] and order are english lowercase letters.
 * @author wendi
 *
 */
public class VerifyinganAlienDictionary {
	
	
	/**
	 * Brute force
	 * Build a transform mapping from order
	 * @param String[] words, String order
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean verifyinganAlienDictionary(String[] words, String order) {
		if (words == null || words.length == 0) return true;
		int[] index = new int[26];
		for (int i = 0; i < order.length(); i++) {
			index[order.charAt(i) - 'a'] = i;
		}
		for (int i = 0; i < words.length - 1; i++) {
			if (compare(words[i], words[i + 1], index) > 0) return false;
		}
		return true;
	}
	
	private int compare(String w1, String w2, int[] index) {
		int cmp = 0;
		for (int i = 0; i < w1.length() && i < w2.length() && cmp == 0; i++) {
			cmp = index[w1.charAt(i) - 'a'] - index[w2.charAt(i) - 'a'];
		}
		return cmp == 0 ? w1.length() - w2.length() : cmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyinganAlienDictionary result = new VerifyinganAlienDictionary();
		System.out.println(result.verifyinganAlienDictionary(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
	}

}
