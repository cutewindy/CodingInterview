import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given a set of distinct integers, return all possible subsets.
//
//Have you met this question in a real interview? Yes
//Example
//If S = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
//Note
//Elements in a subset must be in non-descending order.
//
//The solution set must not contain duplicate subsets

public class Subsets {


	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();		
		if (S == null || S.isEmpty()) {
			return result;
		}
		Collections.sort(S);
		ArrayList<Integer> list = new ArrayList<Integer>();
		subsetsHelper(result, list, S, 0);
		return result;
	}
	
	public void subsetsHelper(ArrayList<ArrayList<Integer>> result,
				ArrayList<Integer> list, 
				ArrayList<Integer> S,
				int pos) {
		result.add(new ArrayList<Integer>(list));
		for (int i = pos; i < S.size(); i++) {
			list.add(S.get(i));
			subsetsHelper(result, list, S, i + 1);
			list.remove(list.size() - 1);
		}
	}
				

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets arr = new Subsets();
		System.out.println(arr.subsets(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
	}

}






