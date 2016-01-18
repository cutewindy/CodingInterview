# You have two numbers represented by a linked list, where each node contains a
# single digit. The digits are stored in reverse order, such that the 1's digit
# is at the head of the list. Write a function that adds the two numbers and
#  returns the sum as a linked list.

# Have you met this question in a real interview? Yes
# Example
# Given 7->1->6 + 5->9->2. That is, 617 + 295.

# Return 2->1->9. That is 912.

# Given 3->1->5 and 5->9->2, return 8->0->8.


from ListNode import ListNode

def addTwoNumbers(l1, l2):
    if l1 is None and l2 is None:
        return None
    dummy = ListNode(0)
    point  = dummy
    carry = 0
    while l1 is not None and l2 is not None:
        sum = l1.val + l2.val + carry
        carry = sum / 10
        point.next = ListNode(sum % 10)
        l1 = l1.next
        l2 = l2.next
        point = point.next
    while l1 is not None:
        sum = l1.next + carry
        carry = sum / 10
        point.next = ListNode(sum % 10)
        l1 = l1.next
        point = point.next
    while l2 is not None:
        sum = l2.val + carry
        carry = sum / 10
        point.next = ListNode(sum % 10)
        l2 = l2.next
        point = point.next
    if carry != 0:
        point.next = ListNode(carry)
    return dummy.next




l1 = ListNode.arrayToList([7, 1, 6])
l2 = ListNode.arrayToList([5, 9, 2])
ListNode.printList(addTwoNumbers(l1, l2))
