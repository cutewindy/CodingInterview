# Find the middle node of a linked list.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3, return the node with value 2.

# Given 1->2, return the node with value 1.

from ListNode import ListNode

def middleofLinkedList(head):
    if head == None:
        return head

    slow = head
    fast = head.next
    while fast != None and fast.next != None:
        slow = slow.next
        fast = fast.next.next
    return slow


print middleofLinkedList(ListNode.arrayToList([1, 2, 3])).val
print middleofLinkedList(ListNode.arrayToList([1, 2])).val
