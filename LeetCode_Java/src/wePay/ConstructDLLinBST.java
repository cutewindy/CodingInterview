package wePay;
import data_structure.TreeNode;

/**
 * 
 * @author wendi
 *
 */
public class ConstructDLLinBST {

	class Node {
		int val;
		Node prev;
		Node next;
		public Node(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}
	
	public Node constructDLLinBST(TreeNode root, int target) {
		if (root == null) return null;
		Node dummy = new Node(0);
		dfs(root, dummy, target, new boolean[1]);
		return dummy.next;
	}
	
	private void dfs(TreeNode root, Node prev, int target, boolean[] found) {
		if (root == null) return;
		Node curr = new Node(root.val);
		curr.prev = prev;
		prev.next = curr;
		if (root.val == target) {
			found[0] = true;
			return;
		}
		if (root.val > target) dfs(root.left, curr, target, found);
		else dfs(root.right, curr, target, found);
		if (!found[0]) {
			curr.prev = null;
			prev.next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructDLLinBST result = new ConstructDLLinBST();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 2, 6, 1, 3, 5});
		TreeNode.printCBT(root);
		Node res = result.constructDLLinBST(root, 3);
		if (res == null) System.out.println("null");
		else {
			while (res != null) {
				System.out.println(res.val);
				res = res.next;
			}
		}		

	}

}
