/**
 * Let's call an array A a mountain if the following properties hold:
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that 
 * A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that 
 * A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * Example 1:
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * 1. 3 <= A.length <= 10000
 * 2. 0 <= A[i] <= 10^6
 * 3. A is a mountain, as defined above.
 * @author wendi
 *
 */
public class PeakIndexinaMountainArray {
	
	
	/**
	 * Binary Search
	 * @param int[] A
	 * @return int
	 * Time: O(log(n))
	 * Space: O(1)
	 */
    public int peakIndexinaMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) return mid;
            else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return A[start] > A[end] ? start : end;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PeakIndexinaMountainArray result = new PeakIndexinaMountainArray();
		System.out.println(result.peakIndexinaMountainArray(new int[] {0,2,1,0}));
	}

}
