# Sort a linked list using insertion sort.

# Have you met this question in a real interview? Yes
# Example
# Given 1->3->2->0->null, return 0->1->2->3->null.


from ListNode import ListNode

def insertionSortList(head):
    if head == None or head.next == None:
        return head
    dummy = ListNode(0)
    dummy.next = head
    prev = head
    head = head.next
    while head != None:
        temp1 = head.next
        iNode = dummy
        while iNode.next != head:

            if iNode.next.val > head.val:
                temp2 = iNode.next
                iNode.next = head
                head.next = temp2
                prev.next = temp1
            else:
                iNode = iNode.next
        prev = head
        head = temp2




    return head
print 1

head = ListNode.arrayToList([1, 3, 2, 0])
ListNode.printList(insertionSortList(head))
