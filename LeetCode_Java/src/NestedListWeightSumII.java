import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import NestedListWeightSum.NestedInteger;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf, now the weight 
 * is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers 
 * have the largest weight.
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 
 * 1*3 + 4*2 + 6*1 = 17)
 * 
 * Tags: 
 * @author wendi
 *
 */
public class NestedListWeightSumII {
	
	/**
	 * BFS
	 * @param List<NestedInteger> nestedList
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 * Stack Space: O(n)
	 */
	public int nestedListWeightSumII(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		int result = 0;
		int temp = 0;
		Queue<List<NestedInteger>> queue = new LinkedList<>();
		queue.offer(nestedList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<NestedInteger> curr = queue.poll();
				for (NestedInteger currNum: curr) {
					if (currNum.isInteger()) {
						temp += currNum.getInteger();
					}
					else {
						queue.offer(currNum.getList());
					}
				}
			}
			result += temp;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
