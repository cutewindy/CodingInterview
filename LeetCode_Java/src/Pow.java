/**
 * Implement pow(x, n).
 * 
 * Tags: Binary Search
 * @author wendi
 *
 */
public class Pow {
	
	/**
	 * Method4: Bit manipulation, Iteration
	 * The basic idea is to decompose the exponent into powers of 2, so that you can keep dividing 
	 * the problem in half. For example, lets say
	 * N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
	 * x^9 = x^(2^3) * x^(2^0)
	 * 
	 * We can see that every time we encounter a 1 in the binary representation of N, we need to 
	 * multiply the answer with x^(2^i) where i is the ith bit of the exponent. Thus, we can keep a 
	 * running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer 
	 * when we see a 1.
	 * 
	 * @param double x, int n
	 * @return double
	 * Time: O(log(n))
	 * Space: O(1)
	 * Time space: O(log(n))
	 */
	public double powIII(double x, int n) {
		if (n == 0) return 1.0;
		long N = n;
		if (n < 0) {
			x = 1 / x;
			N = -N;     // take care: cannot use N = -n;  eg: n = -2147483648, -n = -2147483648
		}
		
		double res = 1;
		while (N > 0) {
			if ((N & 1) == 1) res *= x;
			x *= x;
			N >>= 1;
		}
		
		return res;
	}
	
	
	
	/**
	 * Method3: Using the formula (x^n) = (x*x)^(n/2)
	 * @param double x, int n
	 * @return double
	 * Time: O(log(n))
	 * Space: O(1)
	 * Time space: O(log(n))
	 */
	public double powII(double x, int n) {
		if (n == 0) return 1.0;
		long N = (long)n;
		if (n < 0) {
			x = 1 / x;
			N = -N;
		}
		return dfsII(x, N);
	}
	
	private double dfsII(double x, long N) {
		if (N == 0) return 1.0;
		if (N % 2 == 0) return dfsII(x * x, N / 2);
		return x * dfsII(x * x, N / 2);
	}
	

	
	/**
	 * Method2: Divide and conquer Using the formula (x^n)^2 = x^(2*n)
	 * Divide and Conquer: Divide problem pow(x, n) into two subproblem half = pow(x, n / 2).
	 * If n < 0, x = 1 / x, n = -n
	 * If n is even, result = half * half;
	 * If n is old, result = half * half * x;
	 * @param double x, int n
	 * @return double
	 * Time: O(log(n))
	 * Space: O(1)
	 * Time space: O(log(n))
	 */
	public double powI(double x, int n) {
		if (n == 0) return 1.0;
		long N = n;
		if (n < 0) {
			x = 1 / x;
			N = -N;
		}
		
		return helper(x, N);
	}
	
	public double helper(double x, long N) {
		if (N == 0) return 1.0;
		double half = helper(x, N / 2);
		if (N % 2 == 0) return half * half;
		return half * half * x;
	}

	
	/**
	 * Method1: Brute force(Time limit exceed)
	 * Just simulate the process, multiply x for n times.
	 * If n < 0, we can substitute x, n with 1/x, -n to make sure n≥0. This restriction can simplify 
	 * our further discussion.
	 * But we need to take care of the corner cases, especially different range limits for negative 
	 * and positive integers.
	 * @param double x, int n
	 * @return double
	 * Time: O(n)
	 * Space: O(1)
	 */
	public double pow(double x, int n) {
		long N = n;
		if (N == 0) return 1.0;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		double result = 1;
		while (N > 0) {
			result *= x;
			N--;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pow result = new Pow();
		System.out.println(result.pow(2.0, 3));
		System.out.println(result.powI(2.0, -2));
		System.out.println(result.powII(2.0, -2));
		System.out.println(result.powIII(2.0, -2));
	}

}
