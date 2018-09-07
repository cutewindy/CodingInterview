import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers. The most significant digit 
 * comes first and each of their nodes contain a single digit. Add the two numbers and return it as 
 * a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * Tags: Linked List
 * @author wendi
 *
 */
public class AddTwoNumbersII {

	/**
	 * Approach2: reverse linkedlist + AddTwoNumbers
	 * @param ListNode l1, ListNode l2
	 * @return ListNode
	 * Time: O(m + n)
	 * Space: O(m + n)
	 */
	public ListNode addTwoNumbersIII(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        while (tail.next != null) {
            ListNode curr = tail.next;
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            tail.next = next;
        }
        return dummy.next;
    }
	
    
	/**
	 * Approach1: Stack
	 * @param ListNode l1, ListNode l2
	 * @return ListNode
	 * Time: O(m + n)
	 * Space: O(m + n)
	 */
	public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		// 1. Use stacks to save value of lists.
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		ListNode node = l1;
		while (node != null) {
			stack1.push(node.val);
			node = node.next;
		}
		node = l2;
		while (node != null) {
			stack2.push(node.val);
			node = node.next;
		}
		// 2. Calculate sum by popping value from stacks, then add them to the head of result list.
		ListNode dummy = new ListNode(0);
		ListNode head = dummy.next;
		int carry = 0;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			int sum = stack1.pop() + stack2.pop() + carry;
			ListNode curr = new ListNode(sum % 10);
			carry = sum / 10;
			dummy.next = curr;
			curr.next = head;
			head = curr;
		}
		while (!stack1.isEmpty()) {
			int sum = stack1.pop() + carry;
			ListNode curr = new ListNode(sum % 10);
			carry = sum / 10;
			dummy.next = curr;
			curr.next = head;
			head = curr;
		}
		while (!stack2.isEmpty()) {
			int sum = stack2.pop() + carry;
			ListNode curr = new ListNode(sum % 10);
			carry = sum / 10;
			dummy.next = curr;
			curr.next = head;
			head = curr;
		}
		if (carry == 1) {
			ListNode curr = new ListNode(1);
			dummy.next = curr;
			curr.next = head;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersII result = new AddTwoNumbersII();
		ListNode l1 = ListNode.generateLinkedList(new int[] {7, 2, 4, 3});
		ListNode l2 = ListNode.generateLinkedList(new int[] {5, 6, 4});
		ListNode.printLinkedList(result.addTwoNumbersII(l1, l2));
		ListNode.printLinkedList(result.addTwoNumbersIII(l1, l2));
	}

}
