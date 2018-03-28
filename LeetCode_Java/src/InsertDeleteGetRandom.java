import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 1. insert(val): Inserts an item val to the set if not already present.
 * 2. remove(val): Removes an item val from the set if present.
 * 3. getRandom: Returns a random element from current set of elements. Each element must have the 
 * same probability of being returned.
 * Example:
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * @author wendi
 *
 */
public class InsertDeleteGetRandom {
	
	/**
	 * Map + ArrayList
	 * T: O(1)
	 */
    /** Initialize your data structure here. */
	Map<Integer, Integer> keyMap;     // Map(key, value) = (insert value, index)
	List<Integer> list;               // list[index] = value
    public InsertDeleteGetRandom() {
    	keyMap = new HashMap<>();
    	list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (keyMap.containsKey(val)) return false;
        int index = list.size();
        keyMap.put(val, index);
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!keyMap.containsKey(val)) return false;
        int index = keyMap.get(val);
        keyMap.remove(val); 
        // swap the last insert number and the remove number in list, and then update keyMap
        if (index != list.size() - 1) {
        	int last = list.get(list.size()  - 1);
        	keyMap.put(last, index);
        	list.set(index, last);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if (keyMap.isEmpty()) return -1;
        Random rang = new Random();
        int index = rang.nextInt(list.size());
        return list.get(index);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertDeleteGetRandom result = new InsertDeleteGetRandom();
		System.out.println(result.insert(1));
		System.out.println(result.remove(2));
		System.out.println(result.insert(2));
		System.out.println(result.getRandom());
		System.out.println(result.remove(1));
		System.out.println(result.insert(2));
		System.out.println(result.getRandom());
	}

}
