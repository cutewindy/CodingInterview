package wePay;
import data_structure.TreeNode;
/**
 * 给一个binary tree 和一个target node,construct root到target的双向链表比如
 * input tree t: 1,2,3,4,5,null,null target: 5 要求返回root 1到target 5的路径的doubly linked list,
 * 即1<->2<->5
 * @author wendi
 *
 */
public class ConstructDLLinBS {
	
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
	
	/**
	 * DFS top down
	 * @param TreeNode root, int target
	 * @return Node
	 * Time: O(E)
	 * Space: O(E)
	 */
	public Node constructDLLinBSI(TreeNode root, int target) {
		if (root == null) return null;
		Node dummy = new Node(0); 
		dfs(root, target, new boolean[1], dummy);
		if (dummy.next == null) return null;
		return dummy.next;
	}
	
	private void dfs(TreeNode root, int target, boolean[] found, Node prev) {
		if (root == null) return;
		Node curr = new Node(root.val);
		prev.next = curr;
		curr.prev = prev;
		if (root.val == target) {
			found[0] = true;
			return;
		}
		dfs(root.left, target, found, curr);
		if (found[0]) return;
		dfs(root.right, target, found, curr);
		if (found[0]) return;
		prev.next = null;
	}
	
	
	/**
	 * Approach1: DFS bottom up
	 * @param root
	 * @param target
	 * @return
	 */
    public Node constructDLLinBS(TreeNode root, int target) {
        if (root == null) return null;
        return dfs(root, null, target);
    }

	private Node dfs(TreeNode root, Node prev, int target) {
	        if (root == null) return null;
	        Node curr = new Node(root.val);
	        curr.prev = prev;
	        if (root.val == target) {
	                return curr;
	        }
	        Node left = dfs(root.left, curr, target);
	        if (left != null) {
	                curr.next = left;
	                return curr;
	        }
	        Node right = dfs(root.right, curr, target);
	        if (right != null) {
	                curr.next = right;
	                return curr;
	        }
	        return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructDLLinBS result = new ConstructDLLinBS();
		TreeNode root = TreeNode.generateCBT(new int[] {1,2,3,4,5});
		TreeNode.printCBT(root);
		Node res = result.constructDLLinBS(root, 5);
		if (res == null) System.out.println("null");
		else {
			while (res != null) {
				System.out.println(res.val);
				res = res.next;
			}
		}
	}

}
