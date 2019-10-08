import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make 
 * the rest of the intervals non-overlapping.
 * Example 1:
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * Note:
 * 1. You may assume the interval's end point is always bigger than its start point.
 * 2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * @author wendi
 *
 */
public class Non_overlappingIntervals {
	
	
	
	/**
	 * 首先要给区间排序，根据每个区间的 start 来做升序排序，然后开始要查找重叠区间，判断方法是看如果前一个区间的 end 大于
	 * 后一个区间的 start，那么一定是重复区间，此时结果 res 自增1，我们需要删除一个，那么此时究竟该删哪一个呢，为了保证总
	 * 体去掉的区间数最小，我们去掉那个 end 值较大的区间，而在代码中，我们并没有真正的删掉某一个区间，而是用一个变量 last 
	 * 指向上一个需要比较的区间，我们将 last 指向 end 值较小的那个区间；如果两个区间没有重叠，那么此时 last 指向当前区间，
	 * 继续进行下一次遍历，
	 * @param int[][] intervals
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int non_overlappingIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int res = 0;
        int last = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		if (a[0] == b[0]) return a[1] - b[1];
        		return a[0] - b[0];
        	}
        });
        for (int i = 1; i < intervals.length; i++) {
        	if (intervals[i][0] < intervals[last][1]) {
        		res++;
        		if (intervals[i][1] < intervals[last][1]) last = i;
        	}
        	else last = i;
        }
        return res;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Non_overlappingIntervals result = new Non_overlappingIntervals();
		System.out.println(result.non_overlappingIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
	}

}
