import java.util.ArrayList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:
 * 1. The row number m should be equal to the height of the given binary tree.
 * 2. The column number n should always be an odd number.
 * 3. The root node's value (in string format) should be put in the exactly middle of the first row 
 * it can be put. The column and the row where the root node belongs will separate the rest space 
 * into two parts (left-bottom part and right-bottom part). You should print the left subtree in the 
 * left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and 
 * the right-bottom part should have the same size. Even if one subtree is none while the other is 
 * not, you don't need to print anything for the none subtree but still need to leave the space as 
 * large as that for the other subtree. However, if two subtrees are none, then you don't need to 
 * leave space for both of them.
 * Each unused space should contain an empty string "".
 * 4. Print the subtrees following the same rules.
 * 5. Example 1:
 * Input:
	     1
	    /
	   2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
	     1
	    / \
	   2   3
	    \
	     4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
	      1
	     / \
	    2   5
	   / 
	  3 
	 / 
	4 
 * Output:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 * @author wendi
 *
 */
public class PrintBinaryTree {
	
	/**
	 * DFS
	 * We start by initializing a res array with the dimensions being 2^h-1. Here, h refers to the 
	 * number of levels in the given tree. In order to fill this res array with the required 
	 * elements, initially, we fill the complete array with "" . After this we make use of a 
	 * recursive function fill(res, root, row, l, r) which fills the res array such that the current 
	 * element has to be filled in ith row, and the column being the middle of the indices l and r.
	 * @param TreeNode root
	 * @return List<List<String>>
	 * Time: O(2n)
	 * Space: O(1)
	 */
	public List<List<String>> printBinaryTree(TreeNode root) {
		List<List<String>> res = new ArrayList<>();
		int h = getHeight(root);
		int w = (1 << h) - 1;
		List<String> rows = new ArrayList<>();
		for (int j = 0; j < w; j++) rows.add("");
		for (int i = 0; i < h; i++) res.add(new ArrayList<>(rows)); // should add a new one, take care
		fill(root, 0, 0, w - 1, res);
		return res;
	}
	
	private void fill(TreeNode root, int row, int left, int right, List<List<String>> res) {
		if (root == null) return;
		int mid = (left + right) / 2;
		res.get(row).set(mid, "" + root.val);
		fill(root.left, row + 1, left, mid - 1, res);
		fill(root.right, row + 1, mid + 1, right, res);
	}
	
	private int getHeight(TreeNode root) {
		if (root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintBinaryTree result = new PrintBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 5, 3, 4});
		System.out.println(result.printBinaryTree(root));
	}

}
