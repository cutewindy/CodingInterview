package wePay;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Alerter {
	
	/**
	 * sliding window
	 * @param int[] A, int windowSize, double threshold
	 * @return boolean
	 * Time: O(nk)
	 * Space: O(k)
	 */
	public boolean alerter(int[] A, int k, double t) {
		if (A == null || A.length == 0 || k == 0) {
			return false;
		}
		int n = A.length;
		double minAvg = Double.MAX_VALUE;  // minimum average of previous windows
		double sum = 0;  // current window's sum
		int[] counts = new int[k];
		// init deque
		for (int i = 0; i < k - 1 && i < n; i++) {
			sum += A[i];
		}

		// sliding window
		for (int s = 0, e = k - 1; e < n; s++, e++) {
			sum += A[e];
			double currAvg = sum / k;
			if (currAvg > minAvg * t) return true; // rule 2
			for (int i = s; i <= e; i++) {
				if (A[i] > currAvg * t) counts[i % k]++;
				if (i < k - 1 && counts[i % k] == i + 1 || i > n - k && counts[i % k] == n - i ||counts[i % k] == k) {  // rule 1
					return true;   
				}
			}
			minAvg = Math.min(currAvg, minAvg);
			sum -= A[s];
			counts[s % k] = 0;
		}
		
		return false;
	}
	
	
//	public boolean alerter(int[] A, int k, double t) {
//		if (A == null || A.length == 0 || k == 0) {
//			return false;
//		}
//		int n = A.length;
//		double minAvg = Double.MAX_VALUE;  // minimum average of previous windows
//		double sum = 0;  // current window's sum
//		int[] counts = new int[n];
//		// init deque
//		for (int i = 0; i < k - 1 && i < n; i++) {
//			sum += A[i];
//		}
//
//		// sliding window
//		for (int s = 0, e = k - 1; e < n; s++, e++) {
//			sum += A[e];
//			double currAvg = sum / k;
//			if (currAvg > minAvg * t) return true; // rule 2
//			for (int i = s; i <= e; i++) {
//				if (A[i] > currAvg * t) counts[i]++;
//				if (i < k - 1 && counts[i] == i + 1 || i > n - k && counts[i] == n - i ||counts[i] == k) {  // rule 1
//					return true;   
//				}
//			}
//			minAvg = Math.min(currAvg, minAvg);
//			sum -= A[s];
//		}
//		
//		return false;
//	}
	
	
//	public boolean alerter(int[] A, int k, double t) {
//		if (A == null || A.length == 0) {
//			return false;
//		}
//		double minAvg = Double.MAX_VALUE;  // minimum average of previous windows
//		double sum = 0;  // current window's sum
//		Deque<Integer> deque = new LinkedList<>(); // stores maximum value in decreasing order within a window
//		// init deque
//		for (int i = 0; i < k - 1 && i < A.length; i++) {
//			while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
//				deque.pollLast();
//			}
//			deque.offer(i);
//			sum += A[i];
//		}
//
//		// sliding window
//		for (int s = 0, e = k - 1; e < A.length; s++, e++) {
//			while (!deque.isEmpty() && deque.peek() < s) {    
//				deque.poll();
//			}
//			while (!deque.isEmpty() && A[deque.peekLast()] < A[e]) {
//				deque.pollLast();
//			}
//			deque.offer(e);
//			sum += A[e];
//			double currAvg = sum / k;
//			if (A[deque.peek()] > currAvg * t || currAvg > minAvg * t) {  // check rule1 and rule2
//				return true;
//			}
//			minAvg = Math.min(currAvg, minAvg);
//			sum -= A[s];
//		}
//		
//		return false;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alerter result = new Alerter();
		System.out.println(result.alerter(new int[] {1, 2, 100, 2, 2}, 3, 1.5));  // true
		System.out.println(result.alerter(new int[] {1, 50, 100, 50, 1}, 3, 1.5)); // false
		System.out.println(result.alerter(new int[] {1, 2, 4, 2, 2}, 3, 2));      // false
		System.out.println(result.alerter(new int[] {1, 2, 100, 2, 2}, 2, 2.5));  // true
	}

}
