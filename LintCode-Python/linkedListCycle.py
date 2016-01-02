# Given a linked list, determine if it has a cycle in it.



# Have you met this question in a real interview? Yes
# Example
# Given -21->10->4->5, tail connects to node index 1, return true

# Challenge
# Follow up:
# Can you solve it without using extra space?


from ListNode import ListNode

def linkedListCycle(head):
    if head == None or head.next == None:
        return False
    slow = head
    fast = head.next
    while fast != slow:
        if fast == None or fast.next == None:
            return False
        slow = slow.next
        fast = fast.next.next

    return True

    # if head == None or head.next == None:
    #     return False
    # slow = head
    # fast = head.next
    # while fast != None and fast.next != None:
    #     if slow == fast:
    #         return True
    #     slow = slow.next
    #     fast = fast.next.next

    # return False

head = ListNode.cycle()
print linkedListCycle(head)
