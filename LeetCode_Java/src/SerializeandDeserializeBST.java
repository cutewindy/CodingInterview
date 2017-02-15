import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so 
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on 
 * how your serialization/deserialization algorithm should work. You just need to ensure that a binary 
 * search tree can be serialized to a string and this string can be deserialized to the original tree 
 * structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and 
 * deserialize algorithms should be stateless.
 * 
 * Tags: Tree
 * @author wendi
 *
 */
public class SerializeandDeserializeBST {
	
	/**
	 * DFS(Iteration) (Preorder template)
	 * @param TreeNode root
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder result = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			result.append(curr.val).append(",");
			if (curr.right != null) stack.push(curr.right);
			if (curr.left != null) stack.push(curr.left);
		} 
		return result.toString().substring(0, result.length() - 1);
	}

	/**
	 * DFS(Recursion): using the feature of BST.
	 * There is a min node and max node for each level: min.val < curr.val < max.val.
	 * Then update the min node and max for next level, for left, max = root, for right, min = root.
	 * @param String data
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] dataArray = data.split(",");
        return helper(dataArray, new int[1], null, null);
    }
    
    public TreeNode helper(String[] dataArray, int[] pos, TreeNode min, TreeNode max) {
    	if (pos[0] > dataArray.length - 1 
    	 || min != null && Integer.parseInt(dataArray[pos[0]]) <= min.val 
    	 || max != null && Integer.parseInt(dataArray[pos[0]]) >= max.val) {
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.parseInt(dataArray[pos[0]]));
    	pos[0] += 1;
    	root.left = helper(dataArray, pos, min, root);
    	root.right = helper(dataArray, pos, root, max);
    	return root;	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeandDeserializeBST result = new SerializeandDeserializeBST();
		TreeNode root = TreeNode.generateCBT(new int[] {4, 2, 6, 1, 3, 5});
		TreeNode.printCBT(root);
		String data = result.serialize(root);
		System.out.println("serialize: " + data);
		TreeNode newRoot = result.deserialize(data);
		System.out.println("deserialize: ");
		TreeNode.printCBT(newRoot);
	}

}
