import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a 
 * prime number of set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in 
 * binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 * Example 1:
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 * Example 2:
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 * Note:
 * L, R will be integers L <= R in the range [1, 10^6].
 * R - L will be at most 10000.
 * @author wendi
 *
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {
	
	/**
	 * Bit Manipulation
	 * @param int L, int R
 	 * @return int
 	 * Time: O((R-L)log(R-L)) Time Complexity: O(D), where D = R-L is the number of integers considered. 
 	 * In a bit complexity model, this would be O(Dlog D) as we have to count the bits in O(logD) time.
 	 * Space: O(1)
	 */
	public int primeNumberofSetBitsinBinaryRepresentation(int L, int R) {
		Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
		int result = 0;
		for (int i = L; i <= R; i++) {
			int count = 0;
			int n = i;
			while (n != 0) {
				count += (n & 1);
				n >>= 1;
			}
			if (set.contains(count)) result++;
		}
		return result;
	}
	
	public int[] countBits(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++ ) {
			dp[i] = dp[i >> 1] + (i & 1);
		}
		return dp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumberofSetBitsinBinaryRepresentation result = new PrimeNumberofSetBitsinBinaryRepresentation();
		System.out.println(result.primeNumberofSetBitsinBinaryRepresentation(10, 15));
		System.out.println(Arrays.toString(result.countBits(15)));
	}

}
