import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1:
 * Input:
		    2
		   / \
		  1   3
 * Output:
 * 1
 * Example 2: 
 * Input:
	        1
	       / \
	      2   3
	     /   / \
	    4   5   6
	       /
	      7
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * @author wendi
 *
 */
public class FindBottomLeftTreeValue {
	
	
	/**
	 * BFS: level order traverse
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
	public int findBottomLeftTreeValue(TreeNode root) {
		if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peek().val;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindBottomLeftTreeValue result = new FindBottomLeftTreeValue();
		TreeNode root = TreeNode.generateCBT(new int[] {2, 1, 3});
		System.out.println(result.findBottomLeftTreeValue(root));
	}

}
