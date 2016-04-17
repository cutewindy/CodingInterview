# Reverse a linked list from position m to n.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

# Note
# Given m, n satisfy the following condition: 1 <= m <= n <= length of list.

# Challenge
# Reverse it in-place and in one-pass

from ListNode import ListNode

def reverseLinkedListII(head, m, n):
    if head == None:
        return None
    dummy = ListNode(0)
    dummy.next = head
    head = dummy

    # find premmNode and mNode
    for i in range(1, m):
        head = head.next
    prevmNode = head
    mNode = head.next

    # reverse link from m to n
    nNode = mNode
    nextnNode = nNode.next
    for i in range(m, n):
        temp = nextnNode.next
        nextnNode.next = nNode
        nNode = nextnNode
        nextnNode = temp

    # combine
    prevmNode.next = nNode
    mNode.next = nextnNode

    return dummy.next


head = ListNode.arrayToList([1, 2, 3, 4, 5])
ListNode.printList(reverseLinkedListII(head, 2, 4))




