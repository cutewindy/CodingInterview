# Remove all elements from a linked list of integers that have value val.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5

from ListNode import ListNode

def removeLinkedListElements(head, val):
    if head == None or val == None:
        return head
    dummy = ListNode(0)
    dummy.next = head
    head = dummy
    while head.next != None:
        if head.next.val == val:
            head.next = head.next.next
        else:
            head = head.next
    return dummy.next

head = ListNode.arrayToList([1, 2, 3, 3, 4, 5, 3])
ListNode.printList(removeLinkedListElements(head, 3))

