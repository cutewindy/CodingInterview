# Sort a linked list using insertion sort.

# Have you met this question in a real interview? Yes
# Example
# Given 1->3->2->0->null, return 0->1->2->3->null.


from ListNode import ListNode

def insertionSortList(head):
    if head == None:
        return None
    dummy = ListNode(0)
    dummy.next = head

    return head


head = ListNode.arrayToList([1, 3, 2, 0])
ListNode.printList(insertionSortList(head))
