import java.util.HashMap;
import java.util.Map;

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
	
	
	Map<String, Integer> map;
	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
		map = new HashMap<>();
	}
	
	
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
	/**
	 * Method1: Hash Map
	 * The problem with this approach is that your map size will keep growing. It will have messages 
	 * that have come since the beginning even though we need to keep only the words that have come 
	 * only 10 seconds before the current timestamp.
	 * @param int timestamp, String message
	 * @return boolean
	 * Time: O()
	 * Space: O()
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (message == null || message.length() == 0) return true;
		if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
			map.put(message, timestamp);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerRateLimiter result = new LoggerRateLimiter();
		System.out.println(result.shouldPrintMessage(1, "foo"));
		System.out.println(result.shouldPrintMessage(2, "bar"));
		System.out.println(result.shouldPrintMessage(3, "foo"));
		System.out.println(result.shouldPrintMessage(11, "foo"));
	}

}
