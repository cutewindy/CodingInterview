# Given a linked list, swap every two adjacent nodes and return its head.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3->4, you should return the list as 2->1->4->3.

# Challenge
# Your algorithm should use only constant space. You may not modify the values
# in the list, only nodes itself can be changed.

from ListNode import ListNode

def swapNodesinPairs(head):
    if head == None:
        return None
    dummy = ListNode(0)
    dummy.next = head
    head = dummy
    while head != None and head.next != None:
        n1 = head.next
        n2 = head.next.next
        # head -> n1 -> n2 ... => head -> n2 -> n1 ...
        head.next = n2
        n1.next = n2.next
        n2.next = n1

        # move to next pair
        head = n1
    return dummy.next


head = ListNode.arrayToList([1, 2, 3, 4])
ListNode.printList(swapNodesinPairs(head))
