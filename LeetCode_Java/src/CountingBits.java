import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num 
 * calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you 
 * do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount
 *  in c++ or in any other language.
 * Hint:
 * 1 You should make use of what you have produced already.
 * 2 Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * 3 Or does the odd/even status of the number help you in calculating the number of 1s?
 *  
 * Tags: DP, Bit manipulate
 * @author wendi
 *
 */
public class CountingBits {
	
	/**
	 * DP: if i&1 == 1, means that the last bits of i is 1, then dp[i] = dp[i>>1]+1,
	 * otherwise, dp[i] = dp[i>>1].
	 * @param int num
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int[] countingBits (int num) {
		int[] result = new int[num + 1];
		if (num == 0) {
			return result;
		}
		// init
		result[1] = 1;
		// update
		for (int i = 2; i <= num; i++) {
			result[i] = (i & 1) == 1 ? result[i >> 1] + 1 : result[i >> 1];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingBits result = new CountingBits();
		System.out.println(Arrays.toString(result.countingBits(5)));
	}

}
