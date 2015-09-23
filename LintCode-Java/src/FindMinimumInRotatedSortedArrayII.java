//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//The array may contain duplicates.
//
//Have you met this question in a real interview? Yes
//Example
//Given [4,4,5,6,7,0,1,2] return 0

public class FindMinimumInRotatedSortedArrayII {
	
	public int findMinimumInRotatedSortedArrayII(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			if (min > num[i]) {
				min = num[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimumInRotatedSortedArrayII result = new FindMinimumInRotatedSortedArrayII();
		int[] array = {4, 4, 5, 6, 7, 0, 1, 2};
		System.out.println(result.findMinimumInRotatedSortedArrayII(array));

	}

}
