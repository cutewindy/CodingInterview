import java.util.TreeMap;

/**
 * Given a chemical formula (given as a string), return the count of each atom.
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, 
 * representing the name.
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. 
 * If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is 
 * impossible.
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a 
 * formula.
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, 
 * (H2O2) and (H2O2)3 are formulas.
 * Given a formula, output the count of all elements as a string in the following form: the first 
 * name (in sorted order), followed by its count (if that count is more than 1), followed by the 
 * second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 * Example 1:
 * Input: 
 * formula = "H2O"
 * Output: "H2O"
 * Explanation: 
 * The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 * Input: 
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: 
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 * Input: 
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: 
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * Note:
 * 1. All atom names consist of lowercase letters, except for the first character which is uppercase.
 * 2. The length of formula will be in the range [1, 1000].
 * 3. formula will only consist of letters, digits, and round parentheses, and is a valid formula as 
 * defined in the problem.
 * @author wendi
 *
 */
public class NumberofAtoms {
	
	
	/**
	 * TreeMap + dfs
	 * @param String formula
	 * @return String
	 * Time: O(n)
	 * Space: O(n)
	 * Stack space: O(n)
	 */
	int pos = 0;
    public String numberofAtoms(String formula) {
        if (formula == null || formula.length() == 0) return "";
        TreeMap<String, Integer> map = dfs(formula); // [name: cnt]
        StringBuilder sb = new StringBuilder();
        for (String name: map.keySet()) {
        	sb.append(name);
        	if (map.get(name) == 1) continue;
        	sb.append(map.get(name));
        }
        return sb.toString();
    }
    
    private TreeMap<String, Integer> dfs(String formula) {
    	TreeMap<String, Integer> map = new TreeMap<>();
    	if (pos == formula.length()) return map;
    	while (pos < formula.length()) {
    		if (formula.charAt(pos) == '(') {
    			pos++;
    			TreeMap<String, Integer> next = dfs(formula);
    			for (String name: next.keySet()) {
    				map.put(name, map.getOrDefault(name, 0) + next.get(name));
    			}
    		}
    		else if (formula.charAt(pos) == ')') {
    			pos++;
    			int cnt = getCnt(formula);
    			for (String name: map.keySet()) {
    				map.put(name, map.get(name) * cnt);
    			}
    			return map;
    		}
    		else {
    			String name = getName(formula);
    			int cnt = getCnt(formula);
    			map.put(name, map.getOrDefault(name, 0) + cnt);
    		}
    	}
    	return map;
    }
    
    private String getName(String formula) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(formula.charAt(pos++));
    	while (pos < formula.length() && Character.isLowerCase(formula.charAt(pos))) {
    		sb.append(formula.charAt(pos++));
    	}
    	return sb.toString();
    }
    
    private int getCnt(String formula) {
    	if (pos == formula.length() || !Character.isDigit(formula.charAt(pos))) return 1;
    	int num = 0;
    	while (pos < formula.length() && Character.isDigit(formula.charAt(pos))) {
    		num = num * 10 + formula.charAt(pos++) - '0';
    	}
    	return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofAtoms result = new NumberofAtoms();
//		System.out.println(result.numberofAtoms("H2O"));
		System.out.println(result.numberofAtoms("K4N2O14S4"));
	}

}
