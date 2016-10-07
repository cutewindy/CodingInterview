import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that 
 * calls are being made to the system in chronological order (ie, the timestamp is monotonically 
 * increasing). You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.
 * Example:
 * HitCounter counter = new HitCounter();
 * // hit at timestamp 1.
 * counter.hit(1);
 * // hit at timestamp 2.
 * counter.hit(2);
 * // hit at timestamp 3.
 * counter.hit(3);
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * // hit at timestamp 300.
 * counter.hit(300);
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301); 
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 * 
 * Tags: Design
 * @author wendi
 *
 */
public class DesignHitCounter {
	
	/**
	 * Method2: Using two arrays
	 * times array for every second because we only need to keep the recent hits info for 300 seconds. 
	 * hits array is wrapped around by mode operation. Each hit array is associated with times[] array 
	 * which record current time. If it is not current time, it means it is 300s or 600s... ago and 
	 * need to reset to 1.
	 */
	int[] times;
	int[] hits;
    public DesignHitCounter() {
        this.times = new int[300];
        this.hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] == timestamp) {
        	hits[index]++;
        }
        else {
        	times[index] = timestamp;
        	hits[index] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < 300; i++) {
        	if (timestamp - times[i] < 300) {
        		count += hits[i];
        	}
        }
        return count;
    }
	
    
    
	/**
	 * Method1: using queue to record the information of all the hits. 
	 * Each time we call the function getHits( ), we have to delete the elements which hits beyond 
	 * 5 mins (300). The result would be the length of the queue
	 * Consider: There are 1000 frequent hit() followed by 1 getHits(). If we only do removal in 
	 * getHits() function, it will be very time consuming. For me, I prefer to do removal in both 
	 * hit() and getHits(), so that the program avoids system lag in this case.
	 */
//	private Queue<Integer> queue;
//	public DesignHitCounter() { 
//		this.queue = new LinkedList<>();
//	}
//	
//    /** Record a hit.
//    @param timestamp - The current timestamp (in seconds granularity). */
//	public void hit(int timestamp) {
//	    while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
//	    	queue.poll();
//	    }
//	    queue.offer(timestamp);
//	}	
//
//    /** Return the number of hits in the past 5 minutes.
//    @param timestamp - The current timestamp (in seconds granularity). */
//	public int getHits(int timestamp) {
//		while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
//			queue.poll();
//		}
//	    return queue.size();
//	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignHitCounter result = new DesignHitCounter();
		result.hit(1);
		result.hit(2);
		result.hit(3);
		result.hit(3);
		System.out.println(result.getHits(4));
		result.hit(300);
		System.out.println(result.getHits(300));
		System.out.println(result.getHits(301));
	}

}
