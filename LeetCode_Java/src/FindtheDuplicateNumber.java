/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate 
 * number, find the duplicate one.
 * Note:
 * 1 You must not modify the array (assume the array is read only).
 * 2 You must use only constant, O(1) extra space.
 * 3 Your runtime complexity should be less than O(n2).
 * 4 There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * Tags: BinarySearch, Array, Two pointers
 * @author wendi
 *
 */
public class FindtheDuplicateNumber {
	
	
	/**
	 * Method2: Modify the array using index is sorted array.
	 * @param int[] nums
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int findtheDuplicateNumberI(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i && nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            if (nums[i] != i) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                i--;
            }
        }
        return -1;
	}

	
	/**
	 * Method1: 
	 * BinarySearch: given n+1 numbers, the range of number is from 1 to n. At least one number is
	 * duplicate. Ignore the order of nums[i], use the index i as an sorted array. 
	 * Find the mid=(1+n)/2 at first, do for loop to find how many numbers in nums that less then mid.
	 * If the count<mid, means that left of mid has not duplicate. If it has, the count should 
	 * large or equals to mid.
	 * @param int[] nums
	 * @return int
	 * Time: O(nlog(n))
	 * Space: O(1)
	 */
	public int findtheDuplicateNumber(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1){
			return 0;
		}
		int start = 1;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int count = 0;
			for (int num: nums) {
				if (num < mid) {
					count++;
				}
			}
			if (count < mid) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		int count = 0;
		for (int num: nums) {
			if (num < end) {
				count++;
			}
		}
		return count < end? end : start;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindtheDuplicateNumber result = new FindtheDuplicateNumber();
		System.out.println(result.findtheDuplicateNumber(new int[] {2, 2, 2, 3, 1, 5, 6}));
		System.out.println(result.findtheDuplicateNumber(new int[] {1, 5, 6, 3, 2, 2, 2}));
		System.out.println(result.findtheDuplicateNumberI(new int[] {1, 5, 6, 3, 2, 2, 2}));
	}

}
