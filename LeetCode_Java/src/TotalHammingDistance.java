/**
 * The Hamming distance between two integers is the number of positions at which the corresponding 
 * bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * Example:
 * Input: 4, 14, 2
 * Output: 6
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * 1. Elements of the given array are in the range of 0 to 10^9
 * 2. Length of the array will not exceed 10^4.
 * @author wendi
 *
 */
public class TotalHammingDistance {
	
	
	
	/**
	 * bit manipultate
	 * For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array 
	 * which have that bit set. Then, if there are n integers in the array and k of them have a 
	 * particular bit set and (n-k) do not, then that bit contributes k*(n-k) hamming distance to 
	 * the total.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int totalHammingDistance(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		int n = nums.length;
		for (int i = 0; i < 32; i++) {
			int k = 0;
			for (int num: nums) {
				k += (num >> i) & 1;
			}
			res += k * (n - k);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TotalHammingDistance result = new TotalHammingDistance();
		System.out.println(result.totalHammingDistance(new int[] {4, 14, 2}));
	}

}
