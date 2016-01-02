# Given a sorted linked list, delete all nodes that have duplicate numbers,
# leaving only distinct numbers from the original list.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3->3->4->4->5, return 1->2->5.
# Given 1->1->1->2->3, return 2->3.

from ListNode import ListNode


def removeDupfromSortedListII(head):
    if head == None:
        return None

    dummy = ListNode(0)
    dummy.next = head
    head = dummy

    while head.next != None and head.next.next != None:
        if head.next.val == head.next.next.val:
            val = head.next.val
            while head.next != None and head.next.val == val:
                head.next = head.next.next
        else:
            head = head.next

    return dummy.next


head1 = ListNode.arrayToList([1, 2, 3, 3, 4, 4, 5])
head2 = ListNode.arrayToList([1, 1, 1, 2, 3])

ListNode.printList(removeDupfromSortedListII(head2))






