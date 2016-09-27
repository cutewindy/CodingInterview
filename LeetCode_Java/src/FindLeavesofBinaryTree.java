import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all 
 * leaves, repeat until the tree is empty.
 * Example:
 * Given binary tree 
		          1
		         / \
		        2   3
		       / \     
		      4   5    
 * Returns [4, 5, 3], [2], [1].
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
		          1
		         / 
		        2          
 * 2. Now removing the leaf [2] would result in this tree: 1          
 * 3. Now removing the leaf [1] would result in the empty tree: []         
 * Returns [4, 5, 3], [2], [1].
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class FindLeavesofBinaryTree {
	
	/**
	 * Backtracking: using level
	 * Ideas: find the height of each node. Here the definition of height is:
	 * The height of a node is the number of edges from the node to the deepest leaf.
	 * @param TreeNode root
	 * @return List<List<Integer>>
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public List<List<Integer>> findLeavesofBinaryTree(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(root, result);
		return result;
	}
	
	private int helper(TreeNode root, List<List<Integer>> result) {
		if (root == null) {
			return -1;
		}
		int level = Math.max(helper(root.left, result), helper(root.right, result)) + 1;
		if (result.size() < level + 1) {
			result.add(new ArrayList<Integer>());   // before add root.val into list, check whether exist the list in result
		}
		result.get(level).add(root.val);
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindLeavesofBinaryTree result = new FindLeavesofBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5});
		TreeNode.printCBT(root);
		System.out.println(result.findLeavesofBinaryTree(root));
	}

}
