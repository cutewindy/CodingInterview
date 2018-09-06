/**
 * Design a HashSet without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * add(value): Insert a value into the HashSet. 
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do 
 * nothing.
 * Example:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);         
 * hashSet.add(2);         
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);          
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // returns false (already removed)
 * Note:
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 * @author wendi
 *
 */
public class DesignHashSet {
	
	class Node {
		int key;
		Node next;
		public Node(int key) {
			this.key = key;
			this.next = null;
		}
	}
	
	final int size = 1000000;
	Node[] bucket;
    /** Initialize your data structure here. */
    public DesignHashSet() {
        bucket = new Node[size];
    }
    
    public void add(int key) {
        int index = getIndex(key);
        if (bucket[index] == null) bucket[index] = new Node(key);
        else {
        	Node prev = getPrev(index, key);
        	if (prev.next == null) prev.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if (bucket[index] == null) return;
        Node prev = getPrev(index, key);
        if (prev.key == -1) bucket[index] = prev.next.next;
        prev.next = prev.next.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getIndex(key);
        if (bucket[index] == null) return false;
        Node prev = getPrev(index, key);
        if (prev.next == null) return false;
        return true;
    }
    
    private int getIndex(int key) {
    	return Integer.hashCode(key) % size;
    }
    
    private Node getPrev(int index, int key) {
    	if (bucket[index] == null) return null;
    	Node prev = new Node(-1);
    	prev.next = bucket[index];
    	while (prev.next != null && prev.next.key != key) {
    		prev = prev.next;
    	}
    	return prev;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesignHashSet set = new DesignHashSet();
		set.add(1);         
		set.add(2);         
		System.out.println(set.contains(1));    // returns true
		System.out.println(set.contains(3));    // returns false (not found)
		set.add(2);          
		System.out.println(set.contains(2));    // returns true
		set.remove(2);          
		System.out.println(set.contains(2));    // returns false (already removed)
	}

}
