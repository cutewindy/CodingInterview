import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers 
 * from two different arrays (each array picks one) and calculate the distance. We define the 
 * distance between two integers a and b to be their absolute difference |a-b|. Your task is to find 
 * the maximum distance.
 * Example 1:
 * Input: 
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * Output: 4
 * Explanation: 
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in 
 * the second array.
 * Note:
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 * @author wendi
 *
 */
public class MaximumDistanceinArrays {
	
	
	/**
	 * Single scan
	 * @param List<List<Integer>> arrays
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int maximumDistanceinArrays(List<List<Integer>> arrays) {
		int res = 0;
		List<Integer> l1 = arrays.get(0);
		int min = l1.get(0);
		int max = l1.get(l1.size() - 1);
		for (int i = 1; i < arrays.size(); i++) {
			List<Integer> l = arrays.get(i);
			res = Math.max(Math.max(Math.abs(l.get(0) - max), Math.abs(l.get(l.size() - 1) - min)), res);
			min = Math.min(l.get(0), min);
			max = Math.max(l.get(l.size() - 1), max);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumDistanceinArrays result = new MaximumDistanceinArrays();
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(result.maximumDistanceinArrays(new ArrayList<List<Integer>>(Arrays.asList(l1, l2, l3))));
	}

}
