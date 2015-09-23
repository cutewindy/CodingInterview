import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given a list of numbers with duplicate number in it. Find all unique permutations.
//
//Have you met this question in a real interview? Yes
//Example
//For numbers [1,2,2] the unique permutations are:
//
//[
//
//    [1,2,2],
//
//    [2,1,2],
//
//    [2,2,1]
//
//]
//
//Challenge
//Do it without recursion.


public class PermuteUnique {
	
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.isEmpty()) {
			return result;
		}
		Collections.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[nums.size()];
		permuteUniqueHelper(result, list, nums, visited);
		return result;
	}
	
	public void permuteUniqueHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list,
			ArrayList<Integer> nums,
			boolean[] visited) {
		if (list.size() == nums.size() && !result.contains(list)) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			list.add(nums.get(i));
			permuteUniqueHelper(result, list, nums, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermuteUnique arr = new PermuteUnique();
		System.out.println(arr.permuteUnique(new ArrayList<Integer>(Arrays.asList(1, 2, 2))));
	}

}


















