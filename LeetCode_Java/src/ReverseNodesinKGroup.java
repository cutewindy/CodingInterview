/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */

public class ReverseNodesinKGroup {
	
	/**
	 * Method2: Reverse method same like method1.
	 * Calculate the length of list n, then do n/k times for loop.
	 * Swap k nodes using reverse nodes method.
	 * @param ListNode head, int k
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode reverseNodesinKGroupI(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        
        n /= k;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tail = head;
        ListNode prev = dummyHead;
        curr = head.next;
        while (n-- > 0) {
            for (int i = 1; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                tail.next = next;
                curr = next;
            }
            prev = tail;
            tail = tail.next;
            if (tail != null) curr = tail.next;
        }
        
        return dummyHead.next;
	}
	

	/**
	 * Method1: 
	 * Using post pointer to find whether the number of left nodes is large than k.
	 * If true, swap k nodes using reverse nodes method.
	 * @param ListNode head, int k
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode reverseNodesinKGroup(ListNode head, int k) {
		if (head == null || head.next == null || k == 0 || k == 1) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode post = dummy;
		while (true) {
			for (int i = 0; i < k; i++) {
				post = post.next;
				if (post == null) break;
			}
			if (post == null) break;
			ListNode first = pre.next;
			for (int i = 0; i < k - 1; i++) {  // be care about swapping k - 1 times instead of k
				ListNode second = first.next;
				first.next = second.next;
				second.next = pre.next;
				pre.next = second;
			}
			pre = first;
			post = first;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNodesinKGroup result = new ReverseNodesinKGroup();
		ListNode head = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(head);
//		ListNode.printLinkedList(result.reverseNodesinKGroup(head, 2));
//		ListNode.printLinkedList(result.reverseNodesinKGroup(head, 3));
		ListNode.printLinkedList(result.reverseNodesinKGroupI(head, 2));
	}

}
