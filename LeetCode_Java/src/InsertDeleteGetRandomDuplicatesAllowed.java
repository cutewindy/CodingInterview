import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each 
 * element being returned is linearly related to the number of same value the collection contains.
 * Example:
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection 
 * now contains [1,1].
 * collection.insert(1);
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 * @author wendi
 *
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

	/**
	 * HashMap + LinkedHashSet + ArrayList
	 * using a LinkedHashSet for O(1) iteration over large items.
     * An iterator over a normal HashSet is actually O(h/n), where h is table capacity.
     * So it is not a solution to our problem requiring O(1) time.
     * T: insert: O(1)
     *    remove: O(1)
     *    getRandom: O(1)
	 */
	
	Map<Integer, Set<Integer>> map;
	List<Integer> list;
	Random rand;
	
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean contained = true;
    	if (!map.containsKey(val)) {
    		contained = false;
    		map.put(val, new LinkedHashSet<Integer>());
    	}	
		map.get(val).add(list.size());
    	list.add(val);
        return !contained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        
        int listIdx = map.get(val).iterator().next();
        map.get(val).remove(listIdx);         // 1. remove val from map
        if (map.get(val).isEmpty()) map.remove(val);
        if (listIdx != list.size() - 1) {     // 2. if not last val in list, swap with it
        	int lastIdx = list.size() - 1;
        	int lastVal = list.get(lastIdx);
        	list.set(listIdx, lastVal);       // swap listIdx val and lastIdx val
        	map.get(lastVal).add(listIdx);    // update index in map
        	map.get(lastVal).remove(lastIdx);
        }
        list.remove(list.size() - 1);         // 3. remove val from list
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if (list.isEmpty()) return -1;
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertDeleteGetRandomDuplicatesAllowed result = new InsertDeleteGetRandomDuplicatesAllowed();
		result.insert(1);
		result.insert(1);
		result.insert(2);
		System.out.println(result.getRandom());
		result.remove(1);
		System.out.println(result.getRandom());
	}

}
