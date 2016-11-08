/**
 * Implement pow(x, n).
 * 
 * Tags: Binary Search
 * @author wendi
 *
 */
public class Pow {
	
	/**
	 * Divide and Conquer: Divide problem pow(x, n) into two subproblem temp = pow(x, n / 2).
	 * If n is even, result = temp * temp;
	 * If n is old and n > 0, result = temp * temp * x;
	 * If n is old and n < 0, result = temp * temp * 1 / x; 
	 * @param double x, int n
	 * @return double
	 * Time: O(log(n))
	 * Space: O(1)
	 * Time space: O(log(n))
	 */
	public double pow(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		return helper(x, n);
	}
	
	public double helper(double x, int n) {
		if (n == 0) return 1;
		double temp = helper(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		}
		if (n > 0) {
			return temp * temp * x;
		}
		return temp * temp / x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow result = new Pow();
		System.out.println(result.pow(2.0, 3));
		System.out.println(result.pow(2.0, -2));
	}

}
