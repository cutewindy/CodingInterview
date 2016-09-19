import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class SummaryRanges {

	/**
	 * Brute Force
	 * @param int[] nums
	 * @return List<String> 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		int start = 0;
		int end = 0;
		while (start < nums.length && end < nums.length) {
			while (end < nums.length && (end == start || nums[end] == nums[end - 1] + 1)) {
				end++;
			}
			if (start == end - 1) {
				result.add("" + nums[start]);
			}
			else {
				result.add("" + nums[start] + "->" + nums[end - 1]);
			}
			start = end;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummaryRanges result = new SummaryRanges();
		System.out.println(result.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}));
	}

}
