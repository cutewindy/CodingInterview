import java.util.Stack;

/**
 * 
 * @author wendi
 *
 */
public class ConstructBinaryTreefromString {
	
	/**
	 * Approach2: Stack
	 * @param String s
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(n)
	 */
    public TreeNode constructBinaryTreefromStringI(String s) {
        if (s == null || s.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                continue;
            }
            if (s.charAt(i) == ')') {
                i++;
                stack.pop();
                continue;
            }
            int sign = 1;
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            int l = i;
            int r = i;
            while (r < s.length() && Character.isDigit(s.charAt(r))) r++;
            int val = sign * Integer.parseInt(s.substring(l, r));
            TreeNode curr = new TreeNode(val);
            if (!stack.isEmpty() && stack.peek().left == null) stack.peek().left = curr;
            else if (!stack.isEmpty() && stack.peek().right == null) stack.peek().right = curr;
            stack.push(curr);
            i = r;
        }
        return stack.peek();
    }	
	
	
	
	
	
	/**
	 * Approach1: dfs
	 * @param String s
	 * @return TreeNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(log(n))
	 */
	public TreeNode constructBinaryTreefromString(String s) {
		if (s == null || s.length() == 0) return null;
		return dfs(s, new int[1]);
	}
	
	private TreeNode dfs(String s, int[] index) {
		if (index[0] == s.length()) return null;
		int sign = 1;
		if (s.charAt(index[0]) == '-') {
			sign = -1;
			index[0]++;
		}
		int l = index[0];
		int r = index[0];
		while (r < s.length() && Character.isDigit(s.charAt(r))) r++;
		int val = sign * Integer.parseInt(s.substring(l, r));
		TreeNode root = new TreeNode(val);
		index[0] = r;
		if (index[0] < s.length() && s.charAt(index[0]) == '(') {
			index[0]++;
			root.left = dfs(s, index);
			index[0]++;
		}
		if (index[0] < s.length() && s.charAt(index[0]) == '(') {
			index[0]++;
			root.right = dfs(s, index);
			index[0]++;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreefromString result = new ConstructBinaryTreefromString();
		TreeNode.printCBT(result.constructBinaryTreefromString("-34(344)"));
		TreeNode.printCBT(result.constructBinaryTreefromStringI("-34(344)"));
	}

}
