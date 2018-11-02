/**
 * Given a binary tree
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
 * Populate each next pointer to point to its next right node. If there is no next right node, the 
 * next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every 
 * parent has two children).
 * For example,
 * Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
 * After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */

public class PopulatingNextRightPointersinEachNode {

	/**
	 * Method2: DFS(Recursion: Preorder): Since it's a perfect binary tree, 
	 * root.left.next = root.right, root.right.next = root.next.left.
	 * @param TreeLinkNode root
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public void populatingNextRightPointersinEachNodeI(TreeLinkNode root) {
		if (root == null) return;
		helper(root);
		return;
	}
	
	private void helper(TreeLinkNode root) {
		if (root == null) return;
		if (root.left != null) {
			root.left.next = root.right;
			root.right.next = root.next != null ? root.next.left : null;

		}
		helper(root.left);
		helper(root.right);
	}
	
	
	/**
	 * Method1: BFS: Use nextRoot to record the head of next level. 
	 * When curr root populate next node, set currRoot=currRoot.next to populate curr level.
	 * @param TreeNode root
	 * Time: O(n)
	 * Space: O(1)
	 */ 
	public void populatingNextRightPointersinEachNode(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode nextRoot = null;
		while (root.left != null) {
			nextRoot = root.left;
			while (root != null) {
				root.left.next = root.right;
				root.right.next = root.next != null? root.next.left : null;
				root = root.next;
			}
			root = nextRoot;
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersinEachNode result = new PopulatingNextRightPointersinEachNode();
		TreeLinkNode root = TreeLinkNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6, 7});
		TreeLinkNode.printCBT(root);
//		result.populatingNextRightPointersinEachNode(root);
		result.populatingNextRightPointersinEachNodeI(root);
	}

}


