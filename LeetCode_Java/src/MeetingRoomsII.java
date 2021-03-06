import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * 
 * Tags: Heap, Greedy, Sort
 * @author wendi
 *
 */
public class MeetingRoomsII {
	
	/**
	 * Method4:Linear sweep + TreeMap
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(2nlog(n))
	 * Space: O(2n)
	 */
	public int meetingRoomsIIIII(Interval[] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (Interval interval: intervals) {
        	if (!treeMap.containsKey(interval.start)) treeMap.put(interval.start, 0);
        	if (!treeMap.containsKey(interval.end)) treeMap.put(interval.end, 0);
        	treeMap.put(interval.start, treeMap.get(interval.start) + 1);
        	treeMap.put(interval.end, treeMap.get(interval.end) - 1);
        }
        int res = 0;
        int currRes = 0;
        for (Integer value: treeMap.values()) {
        	currRes += value;
        	res = Math.max(currRes, res);
        }
        return res;
	}

	/**
	 * Method3:Linear sweep
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(2nlog(n))
	 * Space: O(2n)
	 */
	public int meetingRoomsIIII(Interval[] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int currRes = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                currRes++;
                res = Math.max(currRes, res);
                i++;
            }
            else {
                currRes--;
                j++;
            }
        }
        return res;
	}
	
	/**
	 * Method2: Sort + heap
	 * The priority queue will always be the minimum number of rooms required so far. If the next 
	 * meeting occurs after the next meeting's end time, then replace that meeting with the current 
	 * meeting. If the next meeting occurs before the next meeting's end time, then throw it on the 
	 * queue. When the loop is finished the priority queue represents the numbers of rooms 
	 * booked/rebooked across all meetings.
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(nlog(n) + nlog(n))
	 * Space: O(n)
	 */
	public int meetingRoomsIII(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// 1 sort intervals using Comparator<>()
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				if (a.start != b.start) return a.start - b.start;
				return a.end - b.end;
			}
		});
		// 2 use heap to record the sorted end time of each room, and then compare new inte.start 
		// with the heap.peek() to check whether it's an empty room. If it's not, no empty room 
		// right now, otherwise, poll the old inte from heap.
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (Interval inte: intervals) {
			if (!minHeap.isEmpty() && inte.start >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.offer(inte.end);
		}		
		return minHeap.size();
	}
	
	/**
	 * Method1: Sort + list
	 * @param Interval[] intervals
	 * @return int
	 * Time: O(nlog(n) + n^2)
	 * Space: O(n)
	 */
	public int meetingRoomsII(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// 1 sort intervals using Comparator<>()
		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		// 2 use list to record the end time of a room, and compare new interval.start one by one 
		// to check whether there is an empty room
		List<Integer> endTime = new ArrayList<>();
		for (Interval inte: intervals) {
			if (endTime.isEmpty()) {
				endTime.add(inte.end);
				continue;
			}
			boolean can = false;
			for (int i = 0; i < endTime.size(); i++) {
				if (inte.start >= endTime.get(i)) {
					endTime.set(i, inte.end);
					can = true;
					break;
				}
			}
			if (!can) {
				endTime.add(inte.end);
			}
		}
		return endTime.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRoomsII result = new MeetingRoomsII();
		System.out.println(result.meetingRoomsII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
		System.out.println(result.meetingRoomsIII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
		System.out.println(result.meetingRoomsIIII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
		System.out.println(result.meetingRoomsIIIII(new Interval[] {new Interval(5, 10), new Interval(0, 5), new Interval(8, 9)}));
	}

}
