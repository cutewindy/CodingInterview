//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//Have you met this question in a real interview? Yes
//Example
//Given [4, 5, 6, 7, 0, 1, 2] return 0
//
//Note
//You may assume no duplicate exists in the array.
public class FindMinInRotatedSortedArray {
	
	public int findMinInRotatedSortedArray(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		int start = 0;
		int end = num.length - 1;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (num[mid] <= num[end]) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		if (num[start] < num[end]) {
			return num[start];
		}
		else {
			return num[end];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinInRotatedSortedArray result = new FindMinInRotatedSortedArray();
		int[] array = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(result.findMinInRotatedSortedArray(array));

	}

}
