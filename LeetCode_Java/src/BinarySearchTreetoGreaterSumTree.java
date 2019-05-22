import java.util.Stack;

/**
 * Given the root of a binary search tree with distinct values, modify it so that every node has a 
 * new value equal to the sum of the values of the original tree that are greater than or equal to 
 * node.val.
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *                     4 (30)
 *                  /      \
 *                1 (36)     6 (21)
 *              /   \       /  \
 *           0(36)  2(35) 5(26) 7(15)
 *                   \           \
 *                   3(33)        8(8)  
 * 
 * Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * Note:
 * 1. The number of nodes in the tree is between 1 and 100.
 * 2. Each node will have value between 0 and 100.
 * 3. The given tree is a binary search tree.
 * @author wendi
 *
 */
public class BinarySearchTreetoGreaterSumTree {
	
	
	
	/**
	 * Approach2: DFS, reverse in-order traversal
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public TreeNode binarySearchTreetoGreaterSumTreeI(TreeNode root) {
    	if (root == null) return root;
    	int[] sum = new int[1];
    	dfs(root, sum);
    	return root;
    }
    
    private void dfs(TreeNode root, int[] sum) {
    	if (root == null) return;
    	dfs(root.right, sum);
    	sum[0] += root.val;
    	root.val = sum[0];
    	dfs(root.left, sum);
    }
	
    
    
	
	/**
	 * Approach1: Stack, reverse in-order traversal
	 * @param TreeNode root
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
    public TreeNode binarySearchTreetoGreaterSumTree(TreeNode root) {
        TreeNode inputRoot = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nodes = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodes.push(root);
            root = root.right;
        }
        int sum = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            sum += node.val;
            node.val = sum;
        }
        return inputRoot;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTreetoGreaterSumTree result = new BinarySearchTreetoGreaterSumTree();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 1, 6, 0, 2, 5, 7, 0, 0, 0, 3, 0, 0, 0 ,8});
		TreeNode.printCBT(root);
		TreeNode.printCBT(result.binarySearchTreetoGreaterSumTree(root));
		TreeNode.printCBT(result.binarySearchTreetoGreaterSumTreeI(root));
	}

}
