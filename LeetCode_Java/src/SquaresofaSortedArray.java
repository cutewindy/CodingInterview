/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of 
 * each number, also in sorted non-decreasing order.
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Note:
 * 1. 1 <= A.length <= 10000
 * 2. -10000 <= A[i] <= 10000
 * 3. A is sorted in non-decreasing order.
 * @author wendi
 *
 */
public class SquaresofaSortedArray {
	
	
	/**
	 * two pointers
	 * @param int[] A
	 * @return int[]
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int[] squaresofaSortedArray(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int n = A.length;
        int[] res = new int[n];
        int l = 0;
        int r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[l] * A[l] < A[r] * A[r]) {
                res[i] = A[r] * A[r];
                r--;
            }
            else {
                res[i] = A[l] * A[l];
                l++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquaresofaSortedArray result = new SquaresofaSortedArray();
		System.out.println(result.squaresofaSortedArray(new int[] {-4,-1,0,3,10}));
	}

}
