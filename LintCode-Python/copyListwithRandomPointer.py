# A linked list is given such that each node contains an additional random pointer
# which could point to any node in the list or null.

# Return a deep copy of the list.

# Have you met this question in a real interview? Yes
# Example
# Challenge
# Could you solve it with O(1) space?

from RandomListNode import RandomListNode

def copyListwithRandomPointer(head):
    if head == None:
        return None
    copyNext(head)
    copyRandom(head)
    return splitList(head)

def copyNext(head):
    while head != None:
        newNode = RandomListNode(head.label)
        newNode.next = head.next
        newNode.random = head.random
        head.next = newNode
        head = head.next.next

def copyRandom(head):
    while head != None:
        if head.random != None:
            head.next.random = head.random.next
        head = head.next.next

def splitList(head):
    newHead = head.next
    while head != None:
        temp = head.next
        head.next = temp.next
        head = head.next
        if temp.next != None:
            temp.next = temp.next.next
    return newHead

head = RandomListNode.instance()
RandomListNode.printListbyNext(copyListwithRandomPointer(head))
RandomListNode.printListbyRandom(copyListwithRandomPointer(head))
