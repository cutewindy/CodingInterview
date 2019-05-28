import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to 
 * split them into several subsequences, where each subsequences consist of at least 3 consecutive 
 * integers. Return whether you can make such a split.
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3
 * 3, 4, 5
 * Example 2:
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 *  * Input: [1,2,3,4,4,5]
 * Output: False
 * Note:
 * 1. The length of the input is in range of [1, 10000]
 * @author wendi
 *
 */
public class SplitArrayintoConsecutiveSubsequences {
	
	/**
	 * Greedy + hashmap
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
    public boolean splitArrayintoConsecutiveSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num: nums) {
        	counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> tails = new HashMap<>();
        for (int num: nums) {
        	if (counts.get(num) == 0) continue;
        	counts.put(num, counts.get(num) - 1);
        	if (tails.getOrDefault(num - 1, 0) > 0) {
        		tails.put(num - 1, tails.get(num - 1) - 1);
        		tails.put(num, tails.getOrDefault(num, 0) + 1);
        	}
        	else if (counts.getOrDefault(num + 1, 0) > 0 && counts.getOrDefault(num + 2, 0) > 0) {
        		counts.put(num + 1, counts.get(num + 1) - 1);
        		counts.put(num + 2, counts.get(num + 2) - 1);
        		tails.put(num + 2, tails.getOrDefault(num + 2, 0) + 1);
        	}
        	else return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArrayintoConsecutiveSubsequences result = new SplitArrayintoConsecutiveSubsequences();
		System.out.println(result.splitArrayintoConsecutiveSubsequences(new int[] {1,2,3,3,4,4,5,5}));
	}

}
