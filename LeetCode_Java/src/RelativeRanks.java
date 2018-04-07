import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest 
 * scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Example 1: 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", 
 * "Silver Medal" and "Bronze Medal". 
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * 1. N is a positive integer and won't exceed 10,000.
 * 2. All the scores of athletes are guaranteed to be unique.
 * @author wendi
 *
 */
public class RelativeRanks {
	
	
	/**
	 * HashMap (or int array) + Arrays.sort
	 * @param int[] nums
	 * @return String[]
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public String[] relativeRanks(int[] nums) {
		if (nums == null || nums.length == 0) return new String[0];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Arrays.sort(nums);
		int n = nums.length;
		String[] result = new String[n];
		for (int i = 0; i < n; i++) {
			if (i == n - 1) result[map.get(nums[i])] = "Gold Medal";
			else if (i == n - 2) result[map.get(nums[i])] = "Silver Medal";
			else if (i == n - 3) result[map.get(nums[i])] = "Bronze Medal";
			else result[map.get(nums[i])] = String.valueOf(n - i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RelativeRanks result = new RelativeRanks();
		System.out.println(Arrays.toString(result.relativeRanks(new int[] {5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(result.relativeRanks(new int[] {10,3,8,9,4})));
	}

}
