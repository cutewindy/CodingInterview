package google_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is an integer matrix which has the following features:
 * The numbers in adjacent positions are different.
 * The matrix has n rows and m columns.
 * For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
 * For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
 * We define a position P is a peek if:
 * A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
 * Find a peak element in this matrix. Return the index of the peak.
 * The matrix may contains multiple peeks, find any of them.
 * Have you met this question in a real interview?  
 * Example
 * Given a matrix:
	[
	  [1 ,2 ,3 ,6 ,5],
	  [16,41,23,22,6],
	  [15,17,24,21,7],
	  [14,18,19,20,10],
	  [13,14,11,10,9]
	]
 * return index of 41 (which is [1,1]) or index of 24 (which is [2,2])
 * Challenge
 * Solve it in O(n+m) time.
 * If you come up with an algorithm that you thought it is O(n log m) or O(m log n), can you prove 
 * it is actually O(n+m) or propose a similar but O(n+m) algorithm?
 * @author wendi
 *
 */
public class FindPeakElementII {
	
	/**
	 * Binary search for row, but cannot do binary search for col again(see input2)
	 * @param int[][]A
	 * @return List<Integer>
	 * Time: O(log(m)*n)
	 * Space: O(1)
	 */
	public List<Integer> findPeakElementII(int[][] A) {
		int top = 1;
		int bottom = A.length - 2;
		while (top + 1 < bottom) {
			int mid = top + (bottom - top) / 2;
			int col = findPeak(A, mid);
			if (A[mid - 1][col] < A[mid][col] && A[mid][col] > A[mid + 1][col]) {
				return new ArrayList<>(Arrays.asList(mid, col));
			}
			else if (A[mid - 1][col] < A[mid][col] && A[mid][col] < A[mid + 1][col]) top = mid + 1;
			else bottom = mid - 1;
		}
		int tCol = findPeak(A, top);
		if (A[top - 1][tCol] < A[top][tCol] && A[top][tCol] > A[top + 1][tCol]) {
		    return new ArrayList<>(Arrays.asList(top, tCol));
		} 
		int bCol = findPeak(A, bottom);
		if (A[bottom - 1][bCol] < A[bottom][tCol] && A[bottom][bCol] > A[bottom + 1][bCol]) {
		    return new ArrayList<>(Arrays.asList(bottom, bCol));
		} 
		return new ArrayList<Integer>();
	}
	
	private int findPeak(int[][] A, int row) {
		int col = 1;
		for (int j = 0; j < A[0].length - 1; j++) {
			if (A[row][j] > A[row][col]) col = j;
		}
		return col;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPeakElementII result = new FindPeakElementII();
		System.out.println(result.findPeakElementII(new int[][] {
												  {1 ,2 ,3 ,6 ,5},
												  {16,41,23,22,6},
												  {15,17,24,21,7},
												  {14,18,19,20,10},
												  {13,14,11,10,9}}));
		System.out.println(result.findPeakElementII(new int[][] {
												  {1,2,1,2,1,2,1},
												  {2,17,13,6,5,17,2},
												  {1,15,8,10,8,15,1},
												  {2,14,12,11,12,14,2},
												  {1,2,1,2,1,2,1}}));
	}

}
