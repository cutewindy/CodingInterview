import java.util.ArrayList;
import java.util.List;


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public static TreeNode generateCBT(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		List<TreeNode> q = new ArrayList<>();
		q.add(root);
		for (int i = 1; i < array.length; i++) {
			TreeNode node = q.remove(0);
			node.left = new TreeNode(array[i]);
			q.add(node.left);
			if (i + 1 < array.length) {
				node.right = new TreeNode(array[i + 1]);
				q.add(node.right);
				i++;
			}
		}
		return root;
	}
	
	public static void printCBT(TreeNode root) {
		PrettyPrintBinaryTree.print(root);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = TreeNode.generateCBT(array);
		TreeNode.printCBT(root);
	}

}
