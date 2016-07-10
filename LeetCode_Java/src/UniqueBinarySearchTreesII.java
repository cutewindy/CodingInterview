import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
 * 
 * Tags: Tree, DP
 * @author wendi
 *
 */
public class UniqueBinarySearchTreesII {

	
	/**
	 * Divide and Conquer:  F(i) = G(i-1) * G(n-i)
	 * pick i-th node as my root, the left subtree will contain elements 1 to (i-1), 
	 * and the right subtree will contain elements (i+1) to n. I use recursive calls to get back 
	 * all possible trees for left and right subtrees and combine them in all possible ways with the root.
	 * @param int n
	 * @return List<TreeNode>
	 * Time: O(n^n)
	 * Space: O(n)
	 */
	public List<TreeNode> uniqueBinarySearchTreeII(int n) {
		List<TreeNode> result = new ArrayList();
		if (n == 0) {
			return result;
		}
		return helper(1, n);
	}
	
	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> result = new ArrayList();
		if (start > end) {
			result.add(null); // be care
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftRoots = helper(start, i - 1);
			List<TreeNode> rightRoots = helper(i + 1, end);
			// F(i) = G(i-1) * G(n-i)
			for (TreeNode leftRoot: leftRoots) {
				for (TreeNode rightRoot: rightRoots) {
					TreeNode root = new TreeNode(i);
					root.left = leftRoot;
					root.right = rightRoot;
					result.add(root);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII result = new UniqueBinarySearchTreesII();
		List<TreeNode> list = result.uniqueBinarySearchTreeII(3);
		for (TreeNode node: list) {
			TreeNode.printCBT(node);
		}
	}

}
