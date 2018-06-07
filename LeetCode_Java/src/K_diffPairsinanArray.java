import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs 
 * in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both 
 * numbers in the array and their absolute difference is k.
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 * @author wendi
 *
 */
public class K_diffPairsinanArray {
	
	
	/**
	 * Method2: HashMap
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int k_diffPairsinanArrayI(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (Integer num: map.keySet()) {
        	if (k == 0 && map.get(num) > 1) res++;
        	if (k != 0 && map.containsKey(num + k)) res++;
        }
        return res;
	}
	
	
	
	/**
	 * Method1: Sort Array
	 * @param int[] nums, int k
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int k_diffPairsinanArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[j] - nums[i] == k) {
                    res++;
                    break;
                }
                if (nums[j] - nums[i] > k) break;
            }
        }
        return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_diffPairsinanArray result = new K_diffPairsinanArray();
		System.out.println(result.k_diffPairsinanArray(new int[] {3, 1, 4, 1, 5}, 2));
		System.out.println(result.k_diffPairsinanArrayI(new int[] {3, 1, 4, 1, 5}, 2));
	}

}
