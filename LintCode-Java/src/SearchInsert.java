//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume NO duplicates in the array.
//
//Have you met this question in a real interview? Yes
//Example
//[1,3,5,6], 5 → 2
//
//[1,3,5,6], 2 → 1
//
//[1,3,5,6], 7 → 4
//
//[1,3,5,6], 0 → 0

public class SearchInsert {
	
	public int searchInsert (int[] A, int target) {
		int index = 0;
		if (A == null || A.length == 0) {
			return index;
		}
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			else if (A[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		if (A[start] >= target) {
			index = start;
		}
		else if (A[end] >= target) {
			index = end;
		}
		else {
			index = end + 1;
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsert result = new SearchInsert();
		int[] arr = {1, 3, 5, 6};
		System.out.println(result.searchInsert(arr, 5));

	}

}
