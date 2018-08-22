import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a 
 * tree is the maximum width among all levels. The binary tree has the same structure as a full 
 * binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right 
 * most non-null nodes in the level, where the null nodes between the end-nodes are also counted 
 * into the length calculation.
 * Example 1:
 * Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * Input: 
          1
         /  
        3    
       / \       
      5   3     
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * Input: 
          1
         / \
        3   2 
       /        
      5      
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * Input: 
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,
 * null,null,null,7).
 * Note: Answer will in the range of 32-bit signed integer.
 * @author wendi
 *
 */
public class MaximumWidthofBinaryTree {
	

	/**
	 * BFS
	 * traverse all the node in the tree in level order(Here I use one Queue to store each level's 
	 * nodes and positions. The time I traverse each level is the queue's size(the number of nodes from 
	 * upper level)). If the position of the parent node is 'n', then the left child is '2 * n' and 
	 * the right child is '2 * n + 1'. The width of each level is the last node's position in this 
	 * level subtracts the first node's position in this level plus 1.
	 * Without new a new class, we can use HashMap instead.
	 * @param TreeNode root
	 * @return int
	 * Time: O(n)
	 * Space: O(n)
	 */
    public int maximumWidthofBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().index, end = queue.peek().index;
            while (size-- > 0) {
                Node curr = queue.poll();
                end = curr.index;
                if (curr.node.left != null) queue.offer(new Node(curr.node.left, curr.index * 2));
                if (curr.node.right != null) queue.offer(new Node(curr.node.right, curr.index * 2 + 1));
            }
            res = Math.max(end - start + 1, res);
        }
        return res;
    }
    
    class Node {
        TreeNode node;
        int index;
        public Node(TreeNode node, int i) {
            this.node = node;
            this.index = i;
        }
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumWidthofBinaryTree result = new MaximumWidthofBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 3, 2, 5});
		TreeNode.printCBT(root);
		System.out.println(result.maximumWidthofBinaryTree(root));
	}

}
