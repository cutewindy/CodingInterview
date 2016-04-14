# Design and implement a data structure for Least Recently Used (LRU) cache.
# It should support the following operations: get and set.

# get(key) - Get the value (will always be positive) of the key if the key exists
# in the cache, otherwise return -1.
# set(key, value) - Set or insert the value if the key is not already present.
#  When the cache reached its capacity, it should invalidate the least recently
#  used item before inserting a new item.

class LinkedNode:
    def __init__(self, key=None, val=None, prev=None, next=None):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = next

class LRUCache:
    def __init__ (self, capacity):
        self.capacity = capacity
        self.d = dict()
        self.head = LinkedNode(-1, -1)
        self.tail = LinkedNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        # set the LRU node at the tail of list, that is head->......->node->tail
        # the least recent used node is after the head, that is head.next

    def get(self, key):
        if key not in self.d:
            return -1
        curr = self.d[key]

        # change "prev->curr->next...->tail"
        # to "prev->next->...->curr->tail"
        # 1 remove curr node from link list
        curr.prev.next = curr.next
        curr.next.prev = curr.prev
        # 2 move curr to the tail of link list
        self.movetoTail(curr)

        return curr.val


    def set(self, key, value):
        # if key is in dictionary, overwrite value and set it as LRU
        if key in self.d:
            self.d[key].val = value
            self.get(key)
            return
        # if the cache is full, remove the val in dictionary and first node
        if len(self.d) == self.capacity:
            del self.d[self.head.next.key]
            self.head.next = self.head.next.next
            self.head.next.prev = self.head
        # save val in dictionary and set the new node at the end of link list
        curr = LinkedNode(key, value)
        self.d[key] = curr
        self.movetoTail(curr)


    # move curr to the tail of link list
    def movetoTail(self, curr):
        self.tail.prev.next = curr
        curr.next = self.tail
        curr.prev = self.tail.prev
        self.tail.prev = curr

    def printLinkList(self):  # print the link list without head and tail
        node = self.head
        while node.next != self.tail:
            print node.next.val
            node = node.next

LRU = LRUCache(5)
print "get 3: ", LRU.get(3)
print "set (1, 1)", LRU.set(1, 1)
print "set (2, 2)", LRU.set(2, 2)
print "set (3, 3)", LRU.set(3, 3)
print "set (4, 4)", LRU.set(4, 4)
print "get 1: ", LRU.get(1)
print "set (5, 5)", LRU.set(5, 5)
print "set (6, 6)", LRU.set(6, 6)
print "set (7, 7)", LRU.set(7, 7)
LRU.printLinkList()
