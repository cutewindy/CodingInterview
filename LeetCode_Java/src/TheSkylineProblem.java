import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city 
 * when viewed from a distance. Now suppose you are given the locations and height of all the 
 * buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed 
 * by these buildings collectively (Figure B).
 * Buildings Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, 
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: 
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * The output is a list of "key points" (red dots in Figure B) in the format of 
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left 
 * endpoint of a horizontal line segment. Note that the last key point, where the rightmost building 
 * ends, is merely used to mark the termination of the skyline, and always has zero height. Also, 
 * the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * Notes:
 * 1. The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * 2. The input list is already sorted in ascending order by the left x position Li.
 * 3. The output list must be sorted by the x position.
 * 4. There must be no consecutive horizontal lines of equal height in the output skyline. For 
 *    instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of 
 *    height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * Tags: Binary Indexed Tree, Segment Tree, Heap, Divide and Conquer
 * @author wendi
 *
 */
public class TheSkylineProblem {
	
	/**
	 * PriorityQueue: use a maxHeap to store possible heights
	 * 1. get start point(mark height as negative integer) and end point of one building.
	 * 2. sort the these points by ascending x. If x are the same, sort by ascending y/ -y.
	 * 3. visit all points in order. Offer height into maxHeap and use prev to find whether the 
	 *    height changes in maxHeap. If true, add point to result.
	 * @param int[][] building
	 * @return List<int[]>
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public List<int[]> theSkylineProblem(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return result;
		}
		int[][] height = new int[2 * buildings.length][2];
		int i = 0;
		for (int[] b: buildings) {
			height[i][0] = b[0];
			height[i++][1] = -b[2];  // start point has negative height value
			height[i][0] = b[1];
			height[i++][1] = b[2];   // end point has normal height value
		}
		Arrays.sort(height, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0] ) {
					return a[0] - b[0];
				}
				else 
					return a[1] - b[1];  // be careful
			}
		});
		int prev = 0;  // Provide a initial value to make it more consistent
		Queue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		maxHeap.offer(0);
		for (int[] curr: height) {
			if (curr[1] < 0) {    // a start point, add height
				maxHeap.offer(-curr[1]);
			} 
			else {                // an end point, remove height
				maxHeap.remove(curr[1]);
			}
			int h = maxHeap.peek();
			// compare current max height with previous max height, update result and prev if necessary
			if (h != prev) {
				result.add(new int[] {curr[0], h});
				prev = h;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheSkylineProblem result = new TheSkylineProblem();
		List<int[]> res = result.theSkylineProblem(new int[][] 
				{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
		for (int[] r: res) {
			System.out.println(r[0] + " " + r[1]);
		}
	}

}
