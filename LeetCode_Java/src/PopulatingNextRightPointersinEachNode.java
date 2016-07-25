import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next
 *  pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
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

/**
 * Class of TreeLinkNode
 * @author wendi
 *
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	TreeLinkNode(int val) {
		this.val = val;
		this.left = null;
		this.right =null;
		this.next = null;
	}
	// generate CBT by BFS
	public static TreeLinkNode generateCBT(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		TreeLinkNode root = new TreeLinkNode(array[0]);
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		int index = 1;
		while (index < array.length) {
			TreeLinkNode curr = queue.poll();
			curr.left = new TreeLinkNode(array[index]);
			queue.offer(curr.left);
			index++;
			if (index < array.length) {
				curr.right = new TreeLinkNode(array[index]);
				queue.offer(curr.right);
				index++;
			}
		}
		return root;
	}
	
	public static void printCBT(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode curr = queue.poll();
				System.out.print(curr.val);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			System.out.println("\n----------");
		}
	}
	
}



public class PopulatingNextRightPointersinEachNode {

	/**
	 * DFS(Recursion: Inorder): Since it's a perfect binary tree, root.left.next = root.right, root.right.next = root.next.left.
	 * @param TreeLinkNode root
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public void populatingNextRightPointersinEachNodeI(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		helper(root);
		return;
	}
	
	private void helper(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}
		helper(root.left);
		helper(root.right);
	}
	
	/**
	 * BFS: Use nextRoot to record the head of next level. When curr root populate next node, set currRoot=currRoot.next to
	 * populate curr level.
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


