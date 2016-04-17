# Merge k sorted linked lists and return it as one sorted list.

# Analyze and describe its complexity.

# Have you met this question in a real interview? Yes
# Example
# Given lists:

# [
#   2->4->null,
#   null,
#   -1->null
# ],
# return -1->2->4->null.

from ListNode import ListNode

def mergeKSortedLists(lists):
    if lists == None:
        return None
    return mergeKHelper(lists, 0, len(lists) - 1)

def mergeKHelper(lists, start, end):
    if start == end:
        return lists[start]
    mid = start + (end - start) / 2
    left = mergeKHelper(lists, start, mid)
    right = mergeKHelper(lists, mid + 1, end)
    return mergeTwoSortedList(left, right)

def mergeTwoSortedList(head1, head2):
    if head1 == None and head2 == None:
        return None
    dummy = ListNode(0)
    tail = dummy
    while head1 != None and head2 != None:
        if head1.val < head2.val:
            tail.next = head1
            head1 = head1.next
        else:
            tail.next = head2
            head2 = head2.next
        tail = tail.next
    if head1 != None:
        tail.next = head1
    else:
        tail.next = head2
    return dummy.next




head1 = ListNode.arrayToList([2, 4])
head2 = ListNode.arrayToList([-1])
ListNode.printList(mergeKSortedLists([head1, head2]))
