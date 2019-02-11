/**
 * Given an array equations of strings that represent relationships between variables, each string 
 * equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b 
 * are lowercase letters (not necessarily different) that represent one-letter variable names.
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy 
 * all the given equations.
 * Example 1:
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the 
 * second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * Note:
 * 
 * 1. 1 <= equations.length <= 500
 * 2. equations[i].length == 4
 * 3. equations[i][0] and equations[i][3] are lowercase letters
 * 4. equations[i][1] is either '=' or '!'
 * 5. equations[i][2] is '='
 * @author wendi
 *
 */
public class SatisfiabilityofEqualityEquations {
	
	/**
	 * Method1: Union find
	 * @param String[] equations
	 * @return boolean
	 * Time: O(n)
	 * Space: O(1)
	 */
	public boolean satisfiabilityofEqualityEquations(String[] equations) {
		if (equations == null || equations.length == 0) return true;
		UFS ufs = new UFS(26);
		for (String e: equations) {
			if (e.charAt(1) == '=') ufs.union(e.charAt(0) - 'a', e.charAt(3) - 'a');
		}
		for (String e: equations) {
			if (e.charAt(1) == '!' && ufs.find(e.charAt(0) - 'a') == ufs.find(e.charAt(3) - 'a')) return false;
		}
		
		return true;
	}
	
	class UFS{
		int[] parents;
		
		public UFS(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) parents[i] = i;
		}
		
		public int find(int x) {
			int input = x;
			while (parents[x] != x) {
				x = parents[x];
			}
			while (input != x) {
				int next = parents[input];
				parents[input] = x;
				input = next;
			}
			return x;
		}
		
		public boolean union(int x, int y) {
			int px = find(x);
			int py = find(y);
			if (px == py) return false;
			parents[px] = py;
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SatisfiabilityofEqualityEquations result = new SatisfiabilityofEqualityEquations();
		System.out.println(result.satisfiabilityofEqualityEquations(new String[] {"a==b","b!=c","c==a"}));
		System.out.println(result.satisfiabilityofEqualityEquations(new String[] {"c==c","b==d","x!=z"}));
//		System.out.println(result.satisfiabilityofEqualityEquations(new String[] {"f==a","a==b","f!=e","a==c","b==e","c==f"}));
	}

}
