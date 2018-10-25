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

	/**
	 * HashMap
	 * T: add: O(1), find: T: O(n)
	 * S: O(n)
	 */
    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    
    public TwoSumIII_DataStructureDesign() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer a: map.keySet()) {
            if (!map.containsKey(value - a)) continue;
            if (value - a != a || map.get(value - a) > 1) return true;
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
