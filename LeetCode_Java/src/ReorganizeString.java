import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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
	public String reorganizeString(String S) {
		if (S == null || S.length() == 0) return "";
		int[] count = new int[26];
		for (char c: S.toCharArray()) {
			count[c - 'a']++;
			if (count[c - 'a'] > (S.length() + 1) / 2) return "";  // Impossible to form a solution
		} 
		
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
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
        int[] queue = null;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) (curr[0] + 'a'));
            curr[1]--;
            if (queue != null) {
                maxHeap.offer(queue);
                queue = null;
            }
            if (curr[1] > 0) queue = curr;
        }
		
		return sb.toString();
	}
	
	
	/**
	 * Greedy: PriorityQueue
	 * Greedy: fetch char of max count as next char in the result.
     * Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
	 * @param String s
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	*/
    public String reorganizeStringI(String S) {
        if (S == null || S.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c: S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        maxHeap.addAll(map.entrySet());
        Map.Entry<Character, Integer> prev = null;
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            sb.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            if (prev != null) maxHeap.offer(prev);
            if (curr.getValue() != 0) prev = curr;
            else prev = null;
        }
        if (sb.length() < S.length()) return "";
        return sb.toString();
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorganizeString result = new ReorganizeString();
		System.out.println(result.reorganizeString("aab"));
	}

}
