import java.util.ArrayList;


public class TreeNode {
	
	
	public int val;
	public TreeNode left, right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public static TreeNode arraytoBinaryTree(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		//convert array to node
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int i = 0; i < array.length; i++) {
			nodeList.add(new TreeNode(array[i]));
		}
		
		//create root
		for (int i = 0; i < array.length / 2 - 1; i++) {
			if (nodeList.get(i * 2 + 1).val != -1) {
				nodeList.get(i).left = nodeList.get(i * 2 + 1);
			}
			if (nodeList.get(i * 2 + 2).val != -1) {
				nodeList.get(i).right = nodeList.get(i * 2 + 2);
			}			

		}
		//create may be have right
		if (nodeList.get((array.length / 2 - 1) * 2 + 1).val != -1) {
			nodeList.get(array.length / 2 - 1).left = 
					nodeList.get((array.length / 2 - 1) * 2 + 1);
		}
		if (array.length % 2 != 0 && nodeList.get((array.length / 2 - 1) * 2 + 2).val != -1) {               //if odd, have right
			nodeList.get(array.length / 2 - 1).right = 
				nodeList.get((array.length / 2 - 1) * 2 + 2);
		}
		return nodeList.get(0);
	}

	
	public static TreeNode buildBinaryTree() {
		//     1
		//    / \
		//   2   3
		//  / \
		// 4   5
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		return n1;
	}
	
	public static void showPreorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		showPreorder(root.left);
		showPreorder(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode result1 = buildBinaryTree();
//		showPreorder(result1);
		
		
//		int[] array = {1, 2, 3, 4, 5};
		//        1
		//       / \
		//      2   3
		//     / \
		//    4   5
		
		int[] array = {1, 2, 3, -1, -1, 4, 5};
		//        1
		//       / \
		//      2   3
		//         / \
		//        4   5
		

		TreeNode result2 = arraytoBinaryTree(array);
		showPreorder(result2);
	}

}
