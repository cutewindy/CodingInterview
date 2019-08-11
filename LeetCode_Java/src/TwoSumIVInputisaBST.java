import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the 
 * BST such that their sum is equal to the given target.
 * Example 1:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 9
 * Output: True
 * Example 2:
 * Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
 * Target = 28
 * Output: False
 * @author wendi
 *
 */
public class TwoSumIVInputisaBST {
	
	
	/**
	 * Approach3: use binary search method. For each node, we check if k - node.val exists in this 
	 * BST.
	 * @param TreeNode root, int k
	 * @return boolean
	 * Time: O(nlog(n))
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public boolean twoSumIVInputisaBSTII(TreeNode root, int k) {	
        return dfs(root, root, k);
    }
    
    private boolean dfs(TreeNode root, TreeNode curr, int k) {
        if (curr == null) return false;
        if (find(root, curr, k - curr.val)) return true;
        return dfs(root, curr.left, k) || dfs(root, curr.right, k);
    }
    
    private boolean find(TreeNode root, TreeNode p1, int target) {
        if (root == null) return false;
        if (root != p1 && root.val == target) return true;
        if (root.val < target) return find(root.right, p1, target);
        return find(root.left, p1, target);
	}
	
	
	/**
	 * Approach2: use a sorted array to save the values of the nodes in the BST by using an inorder
	 *  traversal. Then, we use two pointers which begins from the start and end of the array to 
	 *  find if there is a sum k
	 * @param TreeNode root, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean twoSumIVInputisaBSTI(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(root, list);
        int s = 0;
        int e = list.size() - 1;
        while (s < e) {
            int sum = list.get(s) + list.get(e);
            if (sum == k) return true;
            if (sum < k) s++;
            else e--;
        }
        return false;
    }
    
    private void inorderTraverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }
    
    
    
	/**
	 * Approach1: Using HashSet
	 * This method also works for those who are not BSTs. The idea is to use a set to save the 
	 * values of the nodes in the BST. Each time when we insert the value of a new node into the 
	 * set, we check if the set contains k - node.val.
	 * @param TreeNode root, int k
	 * @return boolean
	 * Time: O(n)
	 * Space: O(n)
	 */
	public boolean twoSumIVInputisaBST(TreeNode root, int k) {
		if (root == null) return false;
		return towSuminBST(root, k, new HashSet<Integer>());
	}
	
	public boolean towSuminBST(TreeNode root, int target, Set<Integer> seen) {
		if (root == null) return false;
		if (seen.contains(target - root.val)) return true;
		seen.add(root.val);
		return towSuminBST(root.left, target, seen) || towSuminBST(root.right, target, seen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumIVInputisaBST result = new TwoSumIVInputisaBST();
		TreeNode root = TreeNode.generateCBT(new int[] {5, 3, 6, 2, 4, 7});
		TreeNode.printCBT(root);
		System.out.println(result.twoSumIVInputisaBST(root, 9));
		System.out.println(result.twoSumIVInputisaBST(root, 28));
	}

}
