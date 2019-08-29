/**
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used 
 * once).
 * Return the sum of lengths of all good strings in words.
 * Example 1:
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: 
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: 
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 * Note:
 * 1. 1 <= words.length <= 1000
 * 2. 1 <= words[i].length, chars.length <= 100
 * 3. All strings contain lowercase English letters only.
 * @author wendi
 *
 */
public class FindWordsThatCanBeFormedbyCharacters {
	
	/**
	 * char array
	 * @param String[] words, String chars
	 * @return int
	 * Time: O(n) n=words.length
	 * Space: O(1)
	 */
	public int findWordsThatCanBeFormedbyCharacters(String[] words, String chars) {
		if (words == null || words.length == 0) return 0;
		int[] counts = new int[26];
		for (char c: chars.toCharArray()) {
			counts[c - 'a']++;
		}
		int res = 0;
		for (String word: words) {
			if (isGood(counts, word)) res += word.length();
		}
		return res;
	}
	
	private boolean isGood(int[] counts, String word) {
		int[] wordCnts = new int[26];
		for (char c: word.toCharArray()) {
			wordCnts[c - 'a']++;
			if (wordCnts[c - 'a'] > counts[c - 'a']) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindWordsThatCanBeFormedbyCharacters result = new FindWordsThatCanBeFormedbyCharacters();
		System.out.println(result.findWordsThatCanBeFormedbyCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
	}

}
