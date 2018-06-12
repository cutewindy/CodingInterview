/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is 
 * constructed by these N numbers successfully if one of the following is true for the ith position 
 * (1 <= i <= N) in this array:
 * 1. The number at the ith position is divisible by i.
 * 2. i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: 
 * The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * Note:
 * N is a positive integer and will not exceed 15.
 * @author wendi
 *
 */
public class BeautifulArrangement {
	
	
	/**
	 * Backtracking
	 * @param int N
	 * @return int
	 * Time: O(k), k refers to the number of valid permutations.
	 * Space: O(N)
	 */
	private int res;
	public int beautifulArrangement(int N) {
		res = 0;
		helper(N, 0, new boolean[N]);
		return res;
	}
	
	private void helper(int N, int pos, boolean[] visited) {
		if (pos == N) {
			res++;
			return;
		}
		for (int n = 1; n <= N; n++) {
			if (visited[n - 1]) continue;
			if ((pos + 1) % n == 0 || n % (pos + 1) == 0) {
				visited[n - 1] = true;
				helper(N, pos + 1, visited);
				visited[n - 1] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeautifulArrangement result = new BeautifulArrangement();
		System.out.println(result.beautifulArrangement(2));
	}

}
