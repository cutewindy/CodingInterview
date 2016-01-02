# Given a  singly linked list L: L0 -> L1 -> ... ->Ln-1 -> Ln,
# reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...

# You must do this in-place without altering the nodes' values.

# For example,
# Given 1 -> 2 -> 3 -> 4 -> null, reorder it to 1 -> 4 -> 2 -> 3 -> null.

from ListNode import ListNode

def reorderList(head):
    if head == None:
        return None


head = ListNode.arrayToList([1, 4, 2, 3])
ListNode.printList(reorderList(head))
