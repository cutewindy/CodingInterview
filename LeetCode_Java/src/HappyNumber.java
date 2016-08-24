import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".

 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly 
 * in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy
 *  numbers.

 * Example: 19 is a happy number
		1^2 + 9^2 = 82
		8^2 + 2^2 = 68
		6^2 + 8^2 = 100
		1^2 + 0^2 + 0^2 = 1
		
 * Tag: HashTable, Math
 * @author wendi
 *
 */
public class HappyNumber {

	
	/**
	 * Method2: Two pointers: fast and slow to determine whether there is a cycle.
	 * @param int n
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean happyNumberI(int n) {
		if (n <= 0) {
			return false;
		}
		int slow = n;
		int fast = n;
		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(digitSquareSum(fast));	
			if (fast == 1) {
				return true;
			}
		} while (slow != fast);
		return false;
	}
		
	private int digitSquareSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		return sum;
	}
	
	
	/**
	 * Method1: HashSet: using HashSet to save the once occurrence sum, if it occur twice, return false, 
	 * otherwise it can be calculated to equal to 1.
	 * @param int n
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean happyNumber(int n) {
		if (n <= 0) {
			return false;
		}
		int sum = 0;
		HashSet<Integer> set = new HashSet<>();
		set.add(n);
		while (sum != 1) {
			sum = 0;
			while (n != 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (set.contains(sum)) {
				return false;
			}
			else {
				set.add(sum);
			}
			n = sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HappyNumber result = new HappyNumber();
		System.out.println(result.happyNumber(19));
		System.out.println(result.happyNumberI(19));
		System.out.println(result.happyNumberI(10));
	}

}
