# Given a linked list and a value x, partition it such that all nodes less than x
# come before nodes greater than or equal to x.

# You should preserve the original relative order of the nodes in each of the two
# partitions.

# For example,
# Given 1->4->3->2->5->2->null and x = 3,
# return 1->2->2->4->3->5->null.

from ListNode import ListNode

def partitionList(head, x):

    # create two list:left and right
    leftDummy = ListNode(0)
    leftTail = leftDummy
    rightDummy = ListNode(0)
    rightTail = rightDummy

    while head != None:
        if head.val < x:
            leftTail.next = head
            leftTail = leftTail.next
        else:
            rightTail.next = head
            rightTail = rightTail.next
        head = head.next

    # combine two list
    rightTail.next = None
    leftTail.next = rightDummy.next

    return leftDummy.next

ListNode.printList(partitionList(ListNode.arrayToList([1, 4, 3, 2, 5, 2]), 3))
