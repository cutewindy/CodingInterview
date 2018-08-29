package wePay;
import data_structure.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给一个binary tree 和一个target node,construct root到target的双向链表比如
 * input tree t: 1,2,3,4,5,null,null target: 5 要求返回root 1到target 5的路径的doubly linked list,
 * 即1<->2<->5
 * @author wendi
 *
 */
public class ConstructDequefromRoottoTarget {
	
	/**
	 * BFS to build graph, DFS to walk graph
	 * @param TreeNode root, int target
	 * @return Deque<Integer>
	 * Time: O(E)
	 * Space: O(E)
	 */
	public Deque<Integer> constructDequefromRoottoTarget(TreeNode root, int target) {
		Deque<Integer> res = new LinkedList<>();
		if (root == null) return res;
		Map<Integer, Integer> map = new HashMap<>();
		if (buildGraph(root, target, map)) {
			walkGraph(target, map, res);
		}
		return res;
	}
	
	private boolean buildGraph(TreeNode root, int target, Map<Integer, Integer> map) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode currNode = queue.poll();
				if (currNode.val == target) return true;
				if (currNode.left != null) {
					map.put(currNode.left.val, currNode.val);
					queue.offer(currNode.left);
				}
				if (currNode.right != null) {
					map.put(currNode.right.val, currNode.val);
					queue.offer(currNode.right);
				}
			}
		}		
		return false;
	}
	
	private void walkGraph(int target, Map<Integer, Integer> map, Deque<Integer> res) {
		if (!map.containsKey(target)) {
			res.offerFirst(target);
			return;
		}
		res.offerFirst(target);
		walkGraph(map.get(target), map, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructDequefromRoottoTarget result = new ConstructDequefromRoottoTarget();
		TreeNode root = TreeNode.generateCBT(new int[] {1,2,3,4,5});
		System.out.println(result.constructDequefromRoottoTarget(root, 5));
	}

}
