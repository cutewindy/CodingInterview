import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the 
 * following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache 
 * reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * Tags: Design
 * @author wendi
 *
 */
public class LRUCache {
	
	/**
	 * Method3: LinkedHashMap
	 * 1. In the constructor, the third boolean parameter specifies the ordering mode. If we set it 
	 * to true, it will be in access order. 
	 * 2. By overriding removeEldestEntry in this way, we do not need to take care of it ourselves. 
	 * It will automatically remove the least recent one when the size of map exceeds the specified 
	 * capacity.
	 */
	
	
	
	/**
	 * Method2: Single linked list: node in hash is the pre Node info.
	 * DummyHead.next of list is the oldest element.
	 * Tail is the last element of the list.
	 * @author wendi
	 *
	 */
//	class Node{
//		int key;
//		int value;
//		Node next;
//	}
	
	
	
	/**
	 * Method1: Double linked list: node in hash is the curr Node info.
	 * DummyHead.next of list is the oldest element. 
	 * Tail is the last element of the list.
	 * @author wendi
	 *
	 */
	class Node{
		int key;
		int value;
		Node pre;
		Node next;
		public Node(int key, int val) {
			this.key = key;
			this.value = val;
			this.pre = null;
			this.next = null;
		}
	}
	private int capacity;
	private Map<Integer, Node> hash; // node in hash is the info of curr node
	private Node dummyHead;
	private Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.hash = new HashMap<>();
		this.dummyHead = new Node(-1, -1); 
		this.tail = dummyHead;
	}
	public int get(int key) {
		if (!hash.containsKey(key)) {
			return -1;
		}
		Node currNode = hash.get(key);
		// refresh the node by removing node to the tail of list
		if (currNode != tail) {
			removeNode(currNode);
			addNode(currNode);
		}
		return currNode.value;
	}
	
	public void set(int key, int value) {
		if (hash.containsKey(key)) {
			Node currNode = hash.get(key);
			currNode.value = value;
			// refresh the node by removing node to the tail of list
			if (currNode != tail) {
				removeNode(currNode);
				addNode(currNode);
			}
		}
		else {
			Node currNode = new Node(key, value);
			if (hash.size() == capacity) {
				hash.remove(dummyHead.next.key);
				removeNode(dummyHead.next);
			}
			hash.put(key, currNode);
			addNode(currNode);
		}
	}
	
	private void addNode(Node node) {
		tail.next = node;
		node.pre = tail;
		tail = node;
	}
	
	private void removeNode(Node node) {
		if (tail != node) {	
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		else {
			tail = node.pre;
			tail.next = null;
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache result = new LRUCache(4);
		result.set(1, 11);
		result.set(2, 22);
		result.set(3, 33);
		System.out.println(result.get(2));
		result.set(1, 111);
		result.set(4, 44);
		result.set(5, 55);
	}

}
