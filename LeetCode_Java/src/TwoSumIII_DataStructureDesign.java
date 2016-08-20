import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * Tags: HashTable, Design
 * @author wendi
 *
 */
public class TwoSumIII_DataStructureDesign {

	private List<Integer> list = new ArrayList<>();   // speed up
	private Map<Integer, Integer> hash = new HashMap<>();
	
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (hash.containsKey(number)) hash.put(number, 2); // two is enough
	    else {
	    	hash.put(number, 1);
	    	list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (int i = 0; i < list.size(); i++) {
			int num1 = list.get(i);
			int num2 = value - num1;
			if (num2 != num1 && hash.containsKey(num2) || num2 == num1 && hash.get(num2) > 1) {
				return true;
			}
		}
	    return false;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumIII_DataStructureDesign result = new TwoSumIII_DataStructureDesign();
		result.add(1);
		result.add(3);
		result.add(5);
		System.out.println(result.find(4));
		System.out.println(result.find(7));
	}

}
