import java.util.LinkedList;
import java.util.Queue;

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
