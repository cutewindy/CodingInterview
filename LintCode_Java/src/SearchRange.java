import java.util.ArrayList;
import java.util.Arrays;

//Given a sorted array of n integers, find the starting and ending position of a given target value.
//
//If the target is not found in the array, return [-1, -1].
//
//Have you met this question in a real interview? Yes
//Example
//Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
//
//Challenge
//O(log n) time.


public class SearchRange {
   
	public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
		ArrayList<Integer> bound = new ArrayList<Integer>();
		if (A == null || A.isEmpty()) {
			bound.add(-1);
			bound.add(-1);
			return bound;
		}
		int start = 0;
		int end = A.size() - 1;
		int mid;
		
		//starting position
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				end = mid;
			}
			else if (A.get(mid) < target) {
				start = mid;
			}
			else if (A.get(mid) > target) {
				end = mid;
			}
		}
		if (A.get(start) == target) {
			bound.add(start);
		}
		else if (A.get(end) == target) {
			bound.add(end);
		}
		else {
			bound.add(-1);
			bound.add(-1);
			return bound;
		}


		//ending position
		start = 0;
		end = A.size() - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				start = mid;
			}
			else if (A.get(mid) < target) {
				start = mid;
			}
			else if (A.get(mid) > target) {
				end = mid;
			}
		}
		if (A.get(end) == target) {
			bound.add(end);
		}
		else if (A.get(start) == target) {
			bound.add(start);
		}
		else {
			bound.remove(bound.size() - 1);
			bound.add(-1);
			bound.add(-1);
			return bound;
		}			
		return bound;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchRange result = new SearchRange();
		System.out.println(result.searchRange(new ArrayList<Integer>(Arrays.asList(5, 7, 7, 8, 8, 10)), 8));
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		System.out.println(result.searchRange(list, 1));
	}

}
