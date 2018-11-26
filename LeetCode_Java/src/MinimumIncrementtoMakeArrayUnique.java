import java.util.Arrays;

/**
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * Return the least number of moves to make every value in A unique.
 * Example 1:
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * Example 2:
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * Note:
 * 1. 0 <= A.length <= 40000
 * 2. 0 <= A[i] < 40000
 * @author wendi
 *
 */
public class MinimumIncrementtoMakeArrayUnique {
	
	/**
	 * Approach2: 
	 * Count the values. For each possible value x:
	 * If there are 2 or more values x in A, save the extra duplicated values to increment later.
	 * If there are 0 values x in A, then a saved value v gets incremented to x.
	 * @param int[] A
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int minimumIncrementtoMakeArrayUniqueI(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] cnts = new int[80000];
        for (int a: A) {
        	cnts[a]++;
        }
        int taken = 0;
        int res = 0;
        for (int i = 0; i < 80000; i++) {
        	if (cnts[i] > 1) {
        		taken += cnts[i] - 1;
        		res -= i * (cnts[i] - 1);
        	}
        	else if (taken > 0 && cnts[i] == 0) {
        		taken -= 1;
        		res += i;
        	}
        }
        return res;
    }
	
	/**
	 * Approach1: Sort the array.
	 * Compared with previous number,
	 * the current number need to be at least prev + 1.
	 * @param int[] A
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
    public int minimumIncrementtoMakeArrayUnique(int[] A) {
        if (A == null || A.length == 0) return 0;
        Arrays.sort(A);
        int res = 0;
        int need = 0;
        for (int a: A) {
            res += (a >= need ? 0 : need - a);
            need = Math.max(a, need) + 1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumIncrementtoMakeArrayUnique result = new MinimumIncrementtoMakeArrayUnique();
		System.out.println(result.minimumIncrementtoMakeArrayUnique(new int[] {3,2,1,2,1,7}));
		System.out.println(result.minimumIncrementtoMakeArrayUniqueI(new int[] {3,2,1,2,1,7}));
	}

}
