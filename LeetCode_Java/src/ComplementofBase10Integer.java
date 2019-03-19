/**
 * Every non-negative integer N has a binary representation.  For example, 5 can be represented as 
 * "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no 
 * leading zeroes in any binary representation.
 * The complement of a binary representation is the number in binary you get when changing every 1 
 * to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 
 * integer.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * Note:
 * 1. 0 <= N < 10^9
 * @author wendi
 *
 */
public class ComplementofBase10Integer {
	
	/**
	 * Approach2: bit manipulate
	 * Let's find the first number X that X = 1111....1 >= N
	 * N + bitwiseComplement(N) = 11....11 = X
	 * Then bitwiseComplement(N) = X - N
	 * @param int N
	 * @return int
	 * Time: O(log(N))
	 * Space: O(1)
	 */
	public int complementofBase10IntegerI(int N) {
		int X = 1;
		while (X < N) {
			X = 2 * X + 1;
		}
		return X - N;
		// or return N ^ X;
	}
	
	
	/**
	 * Approach1: brute force
	 * @param int N
	 * @return int
	 * Time: O(32)
	 * Space: O(1)
	 */
	public int complementofBase10Integer(int N) {
		if (N == 0) return 1;
		int res = 0;
		int i = 0;
		while (N != 0) {
			int bit = N % 2;
			res += (bit ^ 1) << i;
			i++;
			N >>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplementofBase10Integer result = new ComplementofBase10Integer();
		System.out.println(result.complementofBase10Integer(5));
		System.out.println(result.complementofBase10IntegerI(5));
	}

}
