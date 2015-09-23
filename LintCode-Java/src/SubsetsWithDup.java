import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given a list of numbers that may has duplicate numbers, return all possible subsets
//
//Have you met this question in a real interview? Yes
//Example
//If S = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
//Note
//Each element in a subset must be in non-descending order.
//
//The ordering between two subsets is free.
//
//The solution set must not contain duplicate subsets.


public class SubsetsWithDup {
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.isEmpty()) {
			return result;
		}
		Collections.sort(S);
		ArrayList<Integer> list = new ArrayList<Integer>();
		subsetsWithDupHelper(result, list, S, 0);
		return result;
	}
	
	public void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list,
			ArrayList<Integer> S,
			int pos) {
		result.add(new ArrayList<Integer>(list));
		for (int i = pos; i < S.size(); i++) {
			if ( i != pos && S.get(i) == S.get(i - 1)) {
				continue;
			}
			list.add(S.get(i));
			subsetsWithDupHelper(result, list, S, i + 1);
			list.remove(list.size() - 1);
			
		}
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsWithDup arr = new SubsetsWithDup();
		System.out.println(arr.subsetsWithDup(new ArrayList<Integer>(Arrays.asList(1, 2, 2))));

	}

}
