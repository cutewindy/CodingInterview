# Given a linked list, return the node where the cycle begins.

# If there is no cycle, return null.

# Have you met this question in a real interview? Yes
# Example
# Given -21->10->4->5, tail connects to node index 1, return 10

# Challenge
# Follow up:

# Can you solve it without using extra space?


from ListNode import ListNode

def linkedListCycleII(head):
    if head == None or head.next == None:
        return None
    dummy = ListNode(0)
    dummy.next = head
    slow = head
    fast = head.next
    head = dummy

    while slow != fast:
        if fast == None or fast.next == None:
            return None
        slow = slow.next
        fast = fast.next.next

    while slow != head:
        slow = slow.next
        head = head.next

    return head.val


head = ListNode.cycle()
print linkedListCycleII(head)

