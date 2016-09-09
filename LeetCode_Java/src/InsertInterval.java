import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
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
//class Interval {
//	int start;
//	int end;
//	Interval() {
//		start = 0;
//		end = 0;
//	}
//	Interval(int s, int e) {
//		start = s;
//		end = e;
//	}
//}

public class InsertInterval {
	class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	Interval initInterval() {
		return new Interval();
	}

	Interval initInterval(int s, int e) {
		return new Interval(s, e);
	}
	
	/**
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
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
		List<Interval> intervals = new ArrayList<>();
		intervals.add(result.initInterval(1, 5));
		Interval newInterval = result.initInterval(6, 8);
		System.out.println(result.insertInterval(intervals, newInterval).get(1).end);
	}

}
