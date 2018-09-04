import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent 
 * to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * S will consist of lowercase letters and have length in range [1, 500].
 * @author wendi
 *
 */
public class ReorganizeString {
	
	/**
	 * Greedy: PriorityQueue
	 * Greedy: fetch char of max count as next char in the result.
     * Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
	 * @param String s
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String reorganizeString(String s) {
		if (s == null || s.length() == 0) return "";
		int[] count = new int[26];
		for (char c: s.toCharArray()) {
			count[c - 'a']++;
			if (count[c - 'a'] > (s.length() + 1) / 2) return "";  // Impossible to form a solution
		} 
		
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(10, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) maxHeap.offer(new int[] {i, count[i]});
		}
		
		// Build the result.
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			int[] first = maxHeap.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char) (first[0] + 'a')) {
				sb.append((char) (first[0] + 'a'));
				if (--first[1] > 0) maxHeap.offer(first);
			}
			else {
				int[] second = maxHeap.poll();
				sb.append((char) (second[0] + 'a'));
				if (--second[1] > 0) maxHeap.offer(second);
				maxHeap.offer(first);
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorganizeString result = new ReorganizeString();
		System.out.println(result.reorganizeString("aab"));
	}

}
