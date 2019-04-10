/**
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, 
 * and two sightseeing spots i and j have distance j - i between them.
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values 
 * of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots.
 * Example 1:
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * Note:
 * 1. 2 <= A.length <= 50000
 * 2. 1 <= A[i] <= 1000
 * @author wendi
 *
 */
public class BestSightseeingPair {
	
	
	/**
	 * DP
	 * @param int[] A
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
    public int bestSightseeingPair(int[] A) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            res = Math.max(max + A[i] - i, res);
            max = Math.max(A[i] + i, max);
        }
        return res;        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestSightseeingPair result = new BestSightseeingPair();
		System.out.println(result.bestSightseeingPair(new int[] {8,1,5,2,6}));
	}

}
