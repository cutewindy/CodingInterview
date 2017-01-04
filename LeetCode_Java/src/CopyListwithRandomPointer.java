import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * Tags: HashTable, LinkedList
 * @author wendi
 *
 */
public class CopyListwithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		public RandomListNode (int x) {
			this.label = x;
		}
	}

	/**
	 * Method2: Create new node behind the old node in the same list and then link random and next.
	 * Need to change back the original list.
	 * @param RandomListNode head
	 * @return RandomListNode
	 * Time: O(3n)
	 * Space: O(1)
	 */
	public RandomListNode copyRandomListI(RandomListNode head) {
		if (head == null) return null;
		RandomListNode oldNode = head;
		RandomListNode newNode;
		// 1 create new node behind the old node in the same list
		while (oldNode != null) {
			RandomListNode next = oldNode.next;
			newNode = new RandomListNode(oldNode.label);
			oldNode.next = newNode;
			newNode.next = next;
			oldNode = oldNode.next.next;
		}		
		// 2 link the new node's random
		oldNode = head;
		while (oldNode != null) {
			newNode = oldNode.next;
			newNode.random = oldNode.random == null ? null : oldNode.random.next;  // be care
			oldNode = oldNode.next.next;
		}
		// 3 link the new node's next
		oldNode = head;
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head.next;
		while (oldNode != null) {
			newNode = oldNode.next;
			oldNode.next = newNode.next;  // need change back original list
			newNode.next = newNode.next == null ? null : newNode.next.next;
			oldNode = oldNode.next;
		}
		return dummy.next;
	}
	
	
	/**
	 * Method1: Using hashMap
	 * @param RandomListNode head
	 * @return RandomListNode
	 * Time: O(2n)
	 * Space: O(n)
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode dummy = new RandomListNode(0);
		Map<RandomListNode, RandomListNode> hash = new HashMap<>();
		RandomListNode oldNode = head;
		RandomListNode newNode;
		// 1 copy old node and save the new node into hash
		while (oldNode != null) {
			newNode = new RandomListNode(oldNode.label);
			hash.put(oldNode, newNode);
			oldNode = oldNode.next;
		}
		// 2 link next and random of each new node
		oldNode = head;
		newNode = dummy;
		while (oldNode != null) {
			newNode.next = hash.get(oldNode);
			newNode.next.next = hash.get(oldNode.next);
			newNode.next.random = hash.get(oldNode.random);
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
