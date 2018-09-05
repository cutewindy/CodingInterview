/**
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the 
 * HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no 
 * mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * Example:
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);         
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1 
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found) 
 * Note:
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 * @author wendi
 *
 */
public class DesignHashMap {
	
	class Node {
		int key;
		int val;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}
	
	final int size = 1000000;
	Node[] bucket;
	public DesignHashMap() {
		bucket = new Node[size];
	}
	
	public void put(int key, int value) {
		int index = getIndex(key);
		if (bucket[index] == null) {
			bucket[index] = new Node(key, value);
		}
		else {
			Node prev = findPrev(index, key);
			if (prev.next != null) {
				prev.next.val = value;
			}
			else {
				prev.next = new Node(key, value);
			}
		}
	}
	
	public int get(int key) {
		int index = getIndex(key);
		if (bucket[index] == null) return -1;
		Node prev = findPrev(index, key);
		if (prev == null || prev.next == null) return -1;
		return prev.next.val;
	}
	
	public void remove(int key) {
		int index = getIndex(key);
		if (bucket[index] == null) return;
		Node prev = findPrev(index, key);
		if (prev == null || prev.next == null) return;
		if (prev.key == -1 && prev.val == -1) {  // deal with (key,val) is the first one
			bucket[index] = bucket[index].next;
		}
		else {
			prev.next = prev.next.next;
		}
	}
	
	private int getIndex(int key) {
		return Integer.hashCode(key) % size;
	}
	
	private Node findPrev(int index, int key) {
		if (bucket[index] == null) return null;
		Node prev = new Node(-1, -1);
		prev.next = bucket[index];
		while (prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignHashMap map = new DesignHashMap();
		map.put(1, 1);
		map.put(2, 2);
		System.out.println(map.get(1));
		System.out.println(map.get(3));
		map.put(2, 1);
		System.out.println(map.get(2));
		map.remove(2);
		System.out.println(map.get(2));
	}

}
