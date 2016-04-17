# The size of the hash table is not determinate at the very beginning. If the total
#  size of keys is too large (e.g. size >= capacity / 10), we should double the
#  size of the hash table and rehash every keys. Say you have a hash table looks
#  like below:

# size=3, capacity=4

# [null, 21, 14, null]
#        |    |
#        9   null
#        |
#       null
# The hash function is:

# int hashcode(int key, int capacity) {
#     return key % capacity;
# }
# here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position
# as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the
#  hash table by linked list.

# rehashing this hash table, double the capacity, you will get:

# size=3, capacity=8

# index:   0    1    2    3     4    5    6   7
# hash : [null, 9, null, null, null, 21, 14, null]
# Given the original hash table, return the new hash table after rehashing .

# Have you met this question in a real interview? Yes
# Example
# Given [null, 21->9->null, 14->null, null],

# return [null, 9->null, null, null, null, 21->null, 14->null, null]

# Note
# For negative integer in hash table, the position can be calculated as follow:

# C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function:
#  a % b = (a % b + b) % b to make it is a non negative integer.
# Python: you can directly use -1 % 3, you will get 2 automatically.

from ListNode import ListNode

def rehashing(hashTable):
    if len(hashTable) == 0:
        return hashTable
    newCapacity = 2 * len(hashTable)
    newHashTable = [None for i in range(newCapacity)]
    for i in range(len(hashTable)):
        while hashTable[i] != None:
            newIndex = (hashTable[i].val % newCapacity + newCapacity) % newCapacity
            if newHashTable[newIndex] == None:
                newHashTable[newIndex] = ListNode(hashTable[i].val)
            else:
                dummy = newHashTable[newIndex]
                while dummy.next != None:
                    dummy = dummy.next
                dummy.next = ListNode(hashTable[i].val)
            hashTable[i] = hashTable[i].next

    return newHashTable

head1 = ListNode.arrayToList([21, 9])
head2 = ListNode.arrayToList([14])
hashTable = [None, head1, head2, None]
print rehashing(hashTable)










