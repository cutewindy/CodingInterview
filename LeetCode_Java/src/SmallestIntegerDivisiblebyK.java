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
	 *    
	 *    
	 * 如果这K个余数中有一个余数是0，那么当前的N能被K整除直接返回。
如果这K个余数中都不为0时，一定有重复的余数！我们知道一个数对K的余数只能是0 ~ K - 1其中的一个，所以如果K个数字的余数中没有0，那么肯定有重复的余数。如果出现重复的余数，那么后面再增大N时，对K的余数就会形成循环，则再也不可能出现余数为0的情况。
总之，如果遍历到了长度为K的N时仍然不存在余数是0，那么后面就不用搜索了。

举个例子，我们发现长度 <= 6 = K的N的余数是循环的。

1 % 6 = 1
11 % 6 = 5
111 % 6 = 3
1111 % 6 = 1
11111 % 6 = 5
111111 % 6 = 3
严谨的证明应该是如果N2 % K == N1 % K的话，证明(10 * N2 + 1) % K == (10 * N1 + 1) % K.

	 * @param int K
	 * @return int
	 * Time: O(K)
	 * Space: O(1)
	 */
	public int smallestRepunitDivByK(int K) {
        int res = 0;
        int curr = 0;
        while (res < K) {
            curr = (curr * 10 + 1) % K;
            res++;
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
