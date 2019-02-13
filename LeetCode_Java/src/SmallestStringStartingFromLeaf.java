/**
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 * Example 1:
 * Input: [0,1,2,3,4,3,4]
 *         d
 *       /   \
 *      b     c 
 *     / \   / \
 *    d   e d   e
 * Output: "dba"
 * Example 2:
 * Input: [25,1,3,1,3,0,2]
 *         z
 *       /   \
 *      b     d 
 *     / \   / \
 *    b   d a   c
 * Output: "adz"
 * Example 3:
 * Input: [2,2,1,null,1,0,null,0]
 *         c
 *       /   \
 *      c     b 
 *       \   /  
 *        b a   
 *       /
 *      a
 * Output: "abc"
 * @author wendi
 *
 */
public class SmallestStringStartingFromLeaf {

	/**
	 * DFS Postorder traversal
	 * @param TreeNoderoot
	 * @return String
	 * Time: O(n^2)
	 * Space: O(log(n))
	 */
	public String smallestStringStartingFromLeaf(TreeNode root) {
		if (root == null) return "";
		String left = smallestStringStartingFromLeaf(root.left);
		String right = smallestStringStartingFromLeaf(root.right);
		String curr = Character.toString((char) ('a' + root.val));
		if (left.equals("")) return right + curr;
		if (right.equals("")) return left + curr;
		return left.compareTo(right) < 0 ? left + curr : right + curr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestStringStartingFromLeaf result = new SmallestStringStartingFromLeaf();
		TreeNode root = TreeNode.generateCBT(new int[] {0,1,2,3,4,3,4});
		TreeNode.printCBT(root);
		System.out.println(result.smallestStringStartingFromLeaf(root));
	}

}
