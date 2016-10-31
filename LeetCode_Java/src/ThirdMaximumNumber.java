/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does 
 * not exist, return the maximum number. The time complexity must be in O(n).
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class ThirdMaximumNumber {
	
	/**
	 * Brute Force: using three variables max1, max2, max3 as max number, second max number and 
	 * third max number. Iterate nums to find the third one.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int thirdMaximumNumber(int[] nums) {
		Integer max1 = null;   // using null instead of Integer.MIN_VALUE;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer num: nums) {
			if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue; 
			if (max1 == null || num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			}
			else if (max2 == null || num > max2) {
				max3 = max2;
				max2 = num;
			}
			else if (max3 == null || num > max3){
				max3 = num;
			}
		}
		return max3 == null ? max1 : max3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdMaximumNumber result = new ThirdMaximumNumber();
		System.out.println(result.thirdMaximumNumber(new int[] {2, 2, 3, 1}));
	}

}
