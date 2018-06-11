import java.util.Arrays;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each 
 * element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * Example:
 * Given:
 *     length = 5,
 *     updates = [
 *         [1,  3,  2],
 *         [2,  4,  3],
 *         [0,  2, -2]
 *     ]
 * Output:
 *     [-2, 0, 3, 5, 3]
 * Explanation:
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 * @author wendi
 *
 */
public class RangeAddition {
	
	
	/**
	 * Range caching
	 * @param int length, int[] updates
	 * @return int[]
	 * Time: O(k+n) n=updates.length, n=length
	 * Space: O(1)
	 */
	public int[] rangeAdditionI(int length, int[][] updates) {
        if (length <= 0) return new int[0];
        int[] res = new int[length];
        for (int[] op: updates) {
            res[op[0]] += op[2];
            if (op[1] + 1 < length) res[op[1] + 1] -= op[2];
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
	}
	
	
	
	
	
	
	/**
	 * Brute force
	 * @param int length, int[] updates
	 * @return int[]
	 * Time: O(kn) n=updates.length, n=length
	 * Space: O(1)
	 */
	public int[] rangeAddition(int length, int[][] updates) {
		if (length <= 0) return new int[0];
        int[] res = new int[length];
        for (int[] op: updates) {
            for (int i = op[0]; i <= op[1]; i++) {
                res[i] += op[2];
            }
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeAddition result = new RangeAddition();
		int[][] updates = {{1, 3, 2}, {2, 4, 3},{0, 2, -2}};
		System.out.println(Arrays.toString(result.rangeAddition(5, updates)));
		System.out.println(Arrays.toString(result.rangeAdditionI(5, updates)));
	}

}
