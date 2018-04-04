/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the 
 * preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all 
 * the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the 
 * string and the original binary tree.
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
		       1
		     /   \
		    2     3
		   /    
		  4     
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", 
 * but you need to omit all the unnecessary empty parenthesis pairs. 
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
		       1
		     /   \
		    2     3
		     \  
		      4 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, 
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship 
 * between the input and the output.
 * @author wendi
 *
 */
public class ConstructStringfromBinaryTree {

	/**
	 * Method2: DFS(top down)
	 * @param TreeNode t
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(log(n))
	 */
	public String constructStringfromBinaryTreeI(TreeNode t) {
		if (t == null) return "";
		StringBuilder result = new StringBuilder();
		constructI(t, result);
		return result.toString();
	}
	
	public void constructI(TreeNode root, StringBuilder result) {
		if (root == null) return;
		result.append(root.val);
		if (root.left != null || root.right != null) {
			result.append("(");
			constructI(root.left, result);
			result.append(")");
		}
		if (root.right != null) {
			result.append("(");
			constructI(root.right, result);
			result.append(")");
		}        
    }
	
	
	
	/**
	 * Method1: DFS(bottom up)
	 * @param TreeNode t
	 * @return String
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public String constructStringfromBinaryTree(TreeNode t) {
		if (t == null) return "";
		return construct(t);
	}
	
	public String construct(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		if (root.right != null) {
			sb.append("(").append(construct(root.left)).append(")");
			sb.append("(").append(construct(root.right)).append(")");
		}
		else if (root.left != null) {
			sb.append("(").append(construct(root.left)).append(")");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructStringfromBinaryTree result = new ConstructStringfromBinaryTree();
		TreeNode root = TreeNode.generateCBT(new int[] {1, 2, 3, 4});
		TreeNode.printCBT(root);
		System.out.println(result.constructStringfromBinaryTree(root));
		System.out.println(result.constructStringfromBinaryTreeI(root));
	}

}
