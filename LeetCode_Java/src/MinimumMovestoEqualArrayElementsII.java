import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array 
 * elements equal, where a move is incrementing a selected element by 1 or decrementing a selected 
 * element by 1.
 * You may assume the array's length is at most 10,000.
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * @author wendi
 *
 */
public class MinimumMovestoEqualArrayElementsII {
	
	/**
	 * Approach1: Quick select to find the median number
	 * @param int[] nums
	 * @return int
	 * Time: best case: O(n), worst case: O(n^2) 
	 * Space: O(1)
	 */
	public int minimumMovestoEqualArrayElementsIII(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int median = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
		int res = 0;
		for (int num: nums) res += Math.abs(num - median);
		return res;
	}
	
	private int quickSelect(int[] nums, int s, int e, int k) {
		if (s == e) return nums[s];
		int i = s;
		for (int j = s; j < e; j++) {
			if (nums[j] < nums[e]) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, e);
		if (k == i) return nums[i];
		else if (k < i) return quickSelect(nums, s, i - 1, k);
		else return quickSelect(nums, i + 1, e, k);
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	

	/**
	 * Approach1: Array sort
	 * Supposing mid is the element of the final equal array which can make the minimum moves.
	 * For example, nums={1,2,89,10086} mid can be any number in [2,89]. if nums={1,4,7} mid is 4. 
	 * So,the question is getting the middle element of an sorted array.
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int minimumMovestoEqualArrayElementsII(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		Arrays.sort(nums);
		int mid = nums[nums.length / 2];
		for (int num: nums) {
			res += Math.abs(num - mid);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumMovestoEqualArrayElementsII result = new MinimumMovestoEqualArrayElementsII();
		System.out.println(result.minimumMovestoEqualArrayElementsII(new int[] {1,2,3}));
		System.out.println(result.minimumMovestoEqualArrayElementsIII(new int[] {1,2,3}));
	}	

}
