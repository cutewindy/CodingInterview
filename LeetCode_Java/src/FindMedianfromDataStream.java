import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is 
 * no middle value. So the median is the mean of the two middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * @author wendi
 *
 */
public class FindMedianfromDataStream {
	
	/**
	 * Method2: two heaps
	 * Two priority queues: (lo is allowed to hold n or n+1 elements, while hi can hold n elements)
	 * 1. A max-heap lo to store the smaller half of the numbers
	 * 2. A min-heap hi to store the larger half of the numbers
	 * Adding a number num:
	 * 1. Add num to max-heap lo. Since lo received a new element, we must do a balancing step for 
	 * hi. So remove the largest element from lo and offer it to hi.
	 * 2. The min-heap hi might end holding more elements than the max-heap lo, after the previous 
	 * operation. We fix that by removing the smallest element from hi and offering it to lo.
	 */
	Queue<Integer> lo;  // maxheap
	Queue<Integer> hi;  // minheap
	public FindMedianfromDataStream() {
		lo = new PriorityQueue<Integer>(10, new Comparator<Integer>() {   
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		hi = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
	}
	
	/**
	 * @param int num
	 * Time: O(log(n))
	 * Space: O(n)
	 */
	public void addNum(int num) {
		lo.add(num);            // add to maxheap
		hi.add(lo.poll());      // balancing step
		if (lo.size() < hi.size()) lo.add(hi.poll());   // maintain size property
	}
	 
	public double findMedian() {
		if (lo.size() != hi.size()) return lo.peek() * 1.0;
		return (lo.peek() + hi.peek()) / 2.0;
	}
	
	
	
//	/**
//	 * Method1: (TLE) Keeping input container always sorted by using list insert func
//	 */
//    List<Integer> list;
//    public FindMedianfromDataStream() {
//        list = new ArrayList<>();
//    }
//    
//    /**
//     * @param int num
//     * Time: O(n)
//     * Space: O(n)
//     */
//    public void addNum(int num) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) > num) {
//                list.add(i, num);
//                return;
//            }
//        }
//        list.add(num);
//    }
//    
//    /**
//     * 
//     * @return
//     * Time: O(1)
//     * Space: O(n)
//     */
//    public double findMedian() {
//        int n = list.size();
//        if (n % 2 != 0) return (double) list.get(n / 2);
//        return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedianfromDataStream result = new FindMedianfromDataStream();
		result.addNum(1);
		result.addNum(2);
		System.out.println(result.findMedian());
		result.addNum(3);
		System.out.println(result.findMedian());
	}

}
