import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a 
 * binary search tree.
 * You may assume each number in the sequence is unique.
 * Consider the following binary search tree: 
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * Example 1:
 * Input: [5,2,6,1,3]
 * Output: false
 * Example 2:
 * Input: [5,2,1,3,6]
 * Output: true
 * Follow up:
 * Could you do it using only constant space complexity?
 * @author wendi
 *
 */
public class VerifyPreorderSequenceinBinarySearchTree {
	
	/**
	 * Method2: stack
	 * Same like method1, but using input array as stack, pop as the same as i--, push as the same 
	 * as ++i
	 * @param int[] preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean verifyPreorderSequenceinBinarySearchTreeI(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        int i = -1; 
        int min = Integer.MIN_VALUE;
        for (int num: preorder) {
        	if (num < min) return false;
        	while (i >= 0 && num > preorder[i]) {
        		min = preorder[i--];
        	}
        	preorder[++i] = num; 
        }
        return true;
	}
	
	
	/**
	 * Method1: stack
	 * keeping a stack of nodes (just their values) of which we're still in the left subtree. If the 
	 * next number is smaller than the last stack value, then we're still in the left subtree of all 
	 * stack nodes, so just push the new one onto the stack. But before that, pop all smaller 
	 * ancestor values, as we must now be in their right subtrees (or even further, in the right 
	 * subtree of an ancestor). Also, use the popped values as a lower bound, since being in their 
	 * right subtree means we must never come across a smaller number anymore.
	 * @param int[] preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean verifyPreorderSequenceinBinarySearchTree(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int num: preorder) {
        	if (num < min) return false;
        	while (!stack.isEmpty() && num > stack.peek()) {
        		min = stack.pop();
        	}
        	stack.push(num);
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSequenceinBinarySearchTree result = new VerifyPreorderSequenceinBinarySearchTree();
		System.out.println(result.verifyPreorderSequenceinBinarySearchTree(new int[] {5,2,6,1,3}));
		System.out.println(result.verifyPreorderSequenceinBinarySearchTree(new int[] {5,2,1,3,6}));
		System.out.println(result.verifyPreorderSequenceinBinarySearchTreeI(new int[] {5,2,6,1,3}));
		System.out.println(result.verifyPreorderSequenceinBinarySearchTreeI(new int[] {5,2,1,3,6}));
	}

}
