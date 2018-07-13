import java.util.Arrays;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum 
 * number of length k <= m + n from digits of the two. The relative order of the digits from the 
 * same array must be preserved. Return an array of the k digits.
 * Note: You should try to optimize your time and space complexity.
 * Example 1:
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 * @author wendi
 *
 */
public class CreateMaximumNumber {
	
	
	/**
	 * DP:
	 * res(nums1,nums2,k) = max(merge(maxNumber(nums1,k1), maxNumber(nums2, 2)))
	 * solve 2 simpler problem:
	 * 1. Create the max number of one array within k length.
	 * 2. Merge two max number arrays to one max number array.
	 * @param int[] nums1, int[] nums2, int k
	 * @return int[]
	 * Time: O(k(n1+n2)^3)
	 * Space: O(n1+n2)
	 */
	public int[] createMaximumNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int k1 = 0; k1 <= k; k1++) {
        	int k2 = k - k1;
        	if (k1 > n1 || k2 > n2) continue;
        	int[] curr = merge(maxNumber(nums1, k1), maxNumber(nums2, k2));
        	if (greater(curr, 0, res, 0)) res = curr;
        }
        return res;
    }
	
	// 2. Merge two max number arrays to one max number array: 
	// T: Greedy: (O(n1+n2)^2)
	private int[] merge(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) return nums2;
		if (nums2 == null || nums2.length == 0) return nums1;
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[] res = new int[n1 + n2];
		for (int i = 0, i1 = 0, i2 = 0; i < n1 + n2; i++) {
			res[i] = greater(nums1, i1, nums2, i2) ? nums1[i1++] : nums2[i2++];
		}
		return res;
	}
	
	private boolean greater(int[] nums1, int i1, int[] nums2, int i2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		while (i1 < n1 && i2 < n2 && nums1[i1] == nums2[i2]) {
			i1++;
			i2++;
		}
		return i2 == n2 || (i1 < n1 && nums1[i1] > nums2[i2]);
	}
	
	// 1. Create the max number of one array within k length: 
	// Greedy: T:O(n)
	private int[] maxNumber(int[] nums, int k) {
		if (k == 0) return new int[0];
		if (k == nums.length) return nums;
		int n = nums.length;
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i < n; i++) {
			while (index > 0 && res[index - 1] < nums[i] && n - i > k - index) {
				index--;
			}
			if (index < k) res[index++] = nums[i];
		}		
		return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateMaximumNumber result = new CreateMaximumNumber();
		System.out.println(Arrays.toString(result.createMaximumNumber(new int[] {3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3}, 5)));
	}

}
