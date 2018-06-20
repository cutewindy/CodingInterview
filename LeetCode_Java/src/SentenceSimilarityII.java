import java.util.HashMap;
import java.util.Map;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of 
 * similar word pairs pairs, determine if two sentences are similar.
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are 
 * similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], 
 * ["acting","drama"], ["skills","talent"]].
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, 
 * and "fine" and "good" are similar, then "great" and "fine" are similar.
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" 
 * and "great" being similar.
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], 
 * words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like 
 * words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * Note:
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 * @author wendi
 *
 */
public class SentenceSimilarityII {
	
	
	/**
	 * UnionFindSet
	 * using hashmap to map word and index
	 * @param String[] words1, String[] words2, String[][] pairs
	 * @return boolean
	 * Time: O(n + l) l = words1.length
	 * Space: O(n) n = pairs.length
	 */
	public boolean sentenceSimilarityII(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) return false;
		Map<String, Integer> mapping = new HashMap<>();
		int index = 0;
		UnionFindSet ufs = new UnionFindSet(2 * pairs.length);
		for (String[] p: pairs) {
			for (String w: p) {
				if (!mapping.containsKey(w)) mapping.put(w, index++);
			}
			ufs.union(mapping.get(p[0]), mapping.get(p[1]));
		}
		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i])) continue;
			if (!mapping.containsKey(words1[i]) || !mapping.containsKey(words2[i]) ||
				ufs.find(mapping.get(words1[i])) != ufs.find(mapping.get(words2[i]))) return false;
		}
		return true;
	}
	
	
	class UnionFindSet {
		int[] parents;
		public UnionFindSet(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			while (parents[x] != x) {
				x = parents[x];
			}
			return x;
		}
		
		public boolean union(int a, int b) {
			int pA = find(a);
			int pB = find(b);
			if (pA != pB)  {
				parents[pA] = parents[pB];
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SentenceSimilarityII result = new SentenceSimilarityII();
		System.out.println(result.sentenceSimilarityII(
				new String[] {"great", "acting", "skills"}, 
				new String[] {"fine", "drama", "talent"}, 
				new String[][] {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}}));
	}

}
