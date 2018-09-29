import java.util.HashSet;
import java.util.Set;

/**
 * We are given head, the head node of a linked list containing unique integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are connected if they appear 
 * consecutively in the linked list.
 * Example 1:
 * Input: 
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation: 
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * Input: 
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation: 
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 * 1. If N is the length of the linked list given by head, 1 <= N <= 10000.
 * 2. The value of each node in the linked list will be in the range [0, N - 1].
 * 3. 1 <= G.length <= 10000.
 * 4. G is a subset of all values in the linked list.
 * @author wendi
 *
 */
public class LinkedListComponents {
	
	
	/**
	 * Set
	 * @param ListNode head, int[] G
	 * @return int
	 * Time: O(m+n) n=linkedlist.length
	 * Space: O(m) m=G.length
	 */
	public int linkedListComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g: G) set.add(g);
        int res = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                res++;
                while (head != null && set.contains(head.val)) head = head.next;
            }
            head = head == null ? null : head.next;
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListComponents result = new LinkedListComponents();
		ListNode head = ListNode.generateLinkedList(new int[] {0, 1, 2, 3});
		System.out.println(result.linkedListComponents(head, new int[] {0, 1, 3}));
	}

}
