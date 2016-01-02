# Given a linked list, remove the nth node from the end of list and return its head.

# Have you met this question in a real interview? Yes
# Example
# Given linked list: 1->2->3->4->5->null, and n = 2.

# After removing the second node from the end, the linked list becomes
# 1->2->3->5->null.
# Note
# The minimum number of nodes in list is n.

# Challenge
# O(n) time

from ListNode import ListNode

def removeNthNodefromEndofList(head, n):
    if head == None and not n:
        return head
    dummy = ListNode(0)
    dummy.next = head
    slow = dummy
    fast = dummy
    for i in range(n):
        fast = fast.next
    while fast.next != None:
        slow = slow.next
        fast = fast.next

    slow.next = slow.next.next
    return dummy.next


head = ListNode.arrayToList([1, 2, 3, 4, 5])
ListNode.printList(removeNthNodefromEndofList(head, 2))
