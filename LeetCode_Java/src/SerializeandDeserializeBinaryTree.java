import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * Method2: BFS
	 * @param root
	 * @return
	 */
	public String serializeI(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder data = new StringBuilder();
		
		return data.toString();
	}
	
	public TreeNode deserializeI(String data) {
		TreeNode root = null;
		if (data == null || data.length() == 0) {
			return root;
		}
		return root;
	}
	
	
	/**
	 * Method1: Preorder(Recursion)
	 * @param root
	 * @return
	 */
	// serialize
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
	
	// deserialize
	public TreeNode deserialize(String data) {
		TreeNode root = null;
		if (data == null || data.length() == 0) {
			return root;
		}
		List<String> newData = new ArrayList<>(Arrays.asList(data.split(",")));
		return helperD(newData);
	}
	private TreeNode helperD(List<String> data) {
		String curr = data.remove(0);
		if (curr.equals("#")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(curr));
		node.left = helperD(data);
		node.right = helperD(data);
		return node;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializeandDeserializeBinaryTree result = new SerializeandDeserializeBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6});
		TreeNode.printCBT(root);
		String data = result.serialize(root);
		System.out.println(data);
		TreeNode newRoot = result.deserialize(data);
		TreeNode.printCBT(newRoot);
	}

}
