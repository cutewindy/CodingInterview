import java.util.Stack;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value 
 * between L and R (inclusive).
The binary search tree is guaranteed to have unique values.
Example 1:
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
Note:
1. The number of nodes in the tree is at most 10000.
2. The final answer is guaranteed to be less than 2^31.
 * @author wendi
 *
 */
public class RangeSumofBST {
	
	/**
	 * Approach2: dfs recursion
	 * @param TreeNode root, int L, int R
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 * Stack Space: O(log(n))
	 */
    public int rangeSumofBSTI(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val > R) return rangeSumofBSTI(root.left, L, R);
        if (root.val < L) return rangeSumofBSTI(root.right, L, R);
        return rangeSumofBSTI(root.left, L, R) + root.val + rangeSumofBSTI(root.right, L, R);    	
    }
	
	
	
	/**
	 * Approach1: dfs iteration + stack
	 * @param TreeNode root, int L, int R
	 * @return int
	 * Time: O(n)
	 * Space: O(log(n))
	 */
    public int rangeSumofBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val >= L) {
                stack.push(curr);
                if (curr.val == L) break;
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res += curr.val;
            if (curr.val == R) break;
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RangeSumofBST result = new RangeSumofBST();
		TreeNode root = TreeNode.generateCBT(new int[] {10, 5, 15, 3, 7, 0, 18});
		TreeNode.printCBT(root);
		System.out.println(result.rangeSumofBST(root, 7, 15));
		System.out.println(result.rangeSumofBSTI(root, 7, 15));
	}

}
