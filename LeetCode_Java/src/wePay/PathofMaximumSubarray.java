package wePay;

import java.util.ArrayList;
import java.util.List;

/**
 * maximum subarray, follow up 是怎么找路径
 * @author wendi
 *
 */
public class PathofMaximumSubarray {

	/**
	 * 
	 * @param int[] nums
	 * @return List<Integer>
	 * Time: O()
	 * Space: O()
	 */
	public List<Integer> pathofMaximumSubarray(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		int n = nums.length;
		int[] maxSum = new int[n];
		int[] startIndex = new int[n];
		maxSum[0] = nums[0];
		startIndex[0] = 0;
		int resIndex = 0;
		for (int i = 1; i < n; i++) {
			if (maxSum[i - 1] + nums[i] > nums[i]) {
				maxSum[i] = maxSum[i - 1] + nums[i];
				startIndex[i] = startIndex[i - 1];
			}
			else {
				maxSum[i] = nums[i];
				startIndex[i] = i;
			}
			if (maxSum[i] > maxSum[resIndex]) {
				resIndex = i;
			}
		}
		
		// get res
		for (int i = startIndex[resIndex]; i <= resIndex; i++) {
			res.add(nums[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathofMaximumSubarray result = new PathofMaximumSubarray();
		System.out.println(result.pathofMaximumSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
