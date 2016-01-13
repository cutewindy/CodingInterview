# Write code to remove duplicates from an unsorted linked list.

# Have you met this question in a real interview? Yes
# Example
# Given 1->3->2->1->4.

# Return 1->3->2->4

# Challenge
# (hard) How would you solve this problem if a temporary buffer is not allowed?
# In this case, you don't need to keep the order of nodes.

from ListNode import ListNode

def removeDuplicatesfromUnsortedList(head):
    if head == None:
        return None
    dummy = ListNode(0)
    dummy.next = head
    head = dummy
    s = set()
    while head.next != None:
        if head.next.val in s:
            head.next = head.next.next
        else:
            s.add(head.next.val)
            head = head.next
    return dummy.next


head = ListNode.arrayToList([1, 3, 2, 1, 4])
ListNode.printList(removeDuplicatesfromUnsortedList(head))
