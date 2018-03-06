import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
	 * BFS: add each level node's value by level times
	 * @param List<NestedInteger> nestedList
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int nestedListWeightSumII(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		int result = 0;
		int sum = 0;
		Queue<List<NestedInteger>> queue = new LinkedList<>();
		queue.offer(nestedList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<NestedInteger> curr = queue.poll();
				for (NestedInteger currNum: curr) {
					if (currNum.isInteger()) {
						sum += currNum.getInteger();
					}
					else {
						queue.offer(currNum.getList());
					}
				}
			}
			result += sum;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedListWeightSumII result = new NestedListWeightSumII();
		NestedInteger list1 = new NestedInteger();
		list1.add(new NestedInteger(1));
		list1.add(new NestedInteger(1));
		NestedInteger list2 = new NestedInteger();
		list2.add(new NestedInteger(1));
		list2.add(new NestedInteger(1));
		List<NestedInteger> nestedList = new ArrayList<>();
		nestedList.add(list1);
		nestedList.add(new NestedInteger(2));
		nestedList.add(list2);	
		System.out.println(result.nestedListWeightSumII(nestedList));
	}

}
