import java.util.ArrayList;
import java.util.Arrays;

//Given a rotated sorted array, recover it to sorted array in-place.
//
//Have you met this question in a real interview? Yes
//Example
//[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
//
//Challenge
//In-place, O(1) extra space and O(n) time.
//
//Clarification
//What is rotated array?
//
//For example, the orginal array is [1,2,3,4], 
//The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
public class RecoverRotatedSortedArray {
	
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return;
		}
		int min;
		for (min = 0; min < nums.size() - 1; min ++) {
			if (nums.get(min) > nums.get(min + 1)) {
				break;
			 }
		}
		min ++;
//		System.out.println(min);
		reverse(nums, 0, min - 1);
		reverse(nums, min, nums.size() - 1);
		reverse(nums, 0, nums.size() - 1);
	
	}
	
	public void reverse(ArrayList<Integer> nums, 
			int start, 
			int end) {
		int temp;
		while (start < end) {
			temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
			start ++;
			end --;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverRotatedSortedArray result = new RecoverRotatedSortedArray();
//		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 5, 1, 2, 3));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
		result.recoverRotatedSortedArray(list);
		System.out.println(list);
	}

}
