import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are 
 * closest to the target.
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * Hint:
 * 1. Consider implement these two helper functions:
 *    getPredecessor(N), which returns the next smaller node to N.
 *    getSuccessor(N), which returns the next larger node to N.
 * 2. Try to assume that each node has a parent pointer, it makes the problem much easier.
 * 3. Without parent pointer we just need to keep track of the path from the root to the current 
 * 	  node using a stack.
 * 4. You would need two stacks to track the path in finding predecessor and successor node separately.
 * 
 * Tags: Tree, Stack
 * @author wendi
 *
 */
public class ClosestBinarySearchTreeValueII {
	
	
	/**
	 * Method2: Following the hint, use a predecessor stack and successor stack. 
 	 * 1. Do a log(n) traversal to initialize them until reach the null node. 
 	 * 2. Use the getPredecessor and getSuccessor method to pop k closest nodes and update the stacks.
Time complexity is O(klogn), since k BST traversals are needed and each is bounded by O(logn) time. 
Note that it is not O(logn + k) which is the time complexity for k closest numbers in a linear array.
	 * @param TreeNode root, double target, int k
	 * @return List<Integer>
	 * Time: O(n)
	 * Space: O(n)
	 */
	public List<Integer> closestBinarySearchTreeValueIII(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if (root == null || k == 0) {
			return result;
		}
		// 1 init
		Stack<TreeNode> pred = new Stack<>();   // save the node smaller than target in ascending order
		Stack<TreeNode> succ = new Stack<>();   // save the node large than target in descending order
		TreeNode curr = root;
		while (curr != null) {
			if (curr.val < target) {
				pred.push(curr);
				curr = curr.right;
			}
			else {
				succ.push(curr);
				curr = curr.left;
			}
		}
		// 2 find the closest num
		while (k-- > 0) { 
			if (pred.isEmpty() && succ.isEmpty()) {
				break;
			}
			else if (pred.isEmpty()) {
				result.add(getSuccessor(succ));
			}
			else if (succ.isEmpty()) {
				result.add(getPredecessor(pred));
			}
			else if ((target - pred.peek().val) < (succ.peek().val - target)) {
				result.add(getPredecessor(pred));
			}
			else {
				result.add(getSuccessor(succ));
			}
		}
		return result;
	}
	
	// get next smaller node.
	private int getPredecessor(Stack<TreeNode> pred) {  
		TreeNode node = pred.pop();
		TreeNode predNode = node.left;
		while (predNode != null) {
			pred.push(predNode);
			predNode = predNode.right;
		}
		return node.val;
	}
	
	// get next large node.
	private int getSuccessor(Stack<TreeNode> succ) {
		TreeNode node = succ.pop();
		TreeNode succNode = node.right;
		while (succNode != null) {
			succ.push(succNode);
			succNode = succNode.left;
		}
		return node.val;
	}
	
	/**
	 * Method1: Brute Force, two stacks
	 * Idea: use two stacks to track the predecessors and successors, then like what we do in merge 
	 * sort, we compare and pick the closest one to the target and put it to the result list.
	 * @param TreeNode root, double target, int k
	 * @return List<Integer>
	 * Time: O(2n + k)
	 * Space: O(2n)
	 */
	public List<Integer> closestBinarySearchTreeValueII(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if (root == null || k == 0) {
			return result;
		}
		// 1 traverses tree in inorder.
		List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			inorder.add(root.val);
			root = root.right;
		}
		// 2 save num <= target in small stack and num > target in large stack.
		Stack<Integer> small = new Stack<>();
		Stack<Integer> large = new Stack<>();
		for (int i = 0; i < inorder.size(); i++) {
			if( inorder.get(i) > target) {
				break;
			}
			small.push(inorder.get(i));
		}
		for (int i = inorder.size() - 1; i >= 0; i--) {
			if (inorder.get(i) <= target) {
				break;
			}
			large.push(inorder.get(i));
		}
		// 3 compare stack.peek() and queue.peek(), pop the closest num.
		while (k-- > 0) {
			if (small.isEmpty() && large.isEmpty()) {
				break;
			}
			else if (small.isEmpty()) {
				result.add(large.pop());
			}
			else if (large.isEmpty()) {
				result.add(small.pop());
			}
			else if ((target - small.peek()) < (large.peek() - target)) {
				result.add(small.pop());
			}
			else {
				result.add(large.pop());
			}
		}
		return result;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestBinarySearchTreeValueII result = new ClosestBinarySearchTreeValueII();
		TreeNode root = TreeNode.generateCBT(new int[] {30, 20, 40, 8, 25, 35, 45, 6, 15});
		TreeNode.printCBT(root);
		System.out.println(result.closestBinarySearchTreeValueII(root, 18.6, 4));	
		TreeNode root1 = TreeNode.generateCBT(new int[] {30, 20, 40, 8, 25, 35, 45, 6, 15});
		TreeNode.printCBT(root1);
		System.out.println(result.closestBinarySearchTreeValueIII(root1, 18.6, 4));
	}

}
