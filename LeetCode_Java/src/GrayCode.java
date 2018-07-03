import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the 
 * sequence of gray code. A gray code sequence must begin with 0. 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * Tags: Backtracking
 * @author wendi
 *
 */
public class GrayCode {

	/**
	 * generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
	 * 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at 
	 * their highest bit, while the rest numbers of part two are exactly symmetric of part one.
	 * @param int n
	 * @return List<Integer>
	 * Time: O(2^n)
	 * Space: O(1)
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		if (n == 0) {
			return result;
		}
		for (int bit = 0; bit < n; bit++) {
			int size = result.size();
			for (int i = size - 1; i >= 0; i--) {
				result.add((1 << bit) + result.get(i));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode result = new GrayCode();
		System.out.println(result.grayCode(3));
	}

}
