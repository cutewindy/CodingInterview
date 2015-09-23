//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Have you met this question in a real interview? Yes
//Example
//A = [1, 2, 3, empty, empty], B = [4, 5]
//
//After merge, A will be filled as [1, 2, 3, 4, 5]
//
//Note
//You may assume that A has enough space (size that is greater or equal to m + n) 
//to hold additional elements from B. 
//The number of elements initialized in A and B are m and n respectively.


public class MergeSortedArray {
	
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		while ( m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[m + n - 1] = A[m - 1];
				m --;
			}
			else {
				A[m + n - 1] = B[n - 1];
				n --;
			}
		}
		
		while (n > 0) {
			A[m + n - 1] = B[n - 1];
			n --;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray result = new MergeSortedArray();
//		int[] A = {1, 2, 3, 0, 0};
//		int[] B = {4, 5};
		
		int[] A = {9, 10, 11, 12, 13, 0, 0, 0, 0};
		int[] B = {4, 5, 6, 7};
		int m = A.length - B.length;
		int n = B.length;
		result.mergeSortedArray(A, m, B, n);
		for (int i = 0; i < A.length; i ++) {
			System.out.println(A[i]);
		}

	}

}
