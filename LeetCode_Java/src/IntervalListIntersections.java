import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted 
 * order.
 * Return the intersection of these two interval lists.
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with 
 * a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either 
 * empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and 
 * [2, 4] is [2, 3].)
 * Example 1:
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 * @author wendi
 *
 */
public class IntervalListIntersections {
	
	
	/**
	 * Merge sort/ Two pointers
	 * @param Interval[] A, Interval[] B
	 * @return Interval[]
	 * Time: O(m + n)
	 * Space: O(m + n)
	 */
	public Interval[] intervalListIntersections(Interval[] A, Interval[] B) {
		List<Interval> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			int lo = Math.max(A[i].start, B[j].start);
			int hi = Math.min(A[i].end, B[j].end);
			if (lo <= hi) list.add(new Interval(lo, hi));
			if (A[i].end < B[j].end) i++;
			else j++;
		}
		return list.toArray(new Interval[list.size()]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalListIntersections result = new IntervalListIntersections();
		Interval[] A = Interval.arraytoIntervalArray(new int[][] {{0,2},{5,10},{13,23},{24,25}});
		Interval[] B = Interval.arraytoIntervalArray(new int[][] {{1,5},{8,12},{15,24},{25,26}});
		Interval.printInterval(result.intervalListIntersections(A, B));
	}

}
