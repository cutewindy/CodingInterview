/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * You need to return the number of important reverse pairs in the given array.
 * Example1:
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * 1. The length of the given array will not exceed 50,000.
 * 2. All the numbers in the input array are in the range of 32-bit integer.
 * @author wendi
 *
 */
public class ReversePairs {
	
	/**
	 * Merge sort
	 * In each round, we divide our array into two parts and sort them. So after 
	 * "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", the left part and the 
	 * right part are sorted and now our only job is to count how many pairs of number 
	 * (leftPart[i], rightPart[j]) satisfies leftPart[i] <= 2*rightPart[j].
	 * For example,
	 * left: 4 6 8 right: 1 2 3
	 * so we use two pointers to travel left and right parts. For each leftPart[i], if 
	 * j<=e && nums[i]/2.0 > nums[j], we just continue to move j to the end, to increase 
	 * rightPart[j], until it is valid. Like in our example, left's 4 can match 1 and 2; left's 6 
	 * can match 1, 2, 3, and left's 8 can match 1, 2, 3. So in this particular round, there are 8 
	 * pairs found, so we increases our total by 8.
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(n)
	 */
	public int reversePairs(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		return mergeSort(nums, 0, nums.length - 1);
	}
	
	private int mergeSort(int[] nums, int l, int r) {
		if (l >= r) return 0;
		int cnt = 0;
		int mid = l + (r - l) / 2;
		cnt += mergeSort(nums, l, mid);
		cnt += mergeSort(nums, mid + 1, r);
		for (int i = l, j = mid + 1; i <= mid; i++) {
			while (j <= r && nums[i] / 2.0 > nums[j]) j++;  // take care of 2.0
			cnt += j - (mid + 1);
		}
		merge(nums, l, mid, r);
		return cnt;
	}
	
	private void merge(int[] nums, int l, int mid, int r) {
		if (l >= r) return;
		int[] res = new int[r - l + 1];
		int k = 0;
		int i = l, j = mid + 1;
		while (i <= mid && j <= r) {
			if (nums[i] > nums[j]) res[k++] = nums[j++];
			else res[k++] = nums[i++];
		}
		while (i <= mid) res[k++] = nums[i++];
		while (j <= r) res[k++] = nums[j++];
		for (k = l; k <= r; k++) {
			nums[k] = res[k - l];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReversePairs result = new ReversePairs();
		System.out.println(result.reversePairs(new int[] {1,3,2,3,1}));
		System.out.println(result.reversePairs(new int[] {2,4,3,5,1}));
	}

}
