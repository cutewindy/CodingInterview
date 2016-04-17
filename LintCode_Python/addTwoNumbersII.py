# You have two numbers represented by a linked list, where each node contains a
# single digit. The digits are stored in forward order, such that the 1's digit
#  is at the head of the list. Write a function that adds the two numbers and
#  returns the sum as a linked list.

# Have you met this question in a real interview? Yes
# Example
# Given 6->1->7 + 2->9->5. That is, 617 + 295.

# Return 9->1->2. That is, 912.


from ListNode import ListNode

def addTwoNumbersII(l1, l2):
    if l1 is None and l2 is None:
        return None
    l1 = reverse(l1)
    l2 = reverse(l2)
    return reverse(addHelper(l1, l2))

def reverse(head):
    if head is None:
        return None
    prev = None
    while head is not None:
        temp = head.next
        head.next = prev
        prev = head
        head = temp
    return prev

def addHelper(l1, l2):
    if l1 is None and l2 is None:
        return None
    dummy = ListNode(0)
    tail = dummy
    carry = 0
    while l1 is not None and l2 is not None:
        s = l1.val + l2.val + carry
        tail.next = ListNode(s % 10)
        carry = s / 10
        l1 = l1.next
        l2 = l2.next
        tail = tail.next
    while l1 is not None:
        s = l1.val + carry
        tail.next = ListNode(s % 10)
        carry = s / 10
        l1 = l1.next
        tail = tail.next
    while l2 is not None:
        s = l2.next + carry
        tail.next = ListNode(s % 10)
        carry = s / 10
        l2 = l2.next
        tail = tail.next
    if carry != 0:
        tail.next = ListNode(carry)

    return dummy.next


l1 = ListNode.arrayToList([6, 1, 7])
l2 = ListNode.arrayToList([2, 9, 5])
ListNode.printList(addTwoNumbersII(l1, l2))
