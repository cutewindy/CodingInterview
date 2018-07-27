/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example:
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 * 
 * Tags: LinkedList
 * @author wendi
 *
 */
public class PlusOneLinkedList {

	/**
	 * Method3: Two Pointers: find the last node which node.val!=9, then all next nodes after
	 * last are nodes that node.val = 9, set last.val++ and all next node.val = 0.
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode plusOneII(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode last = dummy;
		// 1 find last node which node.val != 9
		while (head != null) {
			if (head.val != 9) {
				last = head; 
			}
			head = head.next;
		}
		// 2 last.val+1
		last.val++;
		// 3 set all nodes after last as node.val = 0
		while (last.next != null) {
			last = last.next;
			last.val = 0;
		}		
		return dummy.val == 1 ? dummy : dummy.next;
	}
	
	
	/**
	 * Method2: DFS, get carry bottom up
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 * Stack space: O(n)
	 */
	public ListNode plusOneI(ListNode head) {
		if (head == null) return head;
		int carry = dfs(head);
		if (carry == 0) return head;
		ListNode newHead = new ListNode(1);
		newHead.next = head;
		return newHead;
	}
	
	private int dfs(ListNode head) {
		if (head == null) return 1;
		int carry = dfs(head.next);
		if (carry == 0) return 0;
		if (head.val != 9) {
			head.val += 1;
			return 0;
		}
		head.val = 0;
		return 1;
	}
	
	
	/**
	 * Method1: reverse the inputs, add one, then reverse back
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 */
	public ListNode plusOne(ListNode head) {
        head = reverseLinkedList(head);
        int carry = 1;
        ListNode curr = head;
        while (curr != null && carry != 0) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            curr = curr.next;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = reverseLinkedList(head);
            return newNode;
        }
        return reverseLinkedList(head);
    }
    
    
    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlusOneLinkedList result = new PlusOneLinkedList();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3});
		ListNode.printLinkedList(head1);
		ListNode.printLinkedList(result.plusOne(head1));
		ListNode head2 = ListNode.generateLinkedList(new int[] {9, 9, 9});
		ListNode.printLinkedList(head2);
		ListNode.printLinkedList(result.plusOne(head2));
		System.out.println("----------------------");
		ListNode head11 = ListNode.generateLinkedList(new int[] {1, 2, 3});
		ListNode.printLinkedList(head11);
		ListNode.printLinkedList(result.plusOneI(head11));
		ListNode head12 = ListNode.generateLinkedList(new int[] {9, 9, 9});
		ListNode.printLinkedList(head12);
		ListNode.printLinkedList(result.plusOneI(head12));
		System.out.println("----------------------");
		ListNode head21 = ListNode.generateLinkedList(new int[] {1, 2, 3});
		ListNode.printLinkedList(head21);
		ListNode.printLinkedList(result.plusOneII(head11));
		ListNode head22 = ListNode.generateLinkedList(new int[] {9, 9, 9});
		ListNode.printLinkedList(head12);
		ListNode.printLinkedList(result.plusOneII(head22));
	}

}
