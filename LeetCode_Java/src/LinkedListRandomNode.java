/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must 
 * have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this 
 * efficiently without using extra space?
 * Example:
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal 
 * probability of returning.
 * solution.getRandom();
 * 
 * Tags: Reservoir Sampling
 * @author wendi
 *
 */
public class LinkedListRandomNode {
	
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	ListNode head;
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
	}

	/**
	 * @return int
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int getRandom() {
		int result = head.val;
		int count = 1;
		ListNode node = head.next;
		while (node != null) {
			result = Math.random() < (double) 1 / ++count ? node.val : result;
			node = node.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5, 2});
		LinkedListRandomNode result = new LinkedListRandomNode(head);
		System.out.println(result.getRandom());
	}

}
