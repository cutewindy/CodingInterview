//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//
//Your function should return length = 5, and A is now [1,1,2,2,3].
public class RemoveDuplicatesfromSortedArrayII {
	
	public int removeDuplicatesfromSortedArrayII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int size = 1;
		for (int i = 2; i < nums.length; i++) {
			if (nums[size] != nums[i] || nums[size] != nums[size - 1]) {
				size ++;
				nums[size] = nums[i];
			}
		}
		return size + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArrayII result = new RemoveDuplicatesfromSortedArrayII();
		int[] array = {1, 1, 1, 2, 2, 3};
		System.out.println(result.removeDuplicatesfromSortedArrayII(array));

	}

}
