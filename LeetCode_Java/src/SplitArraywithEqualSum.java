import java.util.HashSet;
import java.util.Set;

/**
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies 
 * following conditions:
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 * where we define that subarray (L, R) represents a slice of the original array starting from the 
 * element indexed L to the element indexed R.
 * Example:
 * Input: [1,2,1,2,1,2,1]
 * Output: True
 * Explanation:
 * i = 1, j = 3, k = 5. 
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 * Note:
 * 1. 1 <= n <= 2000.
 * 2. Elements in the given array will be in range [-1,000,000, 1,000,000].
 * @author wendi
 *
 */
public class SplitArraywithEqualSum {
	
	/**
	 * prefixSum
	 * Here j is used for middle cut, i for left cut and k for right cut.
	 * Iterate middle cuts and then find left cuts which divides the first half into two equal 
	 * quarters, store that quarter sums in the hashset. Then find right cuts which divides the 
	 * second half into two equal quarters and check if quarter sum is present in the hashset. If 
	 * yes return true.
	 * @param int[] nums
	 * @return boolean
	 * Time: O(n^2)
	 * Space: O(n)
	 */
    public boolean splitArraywithEqualSum(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (prefixSum[i - 1] != prefixSum[j - 1] - prefixSum[i]) continue;
                set.add(prefixSum[i - 1]);
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (prefixSum[k - 1] - prefixSum[j] == prefixSum[n - 1] - prefixSum[k] &&
                    set.contains(prefixSum[k - 1] - prefixSum[j])) return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArraywithEqualSum result = new SplitArraywithEqualSum();
		System.out.println(result.splitArraywithEqualSum(new int[] {1,2,1,3,0,0,2,2,1,3,3}));
	}

}
