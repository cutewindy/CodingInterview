

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given a list of numbers, return all possible permutations.
//
//Have you met this question in a real interview? Yes
//Example
//For nums = [1,2,3], the permutations are:
//
//[
//[1,2,3],
//[1,3,2],
//[2,1,3],
//[2,3,1],
//[3,1,2],
//[3,2,1]
//]
//Challenge
//Do it without recursion.


public class Permute {	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.isEmpty()) {
			return result;
		}
		Collections.sort(nums);
		ArrayList<Integer> list = new ArrayList<Integer>();
		permuteHelper(result, list, nums);		
		return result;
	}	
	
	public void permuteHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list,
			ArrayList<Integer> nums) {
		if (list.size() == nums.size()) {
			result.add(new ArrayList<Integer>(list));
			return;
		}				
		for (int i = 0; i < nums.size(); i++) {
			if (list.contains(nums.get(i))) {
				continue;
			}
			list.add(nums.get(i));
			permuteHelper(result, list, nums);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permute arr = new Permute();
		System.out.println(arr.permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));

	}

}












