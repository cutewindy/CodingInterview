import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters 
 * are at least distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, 
 * return an empty string "".
 * Example 1:
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc" 
 * Explanation: The same letters are at least distance 3 from each other.
 * Example 2:
 * Input: s = "aaabc", k = 3
 * Output: "" 
 * Explanation: It is not possible to rearrange the string.
 * Example 3:
 * Input: s = "aaadbbcc", k = 2
 * Output: "abacabcd"
 * Explanation: The same letters are at least distance 2 from each other.
 * @author wendi
 *
 */
public class RearrangeStringKDistanceApart {
	
	/**
	 * Greedy: HashMap + PriorityQueue
	 * The greedy algorithm is that in each step, select the char with highest remaining count if 
	 * possible (if it is not in the waiting queue). PQ is used to achieve the greedy. A regular 
	 * queue waitQueue is used to "freeze" previous appeared char in the period of k.
	 * In each iteration, we need to add current char to the waitQueue and also release the char at 
	 * front of the queue, put back to maxHeap. The "impossible" case happens when the result sb's 
	 * length is not the same as input s.
	 * @param String s, int k
	 * @return String
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String rearrangeStringKDistanceApart(String s, int k) {
		if (s == null || s.length() == 0) return "";
		if (k == 0) return s;
		Map<Character, Integer> count = new HashMap<>();
		for (char c: s.toCharArray()) {
			if (!count.containsKey(c)) count.put(c, 0);
			count.put(c, count.get(c) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>
		(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
				if (e2.getValue().intValue() != e1.getValue().intValue()) return e2.getValue() - e1.getValue();
				return e1.getKey() - e2.getKey();
			}
		});
		maxHeap.addAll(count.entrySet());
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> curr = maxHeap.poll();
			sb.append(curr.getKey());
			curr.setValue(curr.getValue() - 1);
			queue.offer(curr); //note that char with 0 count still needs to be placed in waitQueue as a place holder
			if (queue.size() >= k) {  // intial k-1 chars, waitQueue not full yet
				Map.Entry<Character, Integer> front = queue.poll();
				if (front.getValue() != 0) maxHeap.offer(front);
			}
		}
		return sb.length() == s.length() ? sb.toString() : "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RearrangeStringKDistanceApart result = new RearrangeStringKDistanceApart();
		System.out.println(result.rearrangeStringKDistanceApart("aabbcc", 3));
	}

}
