/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large 
 * positive integer given in the form of an array.
 * Example1:
 * a = 2
 * b = [3]
 * Result: 8
 * Example2:
 * a = 2
 * b = [1,0]
 * Result: 1024
 * 
 * Tags: Math
 * @author wendi
 *
 */
public class SuperPow {
	
	/**
	 * Math
	 * @param int a, int[] b
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	int base = 1337;
	public int superPow(int a, int[] b) { 
		if (b == null || b.length == 0) {
			return a % base;
		}
		return helper(a, b, b.length - 1);
	}
	
	private int helper(int a, int[] b, int pos) {
		if (pos == -1) {
			return 1;
		}
		return (mode(helper(a, b, pos - 1), 10) * mode(a, b[pos])) % base;
	}
	
	private int mode(int a, int b) {
		if (b == 0) {
			return 1;
		}
		return (mode(a, b - 1) * (a % base)) % base;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperPow result = new SuperPow();
		System.out.println(result.superPow(2, new int[] {1, 0}));
		System.out.println(result.superPow(2147483647, new int[] {2, 0, 0}));
	}

}
