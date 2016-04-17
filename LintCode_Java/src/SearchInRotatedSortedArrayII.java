//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Write a function to determine if a given target is in the array.
public class SearchInRotatedSortedArrayII {

	
	public boolean searchInRotatedSortedArrayII(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArrayII result = new SearchInRotatedSortedArrayII();
		int[] array = {1, 1, 1, 1, 1, 2, 1, 1, 1};
		System.out.println(result.searchInRotatedSortedArrayII(array, 2));

	}

}
