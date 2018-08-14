import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so 
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how 
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary 
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following tree
	    1
	   / \
	  2   3
	     / \
	    4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do 
 * not necessarily need to follow this format, so please be creative and come up with different 
 * approaches yourself.
 * Note: Do not use class member/global/static variables to store states. Your serialize and 
 * deserialize algorithms should be stateless.
 * 
 * Tags: Tree, Design
 * @author wendi
 *
 */
public class SerializeandDeserializeBinaryTree {

	/**
	 * Method2: BFS(BFS traversal template). Using '#' to denote null node
	 * @param TreeNode root
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	// Encodes a tree to a single string.
	public String serializeI(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder data = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr != null) {
				data.append(curr.val).append(",");
				queue.offer(curr.left);
				queue.offer(curr.right);
			}
			else {
				data.append("#").append(",");
			}
		}
		return data.toString().substring(0, data.length() - 1);
	}
	
	// Decodes your encoded data to tree.
	/**
	 * Method2: Using queue to build tree
	 * @param String data
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
	public TreeNode deserializeI(String data) {
        if (data == null || data.length() == 0) return null;
        String[] datas = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(datas[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int pos = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            // build left
            if (datas[pos].equals("#")) curr.left = null;
            else {
                TreeNode left = new TreeNode(Integer.valueOf(datas[pos]));
                curr.left = left;
                queue.offer(left);
            }
            pos++;
            
            // build right
            if (datas[pos].equals("#")) curr.right = null;
            else {
                TreeNode right = new TreeNode(Integer.valueOf(datas[pos]));
                curr.right = right;
                queue.offer(right);
            }
            pos++;
        }
        return root;
	}
	
	
	/**
	 * Method1: DFS(Recursion) (preorder traversal template) Use "#" to denote null node.
	 * @param TreeNode root
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder data = new StringBuilder();
		helperS(root, data);
		return data.toString().substring(0, data.length() - 1);
	}
	
	private void helperS(TreeNode root, StringBuilder data) {
		if (root == null) {
			data.append("#").append(",");
			return;
		}
		data.append(root.val).append(",");
		helperS(root.left, data);
		helperS(root.right, data);
	}
	
	// Decodes your encoded data to tree.
	/**
	 * Method1: Use a list to store the pre-order traversal and since we have "#" as null node, we 
	 * know exactly how to where to end building subtress.
	 * @param String data
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(log(n))
	 */
	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		List<String> newData = new ArrayList<>(Arrays.asList(data.split(",")));
		return helperD(newData);
	}
	
	private TreeNode helperD(List<String> data) {
		if (data == null || data.size() == 0) return null;
		String curr = data.remove(0);
		if (curr.equals("#")) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(curr));
		root.left = helperD(data);
		root.right = helperD(data);
		return root;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeandDeserializeBinaryTree result = new SerializeandDeserializeBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
		String data = result.serialize(root);
		System.out.println(data);
		TreeNode.printCBT(result.deserialize(data));
		
		TreeNode root1 = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		String dataI = result.serializeI(root1);
		System.out.println(dataI);
		TreeNode.printCBT(result.deserializeI(dataI));
	}

}
