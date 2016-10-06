import java.util.Arrays;
import java.util.Comparator;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair 
 * of integers (h, k), where h is the height of the person and k is the number of people in front of 
 * this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * Note:
 * The number of people is less than 1,100.
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * Tags: Greedy
 * @author wendi
 *
 */
public class QueueReconstructionbyHeight {
	
	/**
	 * Greedy: 
	 * 1. Sort people by h in ascending order, if h are the same, sort people by k in descending order.
	 * 2. Like bucket, reserve the corresponding position(equals to k) for people who's h large than 
	 * or equal current h. 	  
	 * @param int[][] people
	 * @return int[][]
	 * Time: O(nlog(n) + n^2)
	 * Space: O(1)
	 */
	public int[][] queueReconstructionbyHeight(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		int m = people.length;
		int[][] result = new int[m][];  // init result as [null, null, null] if n = 3.
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				else {
					return b[1] - a[1];
				}
			}
		});
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < m; j++) {
				if (result[j] == null && count < people[i][1]) {
					count++;
				}
				else if (result[j] == null && count == people[i][1]){
					result[j] = people[i];
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueReconstructionbyHeight result = new QueueReconstructionbyHeight();
		int[][] array = result.queueReconstructionbyHeight(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
		for (int[] a: array) {
			System.out.println(Arrays.toString(a));
		}
	}

}
