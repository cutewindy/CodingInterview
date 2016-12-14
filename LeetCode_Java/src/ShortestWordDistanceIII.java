/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same 
 * as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these 
 * two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * Note:
 * You may assume word1 and word2 are both in the list.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class ShortestWordDistanceIII {
	
	/**
	 * Two Pointers: same like "shortestWordDistance", need to check whether word1 == word2.
	 * @param String[] words, String word1, String word2
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int shortestWordDistanceIII(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null) {
			return -1;
		}
		int index1 = -1;
		int index2 = -1;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) && word1.equals(word2)) {
				if (index1 < index2) {
					index1 = i;
				}
				else {
					index2 = i;
				}
			}
			else if (words[i].equals(word1)) {
				index1 = i;
			}
			else if (words[i].equals(word2)) {
				index2 = i;
			}
			if (index1 != -1 && index2 != -1) {
				result = Math.min(Math.abs(index1 - index2), result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestWordDistanceIII result = new ShortestWordDistanceIII();
		System.out.println(result.shortestWordDistanceIII(new String[] {"practice", "makes", "perfect", "coding", "makes", "makes"}, 
				"makes", "makes"));
	}

}
