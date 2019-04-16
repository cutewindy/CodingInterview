import java.util.Stack;

/**
 * We run a preorder depth first search on the root of a binary tree.
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we 
 * output the value of this node.  (If the depth of a node is D, the depth of its immediate child is 
 * D+1.  The depth of the root node is 0.)
 * If a node has only one child, that child is guaranteed to be the left child.
 * Given the output S of this traversal, recover the tree and return its root.
 * Example 1:
 *           1
 *         /   \
 *        2     5
 *       / \   / \
 *      3   4 6   7
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * Example 2:
 *               1
 *            /      \
 *           2        5
 *          /        /
 *         3       6
 *        /       /
 *       4       7
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 * Example 3:
 *             1
 *            / 
 *           401
 *          /  \ 
 *        349   88
 *       /
 *     90
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 * Note:
 * 1. The number of nodes in the original tree is between 1 and 1000. 
 * 2. Each node will have a value between 1 and 10^9.
 * @author wendi
 *
 */
public class RecoveraTreeFromPreorderTraversal {
	
	
	/**
	 * Approach2: Stack
	 * @param String S
	 * @return TreeNode
	 * Time: O(s) s = S.length()
	 * Space: O(n) n = num of nodes
	 */
    public TreeNode recoveraTreeFromPreorderTraversalI(String S) {
        if (S == null || S.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        for (int i = 0; i < S.length();) {
            int level = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                level++;
                i++;
            }
            while (level < stack.size()) stack.pop();
            int val = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                val = val * 10 + S.charAt(i) - '0';
                i++;
            }
            TreeNode node = new TreeNode(val);
            if (level == 0) {
                root = node;
                stack.push(node);
                continue;
            }
            if (stack.peek().left == null) stack.peek().left = node;
            else stack.peek().right = node;
            stack.push(node);
        }
        return root;   	
    }
	
	
	/**
	 * Approach1: DFS(bottom_up)
	 * @param String S
	 * @return TreeNode
	 * Time: O(n)  n = num of nodes
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    public TreeNode recoveraTreeFromPreorderTraversal(String S) {
        if (S == null || S.length() == 0) return null;
        return dfs(S, new int[1], 0);
    }
    
    private TreeNode dfs(String S, int[] index, int level) {
        if (index[0] == S.length()) return null;
        int cont = 0;
        while (index[0] < S.length() && S.charAt(index[0]) == '-') {
            cont++;
            index[0]++;
        }
        if (cont != level) {
        	index[0] -= cont;
            return null;
        }
        int val = 0;
        while (index[0] < S.length() && S.charAt(index[0]) != '-') {
            val = val * 10 + S.charAt(index[0]++) - '0';
        }
        TreeNode root = new TreeNode(val);
        root.left = dfs(S, index, level + 1);
        root.right = dfs(S, index, level + 1);
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoveraTreeFromPreorderTraversal result = new RecoveraTreeFromPreorderTraversal();
		TreeNode.printCBT(result.recoveraTreeFromPreorderTraversal("1-401--349---90--88"));
		TreeNode.printCBT(result.recoveraTreeFromPreorderTraversalI("1-401--349---90--88"));
	}

}
