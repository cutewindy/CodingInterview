package quora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SerializedandDeserializeStrNodeTree {
	

	/**
	 * Approach1: using "#" instead of "#" and " # " as separator
	 * @param TreeNode root
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 */
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		dfs(root, sb);
		return sb.toString().substring(0, sb.length() - 3);
	}
	
	private void dfs(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("# # ");
			return;
		}
		String val = root.val.replaceAll("#", "##");
		sb.append(val).append(" # ");
		dfs(root.left, sb);
		dfs(root.right, sb);
	}
	
	public TreeNode deserialize(String str) {
		if (str == null || str.length() == 0) return null;
		String[] strs = str.split(" # ");
		int[] index = new int[1];
		return dfs(strs, index);
	}
	
	private TreeNode dfs (String[] strs, int[] index) {
		if (index[0] >= strs.length || strs[index[0]].equals("#")) {
			index[0]++;
			return null;
		}
		TreeNode root = new TreeNode(strs[index[0]].replaceAll("##", "#"));
		index[0]++;
		root.left = dfs(strs, index);
		root.right = dfs(strs, index);
		return root;
	}
	
	public void run() {
		String[] array = new String[] {"123", "#4##", " 5 #", "89"};
		TreeNode root = buildTree(array);
		printTree(root);
		String str = serialize(root);
		System.out.println(str);
		TreeNode newRoot = deserialize(str);
		printTree(newRoot);
	}
	
	private TreeNode buildTree(String[] array) {
		if (array == null || array.length == 0) return null;
		TreeNode root = new TreeNode(array[0]);
		Map<Integer, TreeNode> map = new HashMap<>();
		map.put(0, root);
		for (int i = 0; i < array.length; i++) {
			if (2 * i + 1 < array.length) {
				TreeNode left = new TreeNode(array[2 * i + 1]);
				map.get(i).left = left;
				map.put(2 * i + 1, left);
			}
			if (2 * i + 2 < array.length) {
				TreeNode right = new TreeNode(array[2 * i + 2]);
				map.get(i).right = right;
				map.put(2 * i + 2, right);
			}
		}
		return root;
	}
	
	private void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) return;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<String> line = new ArrayList<>();
			int size = queue.size();
			while (size-- > 0) {
				TreeNode curr = queue.poll();
				line.add(curr.val);
				if (curr.left != null) queue.offer(curr.left);
				if (curr.right != null) queue.offer(curr.right);
			}
			System.out.println(line);
		}
	} 
	
	class TreeNode {
		String val;
		TreeNode left;
		TreeNode right;
		public TreeNode(String val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		SerializedandDeserializeStrNodeTree result = new SerializedandDeserializeStrNodeTree();
		result.run();
	}

}
