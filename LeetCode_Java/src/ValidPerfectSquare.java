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
	 * Method2: Math: A square number is 1+3+5+7+...
	 * This is a math problem：
		1 = 1
		4 = 1 + 3
		9 = 1 + 3 + 5
		16 = 1 + 3 + 5 + 7
		25 = 1 + 3 + 5 + 7 + 9
		36 = 1 + 3 + 5 + 7 + 9 + 11
		....
		so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
	 * @param int num
	 * @return int
	 * Time: O(sqrt(n))
	 * Space:O(1)
	 */
	public boolean validPerfectSquareI(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
	
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPerfectSquare result = new ValidPerfectSquare();
		System.out.println(result.validPerfectSquare(81));		
		System.out.println(result.validPerfectSquare(2147483647));
		System.out.println(result.validPerfectSquareI(81));		
		System.out.println(result.validPerfectSquareI(2147483647));
	}

}
