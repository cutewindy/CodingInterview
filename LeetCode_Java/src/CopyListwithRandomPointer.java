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
	 * Time: O(n) one pass
	 * Space: O(n)
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
		RandomListNode curr = head;
		// copy old node and save the new node into hash
		while (curr != null) {
            if (!mapping.containsKey(curr)) mapping.put(curr, new RandomListNode(curr.label));
            RandomListNode newCurr = mapping.get(curr);
            if (curr.next != null) {
                RandomListNode next = curr.next;
                mapping.putIfAbsent(next, new RandomListNode(next.label));
                newCurr.next = mapping.get(next);
            }
            if (curr.random != null) {
                RandomListNode random = curr.random;
                mapping.putIfAbsent(random, new RandomListNode(random.label));
                newCurr.random = mapping.get(random);
            }
            curr = curr.next;
		}
		return mapping.get(head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
