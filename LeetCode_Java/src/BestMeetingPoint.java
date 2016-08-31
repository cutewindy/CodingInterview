import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given 
 * a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is 
 * calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
		1 - 0 - 0 - 0 - 1
		|   |   |   |   |
		0 - 0 - 0 - 0 - 0
		|   |   |   |   |
		0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. 
 * So return 6.
 * Hint:
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 * 
 * Tags: Math, Sort
 * @author wendi
 *
 */
public class BestMeetingPoint {

	/**
	 * Method2: Median and res += min(array[start], array[end]) * (end - start)
	 * @param int[][] grid
	 * @return int
	 * Time: O(mn + m + n)
	 * Space: O(m + n)
	 */
	public int bestMeetingPointI(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}	
		int[] I = new int[grid.length];
		int[] J = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					I[i]++;
					J[j]++;
				}
			}
		}
		return getDist(I) + getDist(J);
	}
	
	private int getDist(int[] array) {
		int result = 0;
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			while (start < end && array[start] == 0) start++;
			while (start < end && array[end] == 0) end--;
			int min = Math.min(array[start], array[end]);
			result += min * (end - start);
			array[start] -= min;
			array[end] -= min;
		}
		return result;
	}
	
	
	/**
	 * Method1: Median and res += abs(list - median)
	 * @param int[][] grid
	 * @return int
	 * Time: O(mn + mlog(m) + nlog(n))
	 * Space: O(m + n)
	 */
	public int bestMeetingPoint(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		List<Integer> I = new ArrayList<>();
		List<Integer> J = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					I.add(i);
					J.add(j);
				}
			}
		}
		return getMin(I) + getMin(J);
	}
	
	private int getMin(List<Integer> list) {
		int result = 0;
		Collections.sort(list);
		int median = list.get((list.size() - 1) / 2);
		for (Integer x: list) {
			result += Math.abs(x - median);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestMeetingPoint result = new BestMeetingPoint();
		System.out.println(result.bestMeetingPoint(new int[][] 
				{{1, 0, 0, 0, 0, 1}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 1, 0, 0, 0}}));
		System.out.println(result.bestMeetingPointI(new int[][] 
				{{1, 0, 0, 0, 0, 1}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 1, 0, 0, 0}}));
	}

}
