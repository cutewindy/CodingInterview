
/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is 
 * missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only 
 * constant extra space complexity?
 * 
 * Tags: Array, Math, Bit Manipulation
 * @author wendi
 *
 */
public class MissingNumber {
	
	/**
	 * Method3: swap to nums[i] with nums[nums[i]]
	 * @param int nums
	 * @return int 
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int missingNumberII(int[] nums) {	
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != n && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;		
	}

	/**
	 * Method2: Bit Manipulation
	 * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor 
	 * operations with the same number will eliminate the number and reveal the original number.
	 * In this solution, I apply XOR operation to both the index and value of the array. 
	 * In a complete array with no missing numbers, the index and value should be perfectly 
	 * corresponding( nums[index] = index), so in a missing array, what left finally is the missing 
	 * number.
	 * @param int nums
	 * @return int 
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int missingNumberI(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		xor ^= nums.length;  // take care
		return xor; 
	}	
	
	
	/**
	 * Method1: Sum
	 * @param int nums
	 * @return int 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int sum = (0 + nums.length) * (nums.length + 1) / 2;
		int count = 0;
		for (int num: nums) {
			count += num;
		}
		return sum - count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumber result = new MissingNumber();
		System.out.println(result.missingNumber(new int[] {0, 1, 2, 3, 4, 5, 7, 8}));
		System.out.println(result.missingNumberI(new int[] {0, 1, 2, 3, 4, 5, 7, 8}));
		System.out.println(result.missingNumberII(new int[] {0, 1, 2, 3, 4, 5, 7, 8}));
	}

}
