/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone 
 * decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 * Note:
 * 1. 1 <= A.length <= 50000
 * 2. -100000 <= A[i] <= 100000
 * @author wendi
 *
 */
public class MonotonicArray {
	
	/**
	 * Approach2: Two pass check
	 * @param int[] A
	 * @return boolean
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public boolean monotonicArrayI(int[] A) {
        if (A == null || A.length <= 1) return true;
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.length - 1; i++) {
        	inc &= A[i] <= A[i + 1];
        	dec &= A[i] >= A[i + 1];
        }
        return inc || dec;
	}
	
	/**
	 * Approach1: Two pass check
	 * @param int[] A
	 * @return boolean
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public boolean monotonicArray(int[] A) {
        if (A == null || A.length <= 1) return true;
        int i = 0;
        while (i < A.length - 1) {
            if (A[i] > A[i + 1]) break;
            i++;
        }
        if (i == A.length - 1) return true;
        i = A.length - 1;
        while (i > 0) {
            if (A[i] > A[i - 1]) break;
            i--;
        }
        return i == 0;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonotonicArray result = new MonotonicArray();
		System.out.println(result.monotonicArray(new int[] {1,2,2,3}));
		System.out.println(result.monotonicArrayI(new int[] {1,2,2,3}));
	}

}
