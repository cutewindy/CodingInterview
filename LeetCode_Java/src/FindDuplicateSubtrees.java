import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only 
 * need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 * Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
 * The following are two duplicate subtrees:
      2
     /
    4
 * and
    4
 * Therefore, you need to return above trees' root in the form of a list.
 * @author wendi
 *
 */
public class FindDuplicateSubtrees {

	
	/**
	 * Approach2: Postorder traversal
	 * @param TreeNode root
	 * @return List<TreeNode>
	 * Time: O(n)
	 * Sapce: O(n)
	 */
    public List<TreeNode> findDuplicateSubtreesI(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root, new HashMap<String, Integer>(), res);
        return res;
    }
    
    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "";
        String str = root.val + "," + dfs(root.left, map, res) + "," + dfs(root.right, map, res); // can't be left+root+right
        if (!map.containsKey(str)) map.put(str, 0);
        map.put(str, map.get(str) + 1);
        if (map.get(str) == 2) res.add(root);
        return str;
    }
    
	/**
	 * ApproachI: brute force
	 * @param TreeNode root
	 * @return List<TreeNode>
	 * Time: O(n)
	 * Sapce: O(n)
	 */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        dfs(root, new HashMap<Integer, List<TreeNode>>(), set);
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node: set) {
        	res.add(node);
        }
        return res;
    }
    
    private void dfs(TreeNode root, Map<Integer, List<TreeNode>> map, Set<TreeNode> set) {
    	if (root == null) return;
    	dfs(root.left, map, set);
    	dfs(root.right, map, set);
    	if (map.containsKey(root.val)) {
    		for (TreeNode root1: map.get(root.val)) {
//    			if (isSame(root, root1) && set.contains(o)) {
//    				set.add(root);
//    				break;
//    			}
    		}
    	}
    	
//    	map.getOrDefault();
    	
    }
    
    private boolean isSame(TreeNode p, TreeNode q) {
    	if (p == null && q == null) return true;
    	if (p == null || q == null) return false;
    	return isSame(p.left, q.left) && isSame(p.right, q.right) && p.val == q.val;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDuplicateSubtrees result = new FindDuplicateSubtrees();
		TreeNode root = TreeNode.generateCBT(new int[] {1,3,2,2,1,4,1,4,1});
		TreeNode.printCBT(root);
		List<TreeNode> res = result.findDuplicateSubtrees(root);
		for (TreeNode r: res) System.out.print(r.val + ", ");
		System.out.println();
		List<TreeNode> resI = result.findDuplicateSubtreesI(root);
		for (TreeNode r: resI) System.out.print(r.val + ", ");
	}

}
