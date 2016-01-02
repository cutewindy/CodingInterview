class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

    @classmethod
    def arrayToList(self, array):
        if not array:
            return None

        # convert array to linkedList
        head = ListNode(array[0])
        tail = head
        for i in range(1, len(array)):
            tail.next = ListNode(array[i])
            tail = tail.next

        return head

    @classmethod
    def printList(self, head):
        if head == None:
            return
        node = head
        while node != None:
            print node.val,
            node = node.next

    @classmethod
    def cycle(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node5 = ListNode(5)
        node6 = ListNode(6)
        node7 = ListNode(7)
        head = node1
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = node4
        return head
    # 1->2->3->4->5->6->7->4->5->6->7->4...




if __name__ == '__main__':
    # uselessNode = ListNode(0)
    head = ListNode(0).arrayToList([1,2,3])
    # head = ListNode.arrayToList([])

    print head
    ListNode.printList(head)

    # head2 = ListNode.cycle()
    # ListNode.printList(head2)

    # print head.val
    # print head.next.val
    # print head.next.next.val

    # node1 = ListNode(1)
    # # object
    # # instance
    # print node1.val
    # print node1.next

    # node2 = ListNode(2)
    # node1.next = node2
    # # node3 = ListNode(3)
    # # node2.next = node3
