import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * 1. The length of the given array won't exceed 1000.
 * 2. The integers in the given array are in the range of [0, 1000].
 * @author wendi
 *
 */
public class ValidTriangleNumber {
	
	
	/**
	 * Approach2: tow points + sliding window
	 * @param int[] nums
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
    public int validTriangleNumberI(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int k = nums.length -1; k > 1; k--) {
            for (int i = 0, j = k - 1; i < j;) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                }
                else i++;
            }
        }
        return res;
    }
    
    
	/**
	 * Approach1:任意两条边之和要大于第三边。那么问题其实就变成了找出所有这样的三个数字，使得任意两个数字之和都大于第三个
	 * 数字。那么可以转变一下，三个数字中如果较小的两个数字之和大于第三个数字，那么任意两个数字之和都大于第三个数字，这很好
	 * 证明，因为第三个数字是最大的，所以它加上任意一个数肯定大于另一个数。 
	 * tow points + binary search
	 * @param int[] nums
	 * @return int
	 * Time: O(n^2*log(n))
	 * Space: O(1)
	 */
    public int validTriangleNumber(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	Arrays.sort(nums);
    	int res = 0;
    	for (int i = 0; i < nums.length - 2; i++) {
    		for (int j = i + 1; j < nums.length -1; j++) {
    			int k = binarySearch(nums, j + 1, nums.length -1, nums[i] + nums[j]);
    			if (k != -1) res += k - j;
    		}
    	}
    	return res;
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (target > nums[mid]) start = mid;
    		else end = mid;
    	}
    	if (target > nums[end]) return end;
    	if (target > nums[start]) return start;
    	return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidTriangleNumber result = new ValidTriangleNumber();
		System.out.println(result.validTriangleNumber(new int[] {2,2,3,4}));
		System.out.println(result.validTriangleNumberI(new int[] {2,2,3,4}));
	}

}
