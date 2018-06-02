import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently 
 * occurred element) in the given BST.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
		   1
		    \
		     2
		    /
		   2
 * return [2].
 * Note: If a tree has more than one mode, you can return them in any order.
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space 
 * incurred due to recursion does not count).
 * @author wendi
 *
 */
public class FindModeinBinarySearchTree {
	
	
	/**
	 * Inorder Traverse
	 * Traverse the tree in in-order and keep track of the current list of modes (among other things).
	 * @param TreeNode root
	 * @return int[]
	 * Time: O(n)
	 * Space: O(n)
	 */
	private int maxCnt;
	private int currCnt;
	private int currVal;
	public int[] findModeinBinarySearchTree(TreeNode root) {
		if (root == null) return new int[0];
		maxCnt = 0;
		currCnt = 0;
		currVal = -1;
		List<Integer> list = new ArrayList<>();
		helper(root, list);
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) res[i] = list.get(i);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> list) {
		if (root == null) return;
		helper(root.left, list);
		if (root.val == currVal) {
			currCnt++;
		}
		else {
			currVal = root.val;
			currCnt = 1;
		}
		if (currCnt == maxCnt) {
			list.add(currVal);
		}
		else if (currCnt > maxCnt) {
			list.clear();
			list.add(currVal);
			maxCnt = currCnt;
		}
		helper(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindModeinBinarySearchTree result = new FindModeinBinarySearchTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 1, 2});
		System.out.println(Arrays.toString(result.findModeinBinarySearchTree(root)));
	}

}
