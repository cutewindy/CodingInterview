# Sort a linked list in O(n log n) time using constant space complexity.

# Have you met this question in a real interview? Yes
# Example
# Given 1-3->2->null, sort it to 1->2->3->null.


from ListNode import ListNode

# Method2: quick sort
def sortListI(head):
    if head == None or head.next == None:
        return head
    mid = findMiddle(head)
    head = partition(head, mid.val)
    right = sortListI(mid.next)
    mid.next = None
    left = sortListI(head)
    mid.next = right
    return left

# partition list to <, = and >
def partition(head, x):
    if head == None or head.next == None:
        return head
    dummyLeft = ListNode(0)
    lastLeftNode = dummyLeft
    dummyMid = ListNode(0)
    lastMidNode = dummyMid
    dummyRight = ListNode(0)
    lastRightNode = dummyRight
    while head != None:
        if head.val < x:
            lastLeftNode.next = head
            lastLeftNode = lastLeftNode.next
        elif head.val == x:
            lastMidNode.next = head
            lastMidNode = lastMidNode.next
        else:
            lastRightNode.next = head
            lastRightNode = lastRightNode.next
        head = head.next
    lastLeftNode.next = dummyMid.next
    lastMidNode.next = dummyRight.next
    lastRightNode.next = None
    return dummyLeft.next



# Method1: merge sort
def sortList(head):
    if head == None or head.next == None:
        return head
    mid = findMiddle(head)
    right = sortList(mid.next)
    mid.next = None
    left = sortList(head)
    return merge(left, right)


# helper: find the middle of linked list
def findMiddle(head):
    if head == None or head.next == None:
        return head
    slow = head
    fast = head.next
    while fast != None and fast.next != None:
        slow = slow.next
        fast = fast.next.next
    return slow


# helper: merge two sorted linked list
def merge(head1, head2):
    if head1 == None and head2 == None:
        return None

    dummy = ListNode(0)
    lastNode = dummy
    while head1 != None and head2 != None:
        if head1.val < head2.val:
            lastNode.next = head1
            head1 = head1.next
        else:
            lastNode.next = head2
            head2 = head2.next
        lastNode = lastNode.next
    if head1 != None:
        lastNode.next = head1
    else:
        lastNode.next = head2
    return dummy.next


head = ListNode.arrayToList([1, 3, 2, 4, 5, 7, 6])
ListNode.printList(sortList(head))
ListNode.printList(sortListI(head))
