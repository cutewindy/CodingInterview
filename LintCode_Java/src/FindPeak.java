//There is an integer array which has the following features:
//
//The numbers in adjacent positions are different.
//A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
//We define a position P is a peek if:
//
//A[P] > A[P-1] && A[P] > A[P+1]
//Find a peak element in this array. Return the index of the peak.
//
//Have you met this question in a real interview? Yes
//Example
//Given [1, 2, 1, 3, 4, 5, 7, 6]
//
//Return index 1 (which is number 2) or 6 (which is number 7)
//
//Note
//The array may contains multiple peeks, find any of them.
//
//Challenge
//Time complexity O(logN)


public class FindPeak {

	public int findPeak(int[] A) {
		if (A == null || A.length <= 2) {
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] < A[mid - 1]) {
				end = mid;
			}
			else if (A[mid] < A[mid + 1]) {
				start = mid;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeak result = new FindPeak();
		int[] array = {1, 2, 1, 3, 4, 5, 7, 6};
		System.out.println(result.findPeak(array));

	}

}
