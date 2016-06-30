import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 *  adjacent numbers on the row below.
		For example, given the following triangle
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total 
 * number of rows in the triangle.
 * 
 * Tags: Array, DP
 * @author wendi
 *
 */
public class Triangle {
	
	/**
	 * DP: use triangle[i][j] to record the minimum path sum to point [i][j].
	 * triangle[i][j] can only come from triangle[i-1][j-1] or triangle[i-1][j], be ware of edge condition.
	 * triangle[i][0] = triangle[i-1][0] + triangle[i][0];
	 * triangle[i][i] = triangle[i-1][i-1] + triangle[i][i];
	 * triangle[i][j] = min(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
	 * @param List<List<Integer>> triangle
	 * @return int
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public int triangle(List<List<Integer>> triangle) {
		
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int result = Integer.MAX_VALUE;
        //init
        for (int i = 1; i < m; i++) {
            triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            triangle.get(i).set(i, triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i));
        }
        // update dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(
                    j, Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + triangle.get(i).get(j)
                    );
            }
        }
        for (int j = 0; j < n; j++) {
            result = Math.min(triangle.get(m - 1).get(j), result);
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle result = new Triangle();
		List<List<Integer>> triangle = new ArrayList();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(triangle);
		System.out.println(result.triangle(triangle));
	}

}
