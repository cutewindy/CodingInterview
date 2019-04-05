package IBM;
/**
 * 3. Find the index to insert a number in a sorted array  
4. 跟第三题一样，除了array被rotated过了。
 * @author wendi
 *
 */
public class FindIndextoInsertaNuminRotatedArray {
	
	
	/**
	 * Binary Search
	 * Time: O(log(n))
	 * Space: O(1)
	 */
	public int findIndextoInsertaNuminRotatedArray(int[] nums, int x) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				if (nums[mid] < x && x < nums[end]) start = mid;
				else end = mid;
			}
			else {
				if (nums[start] < x && x < nums[mid]) end = mid;
				else start = mid;
			}
		}
		if (nums[start] > nums[end]) {
			if (x > nums[start]) return start + 1;
			else if (x < nums[end]) return end;
			return end + 1;
		}
		else {
			if (x < nums[start]) return start;
			else if (nums[start] < x && x < nums[end]) return end;
			return end + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindIndextoInsertaNuminRotatedArray result = new FindIndextoInsertaNuminRotatedArray();
		System.out.println(result.findIndextoInsertaNuminRotatedArray(new int[] {4, 5, 1, 2, 3, }, 6));
	}

}
