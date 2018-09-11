/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by 
 * one in N days. In each day, there will be exactly one flower blooming and it will be in the 
 * status of blooming since then.
 * Given an array flowers consists of number from 1 to N. Each number in the array represents the 
 * place where the flower will open in that day.
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be at position 
 * x, where i and x will be in the range from 1 to N.
 * Also given an integer k, you need to output in which day there exists two flowers in the status 
 * of blooming, and also the number of flowers between them is k and these flowers are not blooming.
 * If there isn't such day, output -1.
 * Example 1:
 * Input: 
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become blooming.
 * Example 2:
 * Input: 
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 * Note:
 * 1. The given array will be in the range [1, 20000].
 * @author wendi
 *
 */
public class KEmptySlots {
	
	
	/**
	 * Greedy + sliding window
	 * flowers[i] = x表示第i天放的花会在位置x
	 * days[i] = t表示在i+1位置上会在第t天放上花
	 * maintain a window, left -> right. If an element days[I] is smaller than either of the two 
	 * ends, update the ends. It can be proved all numbers before days[I] will not be an edge as 
	 * they are either larger than days[I], or is checked already.
	 * @param int[] flowers, int k
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int kEmptySlots(int[] flowers, int k) {
		if (flowers == null || flowers.length == 0 || k + 1 >= flowers.length) return -1;
		int n = flowers.length;
		int[] days = new int[n];
		for (int i = 0; i < n; i++) days[flowers[i] - 1] = i + 1;
		int left = 0, right = k + 1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n && right < n; i++) {
			int max = Math.max(days[left], days[right]);
			if (days[i] <= max) {
				if (i == right) res = Math.min(max, res);
				left = i;
				right = i + k + 1;
			}
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KEmptySlots result = new KEmptySlots();
		System.out.println(result.kEmptySlots(new int[] {1,3,2}, 1));
		System.out.println(result.kEmptySlots(new int[] {1,2,3}, 1));
	}

}
