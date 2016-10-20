import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * Tags: Array
 * @author wendi
 *
 */
public class PascalsTriangleII {
	
	/**
	 * Method2: Based on rules: row k of Pascal's Triangle:[C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]
	 * C[k,i] = C[k,i-1]*(k-i+1)/i
	 * @param int rowIndex
	 * @return List<Integer>
	 * Time: O(k)
	 * Space: O(1)
	 */
	public List<Integer> pascalsTriangleIII(int rowIndex) {
		if (rowIndex == 0) {
			return new ArrayList<>(Arrays.asList(1));
		}
		Integer[] result = new Integer[rowIndex + 1];
		result[0] = 1;
		for (int i = 1; i <= rowIndex; i++){
			result[i] = (int)((long)result[i - 1] * (rowIndex - i + 1) / i);  // be carefull about out of range
		}
		List<Integer> res = new ArrayList<>(Arrays.asList(result));
		return res;
	}	

	
	/**
	 * Method1: r[i] = r[i] + r[i-1]. Do add from end to start
	 * @param int rowIndex
	 * @return List<Integer>
	 * Time: O(k*k)
	 * Space: O(k)
	 */
	public List<Integer> pascalsTriangleII(int rowIndex) {
		if (rowIndex == 0) {
			return new ArrayList<>(Arrays.asList(1));
		}
		Integer[] result = new Integer[rowIndex + 1];
		Arrays.fill(result, 1);
		for (int i = 0; i <= rowIndex; i++){
			for (int j = i - 1; j > 0; j--) {
				result[j] += result[j - 1];
			}
		}
		List<Integer> res = new ArrayList<>(Arrays.asList(result));
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangleII result = new PascalsTriangleII();
		System.out.println(result.pascalsTriangleII(4));
		System.out.println(result.pascalsTriangleIII(4));
	}

}
