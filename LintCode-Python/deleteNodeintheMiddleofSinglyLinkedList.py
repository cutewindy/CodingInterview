# Implement an algorithm to delete a node in the middle of a singly linked list,
#  given only access to that node.

# Have you met this question in a real interview? Yes
# Example
# Given 1->2->3->4, and node 3. return 1->2->4

from ListNode import ListNode

def deleteNodeintheMiddleofSinglyLinkedList(node):
    if node is None:
        return
    # node is not last node
    if node.next is not None:
        node.val = node.next.val
        node.next = node.next.next
    # node is the last node
    else:
        node = None


head = ListNode.arrayToList([1, 2, 3, 4])
node = head.next.next
deleteNodeintheMiddleofSinglyLinkedList(node)
ListNode.printList(head)
