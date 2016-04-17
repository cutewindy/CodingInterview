//Given a sorted array, remove the duplicates in place such that each element 
//appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place 
//with constant memory.
//
//Have you met this question in a real interview? Yes
//Example
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2].


public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicatesfromSortedArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int size = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[size] != nums[i]) {
				size++;
				nums[size] = nums[i];
			}
		}
		return size + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray result = new RemoveDuplicatesfromSortedArray();
		int[] array = {1, 1, 2};
		System.out.println(result.removeDuplicatesfromSortedArray(array));

	}

}
