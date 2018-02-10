import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, 
 * including the bounds if possible.
 * Example 1:
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 * 
 * @author wendi
 *
 */
public class SelfDividingNumbers {
	
	/**
	 *Traverse each integer sequence from left to right incrementing by one (left, left + 1, 
	 *left + 2,…, left + n, right). Each time check if the the current number i is self-divided.
	 * Self-division check is done by using ‘%’ operator(we check each digit moving from right 
	 * to left)
	 * @param int left, int right
	 * @return List<Integer>
	 * Time: O(nm), where n = right - left, and m is number of digits in iterated number
	 * Space: O(1)
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		if (left > right) {
			return result;
		}
		for (int num = left; num <= right; num++) {
			if (isDividingNumber(num)) {
				result.add(num);
			}
		}
		
		return result;
	} 
	
	public boolean isDividingNumber(int num) {
		if (num == 0) {return false;}
		int i = num;
		while (i > 0) {
			int digit = i % 10;
			if (digit == 0 || num % digit != 0) {
				return false;
			}
			i /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfDividingNumbers result = new SelfDividingNumbers();
		System.out.println(result.selfDividingNumbers(1, 22));
	}

}
