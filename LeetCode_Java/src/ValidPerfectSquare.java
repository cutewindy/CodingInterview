/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Returns: True
 * Example 2:
 * Input: 14
 * Returns: False
 * 
 * Tags: BinarySearch, Math
 * @author wendi
 *
 */
public class ValidPerfectSquare {

	/**
	 * Method1: BinarySearch: (Template). If mid*mid=num, then we find the square and return true.
	 * If num/mid<=mid, it means that mid*mid<num, the possible result on the right of mid.
	 * Otherwise, mid*mid>num, the possible result on the left of mid.
	 * @param int num
	 * @return boolean
	 * Time: O(log(num))
	 * Space: O(1)
	 */
	public boolean validPerfectSquare(int num) {
		if (num == 0) {
			return true;
		}
		int start = 1;
		int end = num;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (mid * mid == num) {
				return true;
			}
			else if (num / mid >= mid) { // can not use mid * mid < num, because Integer out of range. Like num = 2147483647
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		if ((start * start == num) || (end * end == num)) {
			return true;
		}
		return false;
	}
	
//	public boolean validPerfectSquareI(int num) {
//		if (num == 0) {
//			return true;
//		}
//		while (num)
//		return false;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPerfectSquare result = new ValidPerfectSquare();
		System.out.println(result.validPerfectSquare(81));		
		System.out.println(result.validPerfectSquare(2147483647));
//		System.out.println(result.validPerfectSquareI(81));
	}

}
