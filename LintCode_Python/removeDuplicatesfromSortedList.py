# Given a sorted linked list, delete all duplicates such that each element
# appear only once.

# Have you met this question in a real interview? Yes
# Example
# Given 1->1->2, return 1->2.
# Given 1->1->2->3->3, return 1->2->3.

from ListNode import ListNode

def removeDuplicatesfromSortedList(head):
    if head == None:
        return None
    node = head
    while node.next != None:
        if node.val == node.next.val:
            node.next = node.next.next
        else:
            node = node.next

    return head


# head1 = ListNode.arrayToList([1, 1, 2])
# ListNode.printList(removeDuplicatesfromSortedList(head1))
head2 = ListNode.arrayToList([1, 1, 2, 3, 3])
ListNode.printList(removeDuplicatesfromSortedList(head2))

