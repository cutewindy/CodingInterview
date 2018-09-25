import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where 
 * different letters represent different tasks.Tasks could be done without original order. Each task 
 * could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, there must 
 * be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 * 1. The number of tasks is in the range [1, 10000].
 * 2. The integer n is in the range [0, 100].
 * @author wendi
 *
 */
public class TaskScheduler {
	
	/**
	 * PriorityQueue + queue
	 * Same like "358. Rearrange String k Distance Apart"
	 * @param char[] tasks, int n
	 * @return int
	 * Time: O(nlog(k)) n = task.length, k = average frequency of each char in tasks
	 * Space: O(k)
	 */
	public int taskScheduler(char[] tasks, int n) {
		if (n == 0) return tasks.length;
		// get frequency of each char
		Map<Character, Integer> cnts = new HashMap<>();
		for (char c: tasks) {
			if (!cnts.containsKey(c)) cnts.put(c, 0);
			cnts.put(c, cnts.get(c) + 1);
		}
		
		// init maxHeap
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
						return e2.getValue() - e1.getValue();
					}
				});
		maxHeap.addAll(cnts.entrySet());
		
		// init Queue
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		int m = tasks.length;
		int res = 0;
		while (m > 0) {
			Map.Entry<Character, Integer> curr = null;
			if (!maxHeap.isEmpty()) {
				curr = maxHeap.poll();
				curr.setValue(curr.getValue() - 1);
				m--;
			}
			res++;
			queue.offer(curr);
			if (queue.size() > n) {
				Map.Entry<Character, Integer> front = queue.poll();
				if (front != null && front.getValue() != 0) maxHeap.offer(front);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskScheduler result = new TaskScheduler();
		System.out.println(result.taskScheduler(new char[] {'A','A','A','B','B','B'}, 2));
		
	}

}
