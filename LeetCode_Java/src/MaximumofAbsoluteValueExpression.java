/**
 * Given two arrays of integers with equal lengths, return the maximum value of:
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 * Example 1:
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * Example 2:
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 * Constraints:
 * 1. 2 <= arr1.length == arr2.length <= 40000
 * 2. -10^6 <= arr1[i], arr2[i] <= 10^6
 * @author wendi
 *
 */
public class MaximumofAbsoluteValueExpression {
	
	
	/**
	 * Math
	 * |a-b|可以看成是 Math.max(a-b,b-a)；
		
		先将|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|写成|a1 - b1| + |a2 - b2| + |i - j|， 以方便观看
		
		我们将按索引顺序遍历数组，那么 |i - j|实际就是(i - j)
		
		|a1 - b1| + |a2 - b2| + (i - j)可以写成以下4个算式的最大值：
		
		(a1-b1) + (a2-b2) + (i-j)
		(a1-b1) + (b2-a2) + (i-j)
		(b1-a1) + (a2-b2) + (i-j)
		(b1-a1) + (b2-a2) + (i-j)
		也可以写成:
		
		(+a1+a2+i) - (+b1+b2+j)
		(+a1-a2+i) - (+b1-b2+j)
		(-a1+a2+i) - (-b1+b2+j)
		(-a1-a2+i) - (-b1-b2+j)
		a1,a2 / b1,b2对应的符号分别是
		
		+,+
		+,-
		-,+
		-,-
		因此只需要遍历4中符号，然后取最大值。
	 * @param int[] arr1, int[] arr2
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int maximumofAbsoluteValueExpression(int[] arr1, int[] arr2) {
        int res = 0;
        int[] P = {-1, 1};
        for (int p: P) {
            for (int q: P) {
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < arr1.length; i++) {
                    int curr = p * arr1[i] + q * arr2[i] + i;
                    max = Math.max(curr, max);
                    min = Math.min(curr, min);
                }
                res = Math.max(max - min, res);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumofAbsoluteValueExpression result = new MaximumofAbsoluteValueExpression();
		System.out.println(result.maximumofAbsoluteValueExpression(new int[] {1,-2,-5,0,10}, new int[] {0,-2,-1,-7,-4}));
	}

}
