class RandomListNode(object):
    def __init__(self, label, next=None, random=None):
        self.label = label
        self.next = next
        self.random = random

    @classmethod
    def instance(self):
        node1 = RandomListNode(1)
        node2 = RandomListNode(2)
        node3 = RandomListNode(3)
        node4 = RandomListNode(4)
        head = node1
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node1.random = node1
        node2.random = node3
        node3.random = node2
        node4.random = node2
        return head

    # 1    3    2    2
    # |    |    |    |
    # 1 -> 2 -> 3 -> 4 -> None

    @classmethod
    def printListbyNext(self, head):
        while head != None:
            print head.label
            head = head.next

    @classmethod
    def printListbyRandom(self, head):
        while head != None:
            if head.random != None:
                print head.random.label
            head = head.next

if __name__ == '__main__':
    RandomListNode.printListbyNext(RandomListNode.instance())
    RandomListNode.printListbyRandom(RandomListNode.instance())
















