import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as 
 * possible so that each letter appears in at most one part, and return a list of integers 
 * representing the size of these parts.
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * @author wendi
 *
 */
public class PartitionLabels {
	
	/**
	 * Greedy
	 * To partition into maximal number of such substrings, taking first such substring sub for 
	 * example, it cannot share any common characters with the rest of the string, so the minimum 
	 * length of sub has to cover the last positions of all characters it contains.
	 * 1. Pre-process s to record the last index position last[c] for each char c in s.
	 * 2. Scan s again, keep tracking and taking maximum of the last position last[c] of current 
	 *    char c. Whenever current index i hits the maximum of last positions, it means that we have 
	 *    traversed such a minimum substring and therefore record its lengths into result.
	 * @param String S
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<>();
		if (S == null || S.length() == 0) return result;
		char[] s = S.toCharArray();
		int[] map = new int[26];
		for (int i = 0; i < s.length; i++) {
			map[s[i] - 'a'] = Math.max(i, map[s[i] - 'a']);
		}
		int start = 0;
		int end = 0;
		for (int i = 0;i < s.length; i++) {
			end = Math.max(map[s[i] - 'a'], end);
			if (i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionLabels result = new PartitionLabels();
		System.out.println(result.partitionLabels("ababcbacadefegdehijhklij"));
	}

}
