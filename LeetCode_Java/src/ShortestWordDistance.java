/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these 
 * two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1. 
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class ShortestWordDistance {
	
	/**
	 * Two pointers: keep update index1 and index2.
	 * @param String[] words, String word1, String word2
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0 || word1 == null || word2 == null) {
			return -1;
		}
		int index1 = -1;
		int index2 = -1;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				index1 = i;
			}
			if (words[i].equals(word2)) {
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
		ShortestWordDistance result = new ShortestWordDistance();
		System.out.println(result.shortestWordDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, 
				"makes", "coding"));
	}

}
