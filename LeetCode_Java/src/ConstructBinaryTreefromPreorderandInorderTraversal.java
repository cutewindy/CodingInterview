import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * Tags: Tree, Array, DFS
 * @author wendi
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * DFS(Recursion) First element of preorder is the root of subtree. First element of inorder is the 
	 * left most element of the subtree. 
	 * Find the same element of preorder[preIndex] in inorder traversal as root, it's inorder[inIndex].
	 * Then left part is [inStart, inIndex-1], right part is [inIndex+1, inEnd].
	 * Next left root is preorder[preIndex+1], right root is preorder[preIndex+inIndex-inStart+1]
	 * inIndex - inStart + 1 is the number of left nodes 
	 * @param int[] preorder, int[] inorder
	 * @return TreeNode
	 * Time: O(n)   // use a hashmap save inorder [value, index] pair to improve T to O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode constructBinaryTreefromPreorderandInorderTraversal(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 ||
				preorder.length != inorder.length) { 
			return null;
		}
        Map<Integer, Integer> map = new HashMap<>(); // [val, index in inorder]
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, new int[1], inorder, 0, inorder.length - 1, map);
    }
    
    private TreeNode dfs(int[] preorder, int[] index, int[] inorder, int s, int e, Map<Integer, Integer> map) {
        if (index[0] == preorder.length || s > e) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        int pos = map.get(root.val);
        root.left = dfs(preorder, index, inorder, s, pos - 1, map);
        root.right = dfs(preorder, index, inorder, pos + 1, e, map);
        return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromPreorderandInorderTraversal result = new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[] preorder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
		int[] inorder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
		TreeNode.printCBT(result.constructBinaryTreefromPreorderandInorderTraversal(preorder, inorder));
	}

}
