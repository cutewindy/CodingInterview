package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
	
	public static ListNode generateLinkedList(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		for (int i = 0; i < array.length; i++) {
			ListNode node = new ListNode(array[i]);
			curr.next = node;
			curr = node;
		}		
		return dummy.next;		
	}
	
	public static void printLinkedList(ListNode head) {
		if (head == null) {
			return;
		}
		String result = new String();
		while (head != null) {
			result += head.val + " -> ";
			head = head.next;
		}
		result = result.substring(0, result.length() - 3);
		System.out.println(result); 
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3};
		ListNode head = ListNode.generateLinkedList(array);
		ListNode.printLinkedList(head);
	}

}
