/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
 * After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL
 *
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * BFS: (Use two pointers): DummyHead of next level and preNode.
	 * DummyHead is the dummy head of next level, need to set dummyHead.next = null after populate 
	 * next level.
	 * preNode is the parent of the currNode, that is, preNode.next = currNode
	 * @param TreeLinkNode root
	 * Time: O(n)
	 * Space: O(1)
	 */
	public void populatingNextRightPointersinEachNodeII(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode prev = dummy;
		while (root != null) {
			while (root != null) {
				if (root.left != null) {
					prev.next = root.left;
					prev = prev.next;
				}
				if (root.right != null) {
					prev.next = root.right;
					prev = prev.next;
				}
				root = root.next;  // move to next node
			}
			// move to next level
			root = dummy.next;
			dummy.next = null;
			prev = dummy;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersinEachNodeII result = new PopulatingNextRightPointersinEachNodeII();
		TreeLinkNode root = TreeLinkNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeLinkNode.printCBT(root);	
		result.populatingNextRightPointersinEachNodeII(root);
	}

}
