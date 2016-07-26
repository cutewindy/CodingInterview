import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a 
 * number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
	    1
	   / \
	  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 * Tags: Tree, DFS
 * @author wendi
 *
 */
public class SumRoottoLeafNumbers {
	class Pair {
		TreeNode node;
		int sum;
		Pair(TreeNode node, int sum) {
			this.node = node;
			this.sum = sum;
		}
	}	
	
	/**
	 * Method3: BFS(Template)
	 * Pair.node means curr node, pair.sum means the path sum that parents given(exclude curr.node.val).
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int sumRoottoLeafNumbersII(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int total = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, 0));
		while (!queue.isEmpty()) {
			Pair curr = queue.poll();
			if (curr.node.left == null && curr.node.right == null) {
				total += curr.sum * 10 + curr.node.val;
			}
			if (curr.node.left != null) {
				queue.offer(new Pair(curr.node.left, curr.sum * 10 + curr.node.val));
			}
			if (curr.node.right != null) {
				queue.offer(new Pair(curr.node.right, curr.sum * 10 + curr.node.val));
			}
		}
		return total;
	}

	/**
	 * Method2: DFS(Iteration: Preorder)(Template). 
	 * Pair.node means curr node, pair.sum means the path sum that parents given(exclude curr.node.val).
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int sumRoottoLeafNumbersI(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 0));
		int total = 0;
		while (!stack.isEmpty()) {
			Pair curr = stack.pop();
			if (curr.node.left == null && curr.node.right == null) {  // if it's leaf, add sum to total
				total += curr.sum * 10 + curr.node.val;
			}
			if (curr.node.right != null) {
				stack.push(new Pair(curr.node.right, curr.sum * 10 + curr.node.val));
			}
			if (curr.node.left != null) {
				stack.push(new Pair(curr.node.left, curr.sum * 10 + curr.node.val));
			}	
		}
		return total;
	}
	
	/**
	 * Method1: DFS(Recursion):the sum of curr node is left sum + right sum. 
	 * Need to give children curr path sum, is sum * 10 + curr.val.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int sumRoottoLeafNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, 0);
	}
	
	private int helper(TreeNode root, int sum) {
		// Basecase
		if (root.left == null && root.right == null) {
			return 10 * sum + root.val; // leaf node, return result
		}
		if (root.left == null) {
			return helper(root.right, sum * 10 + root.val);
		}
		if (root.right == null) {
			return helper(root.left, sum * 10 + root.val);
		}
		// condition
		return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRoottoLeafNumbers result = new SumRoottoLeafNumbers();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
//		System.out.println(result.sumRoottoLeafNumbers(root));
//		System.out.println(result.sumRoottoLeafNumbersI(root));
		System.out.println(result.sumRoottoLeafNumbersII(root));
	}

}
