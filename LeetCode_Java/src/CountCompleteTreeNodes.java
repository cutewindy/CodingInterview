/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and 
 * all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes 
 * inclusive at the last level h.
 * 
 * Tags: Tree, Binary Search
 * @author wendi
 *
 */
public class CountCompleteTreeNodes {

	/**
	 * Method5: BinarySearch: find which part is perfect tree.
	 * If(height(root.right)==h-1), left part is a final complete tree with heigth h-1, move to right.
	 * Otherwise, right part is a final complete tree with height h-2, move to left find next one.
	 * @param TreeNode root
	 * @return int
	 * Time: O(log(n)^2)
	 * Space: O(1)
	 */
	public int countCompleteTreeNodesIIIV(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = height(root);
		int result = 0;
		while (root != null) {
			if (height(root.right) == h - 1) { // means tree of root.left is a final complete tree with heigth = h-1
				result += (1 << (h - 1)) - 1 + 1;
				root = root.right;
			}
			else {   // means tree of root.right is a final complete tree with height = h-2
 				result += (1 << (h - 2)) - 1 + 1;
 				root = root.left;
			}
			h--;
		}
		return result;
	}
	
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) + 1;
	}
	
	
	/**
	 * Method4: DFS(Iteration) : Same like method3
	 * @param TreeNode root
	 * @return int
	 * Time: O(log(n)^2)
	 * Space: O(1)
	 */
    public int countCompleteTreeNodesIII(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        while (root != null) {
            int leftH = leftHeightI(root.left);
            int rightH = leftHeightI(root.right);
            if (leftH == rightH) {
                res += (1 << leftH);
                root = root.right;
            }
            else {
                res += (1 << rightH);
                root = root.left;
            }
        }
        return res;
    }

    private int leftHeightI(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

	
	
	/**
	 * Method3: DFS(Recursion) : Same like method2
	 * @param TreeNode root
	 * @return int
	 * Time: O(log(n)^2)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int countCompleteTreeNodesII(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        while (root != null) {
            int leftH = leftHeight(root.left);
            int rightH = leftHeight(root.right);
            if (leftH == rightH) {
                res += (1 << leftH);
                root = root.right;
            }
            else {
                res += (1 << rightH);
                root = root.left;
            }
        }
        return res;
    }

    private int leftHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
	
	
	/**
	 * Method2: DFS(Recursion) : Using complete tree feature.
	 * When leftDepth==rightDepth, it's a perfect tree, 
	 * the nodes number is 2^h - 1. Otherwise, count left complete tree + right complete tree + 1.
	 * @param TreeNode root
	 * @return int
	 * Time: O(log(n)^2)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int countCompleteTreeNodesI(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);
		if (leftDepth != rightDepth) {	
			return countCompleteTreeNodesI(root.left) + countCompleteTreeNodesI(root.right) + 1;
		}
//		return (int) Math.pow(2, leftDepth) - 1;  # (Time limited Exceeded)
		return (1 << leftDepth) - 1;
	}
	
	private int leftDepth(TreeNode root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.left;
		}
		return depth;
	}
	
	private int rightDepth(TreeNode root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.right;
		}
		return depth;
	}
	
	
	/**
	 * Method1: DFS(Recursion) (Time Limit Exceeded): count node one by one like binary tree
	 * @param TreeNode root
	 * @return int 
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public int countCompleteTreeNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root.left) + helper(root.right) + 1;
	}
	
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root.left) + helper(root.right) + 1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountCompleteTreeNodes result = new CountCompleteTreeNodes();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		TreeNode.printCBT(root);
		System.out.println(result.countCompleteTreeNodes(root));
		System.out.println(result.countCompleteTreeNodesI(root));
		System.out.println(result.countCompleteTreeNodesII(root));
	}

}
