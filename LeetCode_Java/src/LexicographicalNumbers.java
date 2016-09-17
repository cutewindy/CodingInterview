import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * 
 * Tags: 
 * @author wendi
 *
 */
public class LexicographicalNumbers {
	
	/**
	 * DFS
	 * @param int n
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(number of digits)
	 */
	public List<Integer> lexicographicalNumbers(int n) {
		List<Integer> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		for (int curr = 1; curr <= 9; curr++) {
			helper(n, curr, result);
		}
		return result;
	}
	
	private void helper(int n, int curr, List<Integer> result) {
		if (curr > n) return;
		result.add(curr);
		for (int i = 0; i <= 9; i++) {		
			helper(n, curr * 10 + i, result);
		}
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LexicographicalNumbers result = new LexicographicalNumbers();
		System.out.println(result.lexicographicalNumbers(13));
	}

}
