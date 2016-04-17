# Reverse a linked list.

# Have you met this question in a real interview? Yes
# Example
# For linked list 1->2->3, the reversed linked list is 3->2->1

# Challenge
# Reverse it in-place and in one-pass

from ListNode import ListNode

def reverseLinkedList(head):
    prev = None
    while head != None:
        temp = head.next
        head.next = prev
        prev = head
        head = temp
    return prev


head = ListNode.arrayToList([1, 2, 3])
ListNode.printList(reverseLinkedList(head))

