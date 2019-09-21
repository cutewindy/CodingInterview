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
	 * Method1: res += (end - start)
	 * 我们先从一维的情况来分析，那么我们先看一维时有两个点A和B的情况,
	 * ______A_____P_______B_______
	 * 那么我们可以发现，只要开会为位置P在 [A, B] 区间内，不管在哪，距离之和都是A和B之间的距离，如果P不在 [A, B] 之间，
	 * 那么距离之和就会大于A和B之间的距离，那么我们现在再加两个点C和D：
	 * ______C_____A_____P_______B______D______
	 * 我们通过分析可以得出，P点的最佳位置就是在 [A, B] 区间内，这样和四个点的距离之和为AB距离加上 CD 距离，在其他任意一
	 * 点的距离都会大于这个距离，那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一
	 * 个坐标，即 CD 距离，倒数第二个坐标减去第二个坐标，即 AB 距离，以此类推，直到最中间停止，那么一维的情况分析出来了，
	 * 二维的情况就是两个一维相加即可
	 * @param int[][] grid
	 * @return int
	 * Time: O(mn + mlog(m) + nlog(n))
	 * Space: O(m + n)
	 */
	public int bestMeetingPoint(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                rows.add(i);
                cols.add(j);
            }
        }
        return getDistance(rows) + getDistance(cols);
    }
    
    private int getDistance(List<Integer> list) {
        if (list == null || list.size() == 0) return 0;
        int res = 0;
        int l = 0;
        int r = list.size() - 1;
        Collections.sort(list);
        while (l < r) {
            res += list.get(r--) - list.get(l++);
        }
        return res;
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
