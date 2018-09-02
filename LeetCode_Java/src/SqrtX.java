/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * Tags: Binary Search, Math
 * @author wendi
 *
 */
public class SqrtX {
	
	/**
	 * Binary Search
	 * @param int x
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int sqrtX(int x) {
		if (x <= 0) return 0;
        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid == x) return mid;
            else if ((long) mid * mid < x) start = mid;
            else end = mid;
        }
        if ((long) end * end <= x) return end;
        return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqrtX result = new SqrtX();
		System.out.println(result.sqrtX(2147395599));
	}

}
