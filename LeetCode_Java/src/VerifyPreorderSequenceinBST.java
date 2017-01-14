import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a 
 * binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up:
 * Could you do it using only constant space complexity?
 * 
 * Tags: Tree, Stack
 * @author wendi
 *
 */
public class VerifyPreorderSequenceinBST {

	/**
	 * Method3: like method2, using preorder as stack.
	 * @param int[] preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean verifyPreorderSequenceinBSTII(int[] preorder) {
		if (preorder == null || preorder.length <= 1) {
			return true;
		}
		int low = Integer.MIN_VALUE;
		int i = -1;
		for (int p: preorder) {
			if (p < low) { 
				return false;
			}
			while (i >= 0 && p > preorder[i]) {
				low = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}
	
	
	/**
	 * Method2: Stack: simulate the traversal, keeping a stack of nodes (just their values) of which 
	 * we're still in the left subtree. If the next number is smaller than the last stack value, 
	 * then we're still in the left subtree of all stack nodes, so just push the new one onto the 
	 * stack. But before that, pop all smaller ancestor values, as we must now be in their right 
	 * subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values 
	 * as a lower bound, since being in their right subtree means we must never come across a smaller 
	 * number anymore.
	 * @param int[] preorder
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean verifyPreorderSequenceinBSTI(int[] preorder) {
		if (preorder == null || preorder.length <= 1) {
			return true;
		}
		int low = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<>();
		for (int p: preorder) {
			if (p < low) {
				return false;
			}
			while (!stack.isEmpty() && p > stack.peek()) {
				low = stack.pop();
			}
			stack.push(p);
		}
		return true;
	}
	
	
	/**
	 * Method1: DFS + Divide and Conquer: 
	 * A BST's left child is always < root, right child is always > root.
	 * @param int[] preorder
	 * @return boolean
	 * Time: O(nlog(n)), worse case: O(n^2)
	 * Space: O(1)
	 * Stack space: O(log(n)), worse case: O(n)
	 */
	public boolean verifyPreorderSequenceinBST(int[] preorder) {
		if (preorder == null || preorder.length <= 1) return true;
		return helper(preorder, 0, preorder.length - 1);
	}
	
	private boolean helper(int[] preorder, int start, int end) {
		if (start >= end) return true;
		int index = start + 1;
		while (index <= end) {
			if (preorder[index] > preorder[start]) break;
			index++;
		}
		int bigger = index;
		while (index <= end) {
			if (preorder[index] < preorder[start]) return false;
			index++;
		}
		return helper(preorder, start + 1, bigger - 1) && helper(preorder, bigger, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyPreorderSequenceinBST result = new VerifyPreorderSequenceinBST();
		System.out.println(result.verifyPreorderSequenceinBST(new int[] {30, 20, 10, 15, 25, 23, 22, 27, 28, 40, 35, 26}));
		System.out.println(result.verifyPreorderSequenceinBST(new int[] {4, 2, 3, 1}));
		System.out.println(result.verifyPreorderSequenceinBSTI(new int[] {30, 20, 10, 15, 25, 23, 22, 27, 28, 40, 35}));
		System.out.println(result.verifyPreorderSequenceinBSTII(new int[] {30, 20, 10, 15, 25, 23, 22, 27, 28, 40, 35}));
	}

}
