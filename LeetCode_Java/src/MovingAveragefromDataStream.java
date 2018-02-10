import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the 
 * sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * @author wendi
 *
 */
public class MovingAveragefromDataStream {
	
	
	public double sum = 0.0;
	public int insert = 0, n = 0;
	public int[] window;
	
	public MovingAveragefromDataStream(int size) {
		window = new int[size];
	}

	/**
	 * Method2: Essentially, we just need to keep track of the sum of the current window as we go. 
	 * This prevents an O(n) traversal over the Queue as we add new numbers to get the new average. 
	 * If we need to evict then we just subtract that number off of our sum and divide by the size.
	 * @param int val
	 * @return double
	 * Time: O(1)
	 * Space: O(size)
	 */
	public double next(int val) {
		if (n < window.length) {
			n++;
		}
		sum -= window[insert];
		window[insert] = val;
		sum += val;
		insert = (insert + 1) % window.length;
		return sum / n;
	}
	
	
	
//	public double sum = 0.0;
//	public int maxSize = 0;
//	public Queue<Integer> queue;
//	
//	public MovingAveragefromDataStream(int size) {
//		queue = new LinkedList<>();
//		maxSize = size;
//	}
//
//	/**
//	 * Method1: Essentially, we just need to keep track of the sum of the current window as we go. 
//	 * This prevents an O(n) traversal over the Queue as we add new numbers to get the new average. 
//	 * If we need to evict then we just subtract that number off of our sum and divide by the size.
//	 * @param int val
//	 * @return double
//	 * Time: O(1)
//	 * Space: O(size)
//	 */
//	public double next(int val) {
//		if (queue.size() >= maxSize) {
//			sum -= queue.poll();
//		}
//		queue.offer(val);
//		sum += val;
//		return sum / queue.size();
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAveragefromDataStream result = new MovingAveragefromDataStream(3);
		System.out.println(result.next(1));
		System.out.println(result.next(10));
		System.out.println(result.next(3));
		System.out.println(result.next(5));
	}

}
