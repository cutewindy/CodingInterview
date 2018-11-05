import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support 
 * the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache 
 * reaches its capacity, it should invalidate the least frequently used item before inserting a new 
 * item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the 
 * same frequency), the least recently used key would be evicted.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * Example:
 * LFUCache cache = new LFUCache( 2 capacity  )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * @author wendi
 *
 */
public class LFUCache {
	
	
    Map<Integer, Integer> vals;   // [key, value]
    Map<Integer, Integer> cnts;   // [key, frequency]
    Map<Integer, LinkedHashSet<Integer>> lists; // [frequency, sets<keys>]
    int capacity;
    int min;
    
    public LFUCache(int capacity) {
        this.vals = new HashMap<>();
        this.cnts = new HashMap<>();
        this.lists = new HashMap<>();
        this.capacity = capacity;
        this.min = 0;
    }
    
    // T: O(1)
    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        int cnt = cnts.get(key);
        // 1. update cnts
        cnts.put(key, cnt + 1);
        // 2. update lists
        lists.get(cnt).remove(key);
        if (lists.get(cnt).size() == 0) lists.remove(cnt);
        if (!lists.containsKey(cnt + 1)) lists.put(cnt + 1, new LinkedHashSet<Integer>());
        lists.get(cnt + 1).add(key);
        // 3. update min
        if (cnt == min && !lists.containsKey(min)) min++;
        
        return vals.get(key);
    }
    
    // T: O(1)
    public void put(int key, int value) {
        if (capacity <= 0) return;  // take care when capacity is 0;
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
        }
        else {
            // remove least frequency used value if out of capacity
            if (vals.size() == capacity) {
                int last = lists.get(min).iterator().next();
                vals.remove(last);            // 1. remove from vals
                cnts.remove(last);            // 2. remove from cnts
                lists.get(min).remove(last);  // 3. remove from lists
                if (lists.get(min).size() == 0) lists.remove(min);
            }
            vals.put(key, value);
            cnts.put(key, 1);
            if (!lists.containsKey(1)) lists.put(1, new LinkedHashSet<Integer>());
            lists.get(1).add(key);
            min = 1;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LFUCache result = new LFUCache(2);
		result.put(1, 1);
		result.put(2, 2);
		System.out.println(result.get(1));
		result.put(3, 3);
		System.out.println(result.get(2));
		System.out.println(result.get(3));
		result.put(4, 4);
		System.out.println(result.get(1));
		System.out.println(result.get(3));
		System.out.println(result.get(4));
	}

}
