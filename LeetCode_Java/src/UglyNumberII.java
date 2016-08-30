import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * Hint:
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers 
 * are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from 
 * three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 * 
 * Tags: DP, heap, Math
 * @author wendi
 *
 */
public class UglyNumberII {

	/**
	 * DP: use the definition of ugly number, the new ugly number always minimum of the old ugly 
	 * number *2, *3 and *5.
	 * Use a list to save the old ugly number, and i2, i3 and i5 as pointers to record the position.
	 * @param int n
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int unlyNumberII(int n) {
		if (n <= 0) {
			return 0;
		}
		List<Integer> ugly = new ArrayList<>();
		ugly.add(1);
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		for (int i = 2; i <= n; i++) {
			while (ugly.get(i2) * 2 <= ugly.get(ugly.size() - 1)) {
				i2++;
			}
			while (ugly.get(i3) * 3 <= ugly.get(ugly.size() - 1)) {
				i3++;
			}
			while (ugly.get(i5) * 5 <= ugly.get(ugly.size() - 1)) {
				i5++;
			}
			int next = Math.min(Math.min(ugly.get(i2) * 2, ugly.get(i3) * 3), ugly.get(i5) * 5);
			ugly.add(next);
		}
		return ugly.get(ugly.size() - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumberII result = new UglyNumberII();
		System.out.println(result.unlyNumberII(11));
	}

}
