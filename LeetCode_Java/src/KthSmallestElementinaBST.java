import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element 
 * in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth 
 * smallest frequently? How would you optimize the kthSmallest routine?

 * Hint:
 * 1 Try to utilize the property of a BST.
 * 2 What if you could modify the BST node's structure?
 * 3 The optimal runtime complexity is O(height of BST).
 * 
 * Tags: BinarySearch, Tree
 * @author wendi
 *
 */
public class KthSmallestElementinaBST {

	/**
	 * Method2: BinarySearch DFS recursion: If left nodes number = k-1, then root is the kth node.
	 * If left nodes number > k-1, then the kth node on the left. Otherwise, the kth node on the right.
	 * @param TreeNode root, int k
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int kthSmallestElementinaBSTI(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		return helper(root, k);
	}
	
	private int helper(TreeNode root, int k) {
		int leftNodes = countNodes(root.left);
		if (leftNodes == k - 1) {
			return root.val;
		}
		else if (leftNodes > k - 1) {
			return helper(root.left, k);
		}
		else {
			return helper(root.right, k - leftNodes - 1);
		}
	}
	
	private int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	/**
	 * Method1: DFS in-order iterative: use a stack to find the kth smallest node by the ascending order of number.
	 * @param TreeNode root, int k
	 * @return int
	 * Time: O()
	 * Space: O()
	 */
	public int kthSmallestElementinaBST(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (node != null || !stack.isEmpty()) {
			if (node != null) {     // when the 
				stack.push(node);
				node = node.left;
			}
			else {
				node = stack.pop();
				k--;
				if (k == 0) {
					return node.val;
				}
				node = node.right;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestElementinaBST result = new KthSmallestElementinaBST();
		TreeNode root = TreeNode.generateCBT(new int[] {11, 7, 15, 5, 8, 12, 16 , 2, 6});
		TreeNode.printCBT(root);
//		System.out.println(result.kthSmallestElementinaBST(root, 5));
		System.out.println(result.kthSmallestElementinaBSTI(root, 5));
	}

}
