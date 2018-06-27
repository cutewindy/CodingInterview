import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null 
 * node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
		     _9_
		    /   \
		   3     2
		  / \   / \
		 4   1  #  6
		/ \ / \   / \
		# # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
 * where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal 
 * serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing 
 * null pointer.
 * You may assume that the input format is always valid, for example it could never contain two 
 * consecutive commas such as "1,,3".
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * Example 2:
 * "1,#"
 * Return false
 * Example 3:
 * "9,#,#,1"
 * Return false
 * 
 * Tags: Stack
 * @author wendi
 *
 */
public class VerifyPreorderSerializationofaBinaryTree {

	/**
	 * Method2: Using outDegree.
	 * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root.
	 * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
	 * record the difference between out degree and in degree diff = outdegree - indegree. 
	 * When the next node comes, decrease diff by 1, because the node provides an in degree. 
	 * If the node is not null, increase diff by 2, because it provides two out degrees. 
	 * If a serialization is correct, diff should never be negative and diff will be zero when finished.
	 * @param preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean verifyPreorderSerializationofaBinaryTreeI(String preorder) {
		if (preorder == null || preorder.length() == 0 ) {
			return true;
		}
		int outDegree = 1;
		String[] newPreorder = preorder.split(",");
		for (String curr: newPreorder) {
			if (--outDegree < 0) return false;
			if (!curr.equals("#")) {
				outDegree += 2;
			}
		}
		return outDegree == 0;
	}
				
	
	/**
	 * Method1: Using a stack
	 * using a stack, scan left to right
     * case 1: we see a number, just push it to the stack
     * case 2: we see #, check if the top of stack is also #
     * if so, pop #, pop the number in a while loop, until top of stack is not #
     * if not, push it to stack
     * in the end, check if stack size is 1, and stack top is #
	 * @param String preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean verifyPreorderSerializationofaBinaryTree(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return true;
		}
		String[] newPreorder = preorder.split(",");
		Stack<String> stack = new Stack<>();
		for (String curr: newPreorder) {
			while (curr.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
				stack.pop();
				if (stack.isEmpty()) return false;
				stack.pop();
			}
			stack.push(curr);
		}
		return stack.size() == 1 && stack.peek().equals("#");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSerializationofaBinaryTree result = new VerifyPreorderSerializationofaBinaryTree();
		System.out.println(result.verifyPreorderSerializationofaBinaryTree("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(result.verifyPreorderSerializationofaBinaryTreeI("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

}
