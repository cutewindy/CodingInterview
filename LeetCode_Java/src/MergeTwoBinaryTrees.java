/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes 
 * of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then 
 * sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used 
 * as the node of new tree.
 * Example 1:
 * Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
 * Output: 
 * Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 * @author wendi
 *
 */
public class MergeTwoBinaryTrees {

	/**
	 * Recursive
	 * @param TreeNode t1, TreeNode t2
	 * @return TreeNode
	 * Time: O(m + n)
	 * Space: O()
	 */
	public TreeNode mergeTwoBinaryTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t1 == null) {return null;}
		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode node = new TreeNode(val);
		node.left = mergeTwoBinaryTrees(t1 == null? null : t1.left, t2 == null ? null : t2.left);
		node.right = mergeTwoBinaryTrees(t1 == null? null : t1.right, t2 == null ? null : t2.right);
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoBinaryTrees result = new MergeTwoBinaryTrees();
		TreeNode t1 = TreeNode.generateCBT(new int[]{1, 3, 2, 5});
		TreeNode t2 = TreeNode.generateCBT(new int[]{2, 1, 3});
		TreeNode.printCBT(t1);
		TreeNode.printCBT(t2);
		TreeNode.printCBT(result.mergeTwoBinaryTrees(t1, t2));
	}

}
