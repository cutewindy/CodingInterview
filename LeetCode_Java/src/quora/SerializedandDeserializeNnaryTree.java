package quora;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializedandDeserializeNnaryTree {
	
	
	public String serialize(Node root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		dfs(root, sb);
		return sb.toString().trim();
	}
	
	private void dfs(Node root, StringBuilder sb) {
		if (root == null) {
			sb.append("# ");
			return ;
		}
		sb.append(root.val).append(" ");
		for (int i = 0; i < 3; i++) {
			dfs(root.children[i], sb);
		}
	}
	
	public Node deserialize(String str) {
		if (str == null || str.length() == 0) return null;
		String[] strs = str.split(" ");
		int[] index = new int[1];
		return dfs(strs, index);
	}
	
	private Node dfs(String[] strs, int[] index) {
		if (index[0] == strs.length || strs[index[0]].equals("#")) {
			index[0]++;
			return null;
		}
		Node root = new Node(Integer.parseInt(strs[index[0]]));
		index[0]++;
		for (int i = 0; i < 3; i++) {
			root.children[i] = dfs(strs, index);
		}
		return root;
	}
	
	public void run() {
		Node root = buildTree();
		print(root);
		String str = serialize(root);
		System.out.println(str);
		Node newRoot = deserialize(str);
		print(newRoot);
	}
	
	private void print(Node root) {
		System.out.println("========print tree==========");
		Queue<Node> queue = new LinkedList<>();
		if (root == null) return;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> line = new ArrayList<>();
			int size = queue.size(); 
			while (size-- > 0) {
				Node curr = queue.poll();
				line.add(curr.val);
				for (int i = 0; i < 3; i++) {
					if (curr.children[i] == null) continue;
					queue.offer(curr.children[i]);
				}
			}
			System.out.println(line);
		}
		System.out.println("========end==========");
	}
	
	private Node buildTree() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.children[0] = node2;
		node1.children[1] = node3;
		node2.children[0] = node4;
		node2.children[1] = node5;
		node2.children[2] = node6;
		node3.children[2] = node7;
		return node1;
		
		/**
		 *        1
		 *      /  /
		 *     2   3 
		 *   / / \  \
		 *  4 5   6  7 
		 */
	}
	
	class Node{
		int val;
		Node[] children;
		public Node(int val) {
			this.val = val;
			this.children = new Node[3];
		}
	}
 	
	public static void main(String[] args) {
		SerializedandDeserializeNnaryTree result = new SerializedandDeserializeNnaryTree();
		result.run();
	}
}
