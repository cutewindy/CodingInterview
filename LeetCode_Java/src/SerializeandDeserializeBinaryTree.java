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
	 * Method2: BFS: Use a queue to iterate tree and save the result into string by using queue.
	 * When deserialize, 
	 * @param root
	 * @return
	 */
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
	
	public TreeNode deserializeI(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		int[] count = new int[data.length()];// how many "#" appear before i
		TreeNode[] node = new TreeNode[data.length()]; // new node that need to be build
		List<String> newData = new ArrayList<>(Arrays.asList(data.split(",")));
		// init
		count[0] = 0;
		node[0] = new TreeNode(Integer.valueOf(newData.get(0)));
		// create tree node
		for (int i = 1; i < newData.size(); i++) {
			if (newData.get(i).equals("#")) {
				count[i] = count[i - 1] + 1;
				node[i] = null;
			}	
			else {
				count[i] = count[i - 1];
				node[i] = new TreeNode(Integer.valueOf(newData.get(i)));
			}
		}
		// build tree
		for (int i = 0; i < newData.size(); i++) {
			if (node[i] != null) {
				node[i].left = node[2 * (i - count[i]) + 1];
				node[i].right = node[2 * (i - count[i]) + 2];
			}
		}
		return node[0];
	}
	
	
	/**
	 * Method1: Preorder(Recursion) print the tree in pre-order traversal and use "X" to denote null 
	 * node and split node with ",". We can use a StringBuilder for building the string on the fly. 
	 * For deserializing, we use a Queue to store the pre-order traversal and since we have "X" as 
	 * null node, we know exactly how to where to end building subtress.
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
//		String data = result.serialize(root);
//		System.out.println(data);
//		TreeNode newRoot = result.deserialize(data);
//		TreeNode.printCBT(newRoot);
		
		String dataI = result.serializeI(root);
		System.out.println(dataI);
		TreeNode newRootI = result.deserializeI(dataI);
		TreeNode.printCBT(newRootI);
	}

}
