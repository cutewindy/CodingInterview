package Linkedin;
/**
 * 
 * @author wendi
 *
 */
public class SubarraySum {
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int subarraySum(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res= 0;
		int n = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res += (i + 1) * (n - i) * nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarraySum result = new SubarraySum();
		System.out.println(result.subarraySum(new int[] {1, 2, 3}));
	}

}
