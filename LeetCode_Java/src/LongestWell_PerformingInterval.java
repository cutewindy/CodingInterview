import java.util.HashMap;
import java.util.Map;

/**
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) 
 * greater than 8.
 * A well-performing interval is an interval of days for which the number of tiring days is strictly 
 * larger than the number of non-tiring days.
 * Return the length of the longest well-performing interval.
 * Example 1:
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 * Constraints:
 * 1. 1 <= hours.length <= 10000
 * 2. 0 <= hours[i] <= 16
 * @author wendi
 *
 */
public class LongestWell_PerformingInterval {
	
	
	/**
	 * Map + prefix sum
	 * 问题可以转化一下，工作饱和标记为1，不饱和标记为-1，问题则是求区间和大于 0 的最长区间。
	 * 这道题显然需要依次求出i为区间结尾时的最优答案，最终答案则是所有答案里面的最大值。
	 * 我们可以分析数据，假设当前位置i的前缀和是sum[i]。
	 * 如果sum[i]>0，那显然整个前缀都是答案。
	 * 如果sum[i]<=0，那我们需要找到一个区间sum[j,i]，使得sum[j,i]>0。
	 * 因为sum[0,j-1] + sum[j,i] = sum[i]，带入到sum[j,i]中，即可得到sum[i] - sum[0,j-1] > 0。
	 * 公式转化一下，即可得到0 >= sum[i] > sum[0,j-1]。
	 * 由此，就可以发现，我们的目标是找到最前面的比sum[i]小的位置，从而就可以计算出i的最优答案。
	 * 
	 * same like leetcode 525. Contiguous Array
	 * @param int[] hours
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int longestWPI(int[] hours) {
        if (hours == null || hours.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            count = hours[i] > 8 ? count + 1 : count - 1;
            if (count > 0) res = i + 1;
            else {
                map.putIfAbsent(count, i);
                if (map.containsKey(count - 1)) {
                    res = Math.max(i - map.get(count - 1), res);
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestWell_PerformingInterval result = new LongestWell_PerformingInterval();
		System.out.println(result.longestWPI(new int[] {6,6,0,9,9,9,9,9,0,6}));
	}

}
