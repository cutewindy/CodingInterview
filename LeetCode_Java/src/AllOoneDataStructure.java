import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a data structure supporting the following operations:
 * 1. Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is 
 *    guaranteed to be a non-empty string.
 * 2. Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an 
 *    existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to 
 *    be a non-empty string.
 * 3. GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an 
 *    empty string "".
 * 4. GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an 
 *    empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 * @author wendi
 *
 */
public class AllOoneDataStructure {
	
	class Bucket {
		int cnt;
		Set<String> keys;
		Bucket prev;
		Bucket next;
		public Bucket(int cnt) {
			this.cnt = cnt;
			this.keys = new HashSet<>();
			this.prev = null;
			this.next = null;
		}
	}

	Map<Integer, Bucket> buckets;  // (key, value): (cnt, Bucket)
	Bucket dummyHead;
	Bucket tail;
    /** Initialize your data structure here. */
    public AllOoneDataStructure() {
        this.buckets = new HashMap<>();
        this.dummyHead = new Bucket(0);
        this.tail = dummyHead;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


