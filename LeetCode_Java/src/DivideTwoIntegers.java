/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, 
 * division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit 
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function 
 * returns 231 − 1 when the division result overflows.
 * @author wendi
 *
 */
public class DivideTwoIntegers {
	
	/**
	 * Math + binary search
	 * 1. 基本思想是不断地减掉除数，直到为0为止。但是这样会太慢。
     * 2. 我们可以使用2分法来加速这个过程。不断对除数*2，直到它比被除数还大为止。加倍的同时，也记录下cnt，将被除数减掉加倍
     *    后的值，并且结果+cnt。因为是2倍地加大，所以速度会很快，指数级的速度。
     * 3. 判断正负；越界返回最大值
     *
     * 用被除数除以除数，2*除数，4*除数
     * 1+2+4+。。。加到和为商为止
     * a1*(1-q^n)/(1-q)=a/b
     * a1=1, q=2, a是被除数，b是除数，求n
     * 
	 * @param int dividend, int divisor
	 * @return int
	 * Time: O(log(n)) n = divisor
	 * Space: O(1)
	 */
    public int divideTwoIntegers(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) sign = -1;
        long a = Math.abs((long)dividend);  // 先取long否则Integer.MIN_VALUE越界, eg: Math.abs(-2147483648) = -2147483648
        long b = Math.abs((long)divisor);
        
        long res = 0;
        while (a >= b) {
            long shift = 1;
            long multiB = b;
            while ((multiB << 1) <= a) {
                multiB <<= 1;
                shift <<= 1;
            }
            res += shift;
            a -= multiB;
        }
        
        res *= sign;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return (int)res;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers result = new DivideTwoIntegers();
		System.out.println(result.divideTwoIntegers(10, 3));
		System.out.println(result.divideTwoIntegers(7, -3));
	}

}
