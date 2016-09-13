import java.util.Arrays;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * Corner Cases:
 * 1 Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * 2 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * Tags: Stack, String
 * @author wendi
 *
 */
public class SimplifyPath {
	
	/**
	 * Stack: using definition of path.
	 * @param String path
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 */
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		// 1 push valid path in stack, if "..", pop from stack.
		String[] paths = path.split("/");
		System.out.println(Arrays.toString(paths));
		Stack<String> stack = new Stack<>();
		for (String p: paths) {
			if (p.equals("") || p.equals(".") || p.equals("..") && stack.isEmpty()) continue;
			else if (p.equals("..")) {
				stack.pop();
			}
			else {
				stack.push(p);
			}
		}
		// 2 add result 
		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}
		return result.length() == 0 ? "/" : result;  // be care about res="" case
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath result = new SimplifyPath();
		System.out.println(result.simplifyPath("//../a/./b//c/../../d//"));
		System.out.println(result.simplifyPath("/"));
	}

}
