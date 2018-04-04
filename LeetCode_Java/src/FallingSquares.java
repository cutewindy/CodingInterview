import java.util.ArrayList;
import java.util.List;

/**
 * On an infinite number line (x-axis), we drop given squares in the order they are given.
 * The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point 
 * being positions[i][0] and sidelength positions[i][1].
 * The square is dropped with the bottom edge parallel to the number line, and from a higher height 
 * than all currently landed squares. We wait for each square to stick before dropping the next.
 * The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive 
 * length surface they touch (either the number line or another square). Squares dropped adjacent 
 * to each other will not stick together prematurely.
 * Return a list ans of heights. Each height ans[i] represents the current highest height of any 
 * square we have dropped, after dropping squares represented by positions[0], positions[1], ..., 
 * positions[i].
 * Example 1:
	 * Input: [[1, 2], [2, 3], [6, 1]]
	 * Output: [2, 5, 5]
	 * Explanation:
	 * After the first drop of positions[0] = [1, 2]:
	 * _aa
	 * _aa
	 * -------
	 * The maximum height of any square is 2.
	 * After the second drop of positions[1] = [2, 3]:
	 * __aaa
	 * __aaa
	 * __aaa
	 * _aa__
	 * _aa__
	 * --------------
	 * The maximum height of any square is 5.  
	 * The larger square stays on top of the smaller square despite where its center
	 * of gravity is, because squares are infinitely sticky on their bottom edge.
	 * After the third drop of positions[1] = [6, 1]:
	 * __aaa
	 * __aaa
	 * __aaa
	 * _aa
	 * _aa___a
	 * --------------
	 * The maximum height of any square is still 5.
	 * Thus, we return an answer of [2, 5, 5].
 * Example 2:
 * 	  Input: [[100, 100], [200, 100]]
 * 	  Output: [100, 100]
 * 	  Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to 
 * 	  surfaces.
 * Note:
 * 1. 1 <= positions.length <= 1000.
 * 2. 1 <= positions[i][0] <= 10^8.
 * 3. 1 <= positions[i][1] <= 10^6.
 * @author wendi
 *
 */
public class FallingSquares {
	
	/**
	 * 
	 * Let size[i] be the maximum height of the interval specified by positions[i]. At the end, 
	 * we'll return a running max of size.
	 * For each square positions[i], the maximum height will get higher by the size of the square 
	 * we drop. Then, for any future squares that intersect the interval [left, right] (where 
	 * left = positions[i][0], right = positions[i][0] + positions[i][1] - 1), we'll update the 
	 * maximum height of that interval.
	 * @param int[][] positions
	 * @return List<Integer>
	 * Time: O(n^2)
	 * Space: O(n)
	 */
	public List<Integer> fallingSquares(int[][] positions) {
		List<Integer> result = new ArrayList<>();
		if (positions == null || positions.length == 0 || positions[0].length == 0) return result;
		int[] size = new int[positions.length]; 
		for (int i = 0; i < positions.length; i++) {
			int left1 = positions[i][0];
			int right1 = positions[i][0] + positions[i][1] - 1;
			int size1 = positions[i][1];
			size[i] += size1;
			for (int j = i + 1; j < positions.length; j++) {
				int left2 = positions[j][0];
				int right2 = positions[j][0] + positions[j][1] - 1;
				if (left2 <= right1 && left1 <= right2) {
					size[j] = Math.max(size[i], size[j]);
				}
			}
		}
		int max = 0;
		for (int s: size) {
			max = Math.max(s, max);
			result.add(max);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FallingSquares result = new FallingSquares();
		System.out.println(result.fallingSquares(new int[][] {{1, 2}, {2, 3}, {6, 1}}));
		System.out.println(result.fallingSquares(new int[][] {{100, 100}, {200, 100}}));
		System.out.println(result.fallingSquares(new int[][] {{9, 7}, {1, 9}, {3, 1}}));
	}

}
