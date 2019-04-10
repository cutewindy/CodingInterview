/**
 * Given a positive integer K, you need find the smallest positive integer N such that N is 
 * divisible by K, and N only contains the digit 1.
 * Return the length of N.  If there is no such N, return -1.
 * Example 1:
 * Input: 1
 * Output: 1
 * Explanation: The smallest answer is N = 1, which has length 1.
 * Example 2:
 * Input: 2
 * Output: -1
 * Explanation: There is no such positive integer N divisible by 2.
 * Example 3:
 * Input: 3
 * Output: 3
 * Explanation: The smallest answer is N = 111, which has length 3.
 * Note:
 * 1. 1 <= K <= 10^5
 * @author wendi
 *
 */
public class SmallestIntegerDivisiblebyK {
	
	
	/**
	 * For different N, we calculate the remainder of mod K.
	 * It has to use the remainder for these two reason:
	 * 1. Integer overflow
	 * 2. The division operation for big integers, is NOT O(1), it's actually depends on the number 
	 *    of digits..
	 * @param int K
	 * @return int
	 * Time: O(K)
	 * Space: O(1)
	 */
	public int smallestRepunitDivByK(int K) {
        int res = 0;
        int curr = 0;
        while (res < K) {
            res++;
            curr = (curr * 10 + 1) % K;
            if (curr == 0) return res;
        }
        return -1;   
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestIntegerDivisiblebyK result = new SmallestIntegerDivisiblebyK();
		System.out.println(result.smallestRepunitDivByK(71));
	}

}
