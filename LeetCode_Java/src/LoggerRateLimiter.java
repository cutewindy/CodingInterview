import java.util.HashMap;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message 
 * should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be 
 * printed in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 * Example:
 * Logger logger = new Logger();
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true; 
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * 
 * Tags: Hash Table, Design
 * @author wendi
 *
 */
public class LoggerRateLimiter {
	
	class Node {
		int timestamp;
		String message;
		public Node(int timestamp, String message) {
			this.timestamp = timestamp;
			this.message = message;
		}
	}

	PriorityQueue<Node> minHeap;
	Set<String> set;
	public LoggerRateLimiter() {
		minHeap = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.timestamp - b.timestamp;
			}
		});
		set = new HashSet<>();
	}
	
	/**
	 * Method2: minHeap + HashSet
	 * A typical (accepted) solution is to keep a hash map of String that maps to the recent time stamp.
	 * But this way, it needs to keep the record of the entire messages, even when the message is rare.
	 * Alternatively, I keep a heap to get rid of the old message and set of String to keep the recent 
	 * messages only. This approach would make sense when the number of logs within 10 minutes time 
	 * window is not too large and when we have lots of different messages.
	 * @param int timestamp, String message
	 * @return boolean
	 * Time: O(nlog(n))
	 * Space: O(only the log happen within 10 min)
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (message == null || message.length() == 0) return true;
		while (!minHeap.isEmpty()) {
			if (timestamp - minHeap.peek().timestamp < 10) break;
			Node node = minHeap.poll();
			set.remove(node.message);
		}
		if (set.contains(message)) return false;
		minHeap.offer(new Node(timestamp, message));
		set.add(message);
		return true;
	}
	
//	Map<String, Integer> map;
//	/** Initialize your data structure here. */
//	public LoggerRateLimiter() {
//		map = new HashMap<>();
//	}
//	
//	/**
//	 * Method1: Hash Map, waste a lot of space
//	 * The problem with this approach is that your map size will keep growing. It will have messages 
//	 * that have come since the beginning even though we need to keep only the words that have come 
//	 * only 10 seconds before the current timestamp.
//	 * @param int timestamp, String message
//	 * @return boolean
//	 * Time: O(1)
//	 * Space: O(n)
//	 */
//	public boolean shouldPrintMessage(int timestamp, String message) {
//		if (message == null || message.length() == 0) return true;
//		if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
//			map.put(message, timestamp);
//			return true;
//		}
//		return false;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerRateLimiter result = new LoggerRateLimiter();
		System.out.println(result.shouldPrintMessage(1, "foo"));
		System.out.println(result.shouldPrintMessage(2, "bar"));
		System.out.println(result.shouldPrintMessage(3, "foo"));
		System.out.println(result.shouldPrintMessage(11, "foo"));
	}

}
