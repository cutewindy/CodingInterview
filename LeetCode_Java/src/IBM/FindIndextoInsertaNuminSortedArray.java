package IBM;
/**
 * find the index to inserta number in a sorted array
 * @author wendi
 *
 */
public class FindIndextoInsertaNuminSortedArray {
	
	/**
	 * Binary search
	 * Time:O(log(n))
	 * Space: O(1)
	 */
	public int findIndextoInsertaNuminSortedArray(int[] nums, int x) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == x) {
				if (nums[start] == x) end--;
				else start++;
			}
			else if (nums[mid] < x) start++;
			else end--;
		}
		if (nums[start] >= x) return start;
		if (nums[end] >= x) return end;
		return end + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindIndextoInsertaNuminSortedArray result = new FindIndextoInsertaNuminSortedArray();
		System.out.println(result.findIndextoInsertaNuminSortedArray(new int[] {1, 3, 4, 4, 4, 5, 5, 6}, 4));
	}

}
