package IBM;
import java.util.LinkedList;
import java.util.Queue;

import data_structure.TreeNode;
/**
 * find binary tree min depth
follow up是不用recursion做
 * @author wendi
 *
 */
public class MinimumDepthofBinaryTree {
	
	/**
	 * Approach2: bfs 
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int minDepthI(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) return level;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return level;
    }
	
    
	/**
	 * Approach1: dfs 
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        return Math.min(left, right) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
