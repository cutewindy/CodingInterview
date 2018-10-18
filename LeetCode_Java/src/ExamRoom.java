import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * When a student enters the room, they must sit in the seat that maximizes the distance to the 
 * closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  
 * (Also, if no one is in the room, then the student sits at seat number 0.)
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int 
 * representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student 
 * in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have 
 * a student sitting in seat p.
 * Example 1:
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 * ​​Note:
 * 1. 1 <= N <= 10^9
 * 2. ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * 3. Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 * @author wendi
 *
 */
public class ExamRoom {
	
	/**
	 * Approach3: TreeMap
	 * 
	 * Need to measure the distance between seated students: O(n) is trivial, but not as fast. Use 
	 * PriorityQueue to store the potential candidate as interval, and also calculate the candidate's 
	 * mid-distance to both side.
	 * seat(): pq.poll() to find interval of largest distance. Split and add new intervals back to queue.
	 * leave(x): one seat will be in 2 intervals: remove both from pq, and merge to a new interval.
	 * 
	 * Trick: there is no interval when adding for first student, so we need to create boundary/fake 
	 * seats [-1, N], which simplifies the edge case a lot.
	 */	
//	final int finalN;
//	TreeMap<Integer, Integer> treeMap; // [key, value] = [start, end]
//    public ExamRoom(int N) {
//    	this.finalN = N;
//    	treeMap = new TreeMap<>(new Comparator<Integer>() {
//    		@Override
//    		public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
//    			return 0;
//    		}
//    	});
//    }
//    
//    public int seat() {
//    
//    }
//    
//    public void leave(int p) {
//    	
//    }
	
	/**
	 * Approach2: PriorityQueue
	 * 
	 * Need to measure the distance between seated students: O(n) is trivial, but not as fast. Use 
	 * PriorityQueue to store the potential candidate as interval, and also calculate the candidate's 
	 * mid-distance to both side.
	 * seat(): pq.poll() to find interval of largest distance. Split and add new intervals back to queue.
	 * leave(x): one seat will be in 2 intervals: remove both from pq, and merge to a new interval.
	 * 
	 * Trick: there is no interval when adding for first student, so we need to create boundary/fake 
	 * seats [-1, N], which simplifies the edge case a lot.
	 * 
	 * seat(): T: O(log(n))
	 * 
	 * leave(p): T: O(n)
	 */	
	final int finalN;
	PriorityQueue<int[]> maxHeap;
    public ExamRoom(int N) {
    	this.finalN = N;
    	this.maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a, int[] b) {
    			int dA = a[0] == -1 ? a[1] :
                         a[1] == finalN ? finalN - 1 - a[0] : (a[1] - a[0]) / 2;
                int dB = b[0] == -1 ? b[1] : 
                         b[1] == finalN ? finalN - 1 - b[0] : (b[1] - b[0]) / 2;
    			if (dB != dA) return dB - dA;
    			return a[0] - b[0];
    		}
    	});
    	this.maxHeap.offer(new int[] {-1, N});
    }
	
    public int seat() {
        int[] maxGap = maxHeap.poll();
        int seat = 0;
        if (maxGap[0] == -1) seat = 0;
        else if (maxGap[1] == finalN) seat = finalN - 1;
        else seat = maxGap[0] + (maxGap[1] - maxGap[0]) / 2;
        
        maxHeap.offer(new int[] {maxGap[0], seat});
        maxHeap.offer(new int[] {seat, maxGap[1]});
        
        return seat;
    }
    
    public void leave(int p) {
        int[] prev = null;
        int[] next = null;
        Iterator<int[]> it = maxHeap.iterator();
        while (it.hasNext()) {
        	int[] curr = it.next();
        	if (curr[1] == p) prev = curr;
        	if (curr[0] == p) next = curr;
        	if (prev != null && next != null) break;
        }
        
        maxHeap.remove(prev);
        maxHeap.remove(next);
        maxHeap.offer(new int[] {prev[0], next[1]});
    }
	
	/**
	 * Approach1: List
	 * Use a list L to record the index of seats where people sit.
	 * 
	 * seat(): T: O(n)
	 * 1. find the biggest distance at the start, at the end and in the middle.
	 * 2. insert index of seat
	 * 3. return index
	 * 
	 * leave(p): T: O(n)
	 * for loop to find p, then pop it.
	 */
//	int N;
//	List<Integer> list;
//    public ExamRoom(int N) {
//        this.N = N;
//        this.list = new ArrayList<>();
//    }
//    
//    public int seat() {
//        if (list.size() == 0) {
//        	list.add(0);
//        	return 0;
//        }
//        if (list.size() == 1) {
//        	if (N - 1 - list.get(0) > list.get(0)) {
//        		list.add(N - 1);
//        		return N - 1;
//        	}
//        	else {
//        		list.add(0, 0);
//        		return 0;
//        	}
//        }
//        
//        int d = (list.get(0) + 1) / 2;
//        int index = 0;
//        int seat = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int a = list.get(i);
//            int b = i + 1 == list.size() ? N : list.get(i + 1);
//        	if ((b - a) / 2 > d) {
//        		d = (b - a) / 2;
//        		index = i + 1;
//        		seat = d + a;
//        	}
//        }
//        list.add(index, seat);
//        return seat;
//    }
//    
//    public void leave(int p) {
//        for (int i = 0; i < list.size(); i++) {
//        	if (list.get(i) == p) list.remove(i);
//        }  
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExamRoom result = new ExamRoom(10);
		System.out.println(result.seat());
		System.out.println(result.seat());
		System.out.println(result.seat());
		System.out.println(result.seat());
		result.leave(4);
		System.out.println(result.seat());
	}

}
