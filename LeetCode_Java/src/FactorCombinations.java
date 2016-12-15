import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;  = 2 x 4.
 *  Write a function that takes an integer 【i】n and return all possible combinations of its 
 *  factors.
 * Note: 
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6
 *  is [2, 6], not [6, 2].
 * You may assume that 【i】n is always positive.
 * Factors should be greater than 1 and less than 【i】n.
 * Examples: 
 * input: 1
 * output: []
 * input: 37
 * output: []
 * input: 12
 * output: [[2, 6],  [2, 2, 3],  [3, 4]]
 * input: 32
 * output: [[2, 16],  [2, 2, 8],  [2, 2, 2, 4],  [2, 2, 2, 2, 2],  [2, 4, 4],  [4, 8]]
 * 
 * @author wendi
 *
 */
public class FactorCombinations {

	/**
	 * DFS: find the factor of product in the range of [start, n]. 
	 * Save the satisfied fact in the currFact until n==1 and currFactor.size()>1.
	 * @param int n
	 * @return List<List<Integer>>
	 * Time :O()
	 * Space: O()
	 * Stack space: O()
	 */
	public List<List<Integer>> factorCombinations(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) return result;
        helper(n, 2, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper(int n, int start, List<Integer> currfactor, List<List<Integer>> result) {
        if (n == 1 && currfactor.size() > 1) {   // using curr.size() > 1 to skip curr=[n]
            result.add(new ArrayList<Integer>(currfactor));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {   // guarantees the current i is a factor
                currfactor.add(i);
                helper(n / i, i, currfactor, result);
                currfactor.remove(currfactor.size() - 1);
            }
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorCombinations result = new FactorCombinations();
		System.out.println(result.factorCombinations(12));
	}

}
