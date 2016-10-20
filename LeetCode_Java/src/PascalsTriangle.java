import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
		
 * Tags: Arrays		
 * @author wendi
 *
 */
public class PascalsTriangle {

	/**
	 * Brute force: f[i][j] = f[i-1][j-1] + f[i-1][j]
	 * From begin to end in each row.
	 * @param int numRows
	 * @return List<List<Integer>>
	 * Time: O(k * k)
	 * Space: O(1)
	 */
	public List<List<Integer>> pacalsTriangle(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}
		result.add(Arrays.asList(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				}
				else {
					list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			result.add(list);
		}		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangle result = new PascalsTriangle();
		System.out.println(result.pacalsTriangle(5));
	}

}
