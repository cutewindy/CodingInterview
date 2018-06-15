/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the 
 * longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next 
 * element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before 
 * a duplicate element occurs in S.
 * Example 1:
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation: 
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * Note:
 * 1. N is an integer within the range [1, 20,000].
 * 2. The elements of A are all distinct.
 * 3. Each element of A is an integer within the range [0, N-1].
 * @author wendi
 *
 */
public class ArrayNesting {
	
	
	/**
	 * The elements in same nesting shown by arrows form a cycle. Thus, the elements will be added 
	 * to the same set irrespective of the first element chosen to be added.
	 * The idea is to, start from every number, find circles in those index-pointer-chains, every 
	 * time you find a set (a circle) mark every number as visited (-1) so that next time you won't 
	 * step on it again.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int arrayNesting(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; nums[j] != -1;) {
                int next = nums[j];
                nums[j] = -1;      // mark nums[j] as visited;
                j = next;
                count++;
            }
            res = Math.max(count, res);
        }
		return res; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayNesting result = new ArrayNesting();
		System.out.println(result.arrayNesting(new int[] {5,4,0,3,1,6,2}));
		
	}

}
