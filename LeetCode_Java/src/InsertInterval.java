import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if 
 * necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Tags: Array, Sort
 * @author wendi
 *
 */

public class InsertInterval {
	
	/**
	 * One pass
	 * @param List<Interval> intervals, Interval newInterval
	 * @return List<Interval>
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<Interval> insertIntervalI(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval i: intervals) {
        	if (newInterval == null || i.end < newInterval.start) result.add(i);
        	else if (i.start > newInterval.end) {
        		result.add(newInterval);
        		result.add(i);
        		newInterval = null;
        	}
        	else {
        		newInterval.start = Math.min(i.start, newInterval.start);
        		newInterval.end = Math.max(i.end, newInterval.end);
        	}
        }
        if (newInterval != null) result.add(newInterval);
        return result;
	}
	
	
	/**
	 * Two pass, can be optimized to one pass, or using binary search as the follow up of "merge interval"
	 * Brute Force: Using a value pos to record the position where to insert the newInterval.
	 * Check whether curr Interval can merge into newInterval:
	 * 1. if i.s > n.e, res.add(i) and pos++;
	 * 2. else if n.e < i.s, res.add(i);
	 * 3. else merge i and n.
	 * Then, add newInterval into res according to pos.
	 * @param List<Interval> intervals, Interval newInterval
	 * @return List<Interval>
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int pos = 0;
        for (Interval interval: intervals) {
        	if (interval.end < newInterval.start) {
        		result.add(interval);
        		pos++;
        	}
        	else if (interval.start > newInterval.end) {
        		result.add(interval);
        	}
        	else {
        		newInterval.start = Math.min(interval.start, newInterval.start);
        		newInterval.end = Math.max(interval.end, newInterval.end);
        	}
        }
        result.add(pos, newInterval);
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval result = new InsertInterval();
		List<Interval> intervals = Interval.arrayListtoIntervalList(new int[][] {{1, 3}, {6, 9}});
		Interval newInterval = new Interval(2, 5);
		Interval.printIntervalList(result.insertInterval(intervals, newInterval));
		Interval.printIntervalList(result.insertIntervalI(intervals, newInterval));
	}
}
