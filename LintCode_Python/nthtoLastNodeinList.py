# Find the nth to last element of a singly linked list.

# The minimum number of nodes in list is n.

# Have you met this question in a real interview? Yes
# Example
# Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.

from ListNode import ListNode

def nthtoLastNodeinList(head, n):
    if head is None or n is None:
        return None
    dummy = ListNode(0)
    dummy.next = head
    fast = head
    slow = head
    for i in range(n):
        fast = fast.next
    while fast is not None:
        fast =fast.next
        slow = slow.next
    return slow


head = ListNode.arrayToList([3, 2, 1, 5])
print nthtoLastNodeinList(head, 2).val
