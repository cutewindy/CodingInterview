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
	
	// 用Node来表示计数桶, inc/dec把key移到相邻的桶
    // 用Map<key, Node>来记录每个key现在在桶的位置
    // inc: O(1)
    // dec: O(1)
    // getMaxKey: O(1)
    // getMinKey: O(1)
	
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

	Map<String, Bucket> map;   // (key, value): (key, Bucket)
	Bucket dummyHead;
	Bucket tail;
    /** Initialize your data structure here. */
    public AllOoneDataStructure() {
        this.map = new HashMap<>();
        this.dummyHead = new Bucket(0);
        this.tail = new Bucket(0);
        dummyHead.next = tail;
        tail.prev = dummyHead;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {          // case1: don't contains key
        	Bucket first = dummyHead.next;
        	if (first == tail || first.cnt != 1) {
        		first = new Bucket(1);
        		insertBucket(dummyHead, first);
        	}
        	first.keys.add(key);
        	map.put(key, first);
        }
        
        else {                                // case2: contains key
        	Bucket bucket = map.get(key);
        	Bucket nextBucket = bucket.next;
        	if (nextBucket == tail || nextBucket.cnt != bucket.cnt + 1) {
        		nextBucket = new Bucket(bucket.cnt + 1);
        		insertBucket(bucket, nextBucket);
        	}
        	nextBucket.keys.add(key);        // move key from curr bucket to next bucket
        	map.put(key, nextBucket);        // update key's new bucket in map
        	bucket.keys.remove(key);
        	if (bucket.keys.isEmpty()) deleteBucket(bucket);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;    // case1: key does not exist
         
        Bucket bucket = map.get(key);
        if (bucket.cnt == 1) {                // case2: key's value is 1
        	map.remove(key);
        	bucket.keys.remove(key);
        	if (bucket.keys.isEmpty()) deleteBucket(bucket);
        }
        
        else {                                // case3: Key's value is not 1
        	Bucket prevBucket = bucket.prev;
        	if (prevBucket == dummyHead || prevBucket.cnt != bucket.cnt - 1) {
        		prevBucket = new Bucket(bucket.cnt - 1);
        		insertBucket(bucket.prev, prevBucket);
        	}
        	prevBucket.keys.add(key);         // move key from curr bucket to prev bucket
        	map.put(key, prevBucket);         // update key's new bucket in map
        	bucket.keys.remove(key);
        	if (bucket.keys.isEmpty()) deleteBucket(bucket);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (dummyHead.next == tail) return "";
        return tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (dummyHead.next == tail) return "";
        return dummyHead.next.keys.iterator().next();
    }
    
    private void insertBucket(Bucket bucket, Bucket nextBucket) {
    	Bucket oldNext = bucket.next;
    	bucket.next = nextBucket;
    	nextBucket.prev = bucket;
    	nextBucket.next = oldNext;
    	oldNext.prev = nextBucket;
    }
    
    private void deleteBucket(Bucket bucket) {
    	bucket.prev.next = bucket.next;
    	bucket.next.prev = bucket.prev;
     }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllOoneDataStructure result = new AllOoneDataStructure();
		result.inc("1");
		result.inc("2");
		result.inc("2");
		result.inc("3");
		result.inc("3");
		result.inc("3");
		result.dec("1");
		System.out.println(result.getMaxKey());
		System.out.println(result.getMinKey());
	}
}


