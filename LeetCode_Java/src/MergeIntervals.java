import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author wendi
 *
 */
public class MergeIntervals {
	
	/**
	 * sort first and then merge
	 * First, we sort the list as described. Then, we insert the first interval into our merged list 
	 * and continue considering each interval in turn as follows: If the current interval begins 
	 * after the previous interval ends, then they do not overlap and we can append the current 
	 * interval to merged. Otherwise, they do overlap, and we merge them by updating the end of the 
	 * previous interval if it is less than the end of the current interval.
	 * @param List<Interval> intervals
	 * @return List<Interval>
	 * Time: O(nlog(n)) for the sort
	 * Space: O(1)
	 */
	public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        });
        Interval curr = intervals.get(0);
        for (Interval next: intervals) {
            if (next.start <= curr.end) {
                curr.end = Math.max(curr.end, next.end);
            }
            else {
                res.add(curr);
                curr = next;
            }
        }
        res.add(curr);
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals result = new MergeIntervals();
		List<Interval> intervals = Interval.arrayListtoIntervalList(new int[][] {{1, 6}, {2, 5}, {7, 8}, {8, 10}});
		Interval.printIntervalList(result.mergeIntervals(intervals));
	}

}
