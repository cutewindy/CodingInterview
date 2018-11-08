import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
 * The bricks have the same height but different width. You want to draw a vertical line from the 
 * top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the 
 * width of each brick in this row from left to right.
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You 
 * need to find out how to draw the line to cross the least bricks and return the number of crossed 
 * bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the 
 * line will obviously cross no bricks.
 * Example:
 * Input: [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
 * Output: 2
 * Explanation: 
 * Note:
 * 1.The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * 2. The number of bricks in each row is in range [1,10,000]. The height of wall is in range 
 * [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 * @author wendi
 *
 */
public class BrickWall {
	
	
	/**
	 * linear sweap + hashMap
	 * 我们使用一个哈希表来建立每一个断点的长度和其出现频率之间的映射，这样只要我们从断点频率出现最多的地方劈墙，损坏的板砖一定最少
	 * @param List<List<Integer>>wall
	 * @return int
	 * Time: O(m*n)
	 * Space: O(n)
	 */
    public int brickWall(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();  // [key, value] = [wall's length from 0, frequency]
        int max = 0;
        for (List<Integer> list: wall) {
        	int len = 0;
        	for (int i = 0; i < list.size() - 1; i++) {  // take care: don't need to count the last one of each row
        		len += list.get(i);
        		if (!map.containsKey(len)) map.put(len, 0);
        		map.put(len, map.get(len) + 1);
        		max = Math.max(map.get(len), max);
        	}
        }
        
        return wall.size() - max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrickWall result = new BrickWall();
		List<List<Integer>> wall = new ArrayList<>();
		List<Integer> w1 = new ArrayList<>(Arrays.asList(1,2,2,1));
		List<Integer> w2 = new ArrayList<>(Arrays.asList(3,1,2));
		List<Integer> w3 = new ArrayList<>(Arrays.asList(1,3,2));
		List<Integer> w4 = new ArrayList<>(Arrays.asList(2,4));
		List<Integer> w5 = new ArrayList<>(Arrays.asList(3,1,2));
		List<Integer> w6 = new ArrayList<>(Arrays.asList(1,3,1,1));
		wall.add(w1);
		wall.add(w2);
		wall.add(w3);
		wall.add(w4);
		wall.add(w5);
		wall.add(w6);
		System.out.println(result.brickWall(wall));
	}

}
