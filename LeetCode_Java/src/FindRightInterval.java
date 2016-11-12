import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose 
 * start point is bigger than or equal to the end point of the interval i, which can be called that 
 * j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index, which means that the 
 * interval j has the minimum start point to build the "right" relationship for interval i. If the 
 * interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value 
 * of each interval as an array.
 * Note:
 * 1. You may assume the interval's end point is always bigger than its start point.
 * 2. You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * Output: [-1, 0, 1]
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * Output: [-1, 2, -1]
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class FindRightInterval {
	
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */	
	
	/**
	 * HashMap + Binary Search: 
	 * 1. put interval and the index together in map;
	 * 2. sort intervals accordig to start time;
	 * 3. after sort, use binary seach to find the minimum right interval, don't update result 
	 *    if right interval does not exist.
	 * @param Interval[] intervals
	 * @return int[]
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int[] findRightInterval(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[0];
		}
		int n = intervals.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Map<Interval, Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hash.put(intervals[i], i);
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if (a.start != b.start) {
					return a.start - b.start;
				}
				return a.end - b.end;
			}
		});
		for (Interval curr: intervals) {
			int left = 0;
			int right = n - 1;
			int i = hash.get(curr);
			while (left + 1 < right) {
				int mid = left + (right - left) / 2;
				if (intervals[mid].start == curr.end) {
					result[i] = hash.get(intervals[mid]);
					break;
				}
				else if (intervals[mid].start < curr.end) {
					left = mid;
				}
				else {
					right = mid;
				}
			}
			if (result[i] == -1 && intervals[left].start >= curr.end) {
				result[hash.get(curr)] = hash.get(intervals[left]);
			}
			if (result[i] == -1 && intervals[right].start >= curr.end) {
				result[hash.get(curr)] = hash.get(intervals[right]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindRightInterval result = new FindRightInterval();
		System.out.println(Arrays.toString(result.findRightInterval(new Interval[] 
				{new Interval(1, 4), new Interval(3, 4), new Interval(2, 3)})));
	}

}
