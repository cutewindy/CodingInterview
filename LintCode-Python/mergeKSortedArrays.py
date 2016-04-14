# Given k sorted integer arrays, merge them into one sorted array.

# Have you met this question in a real interview? Yes
# Example
# Given 3 sorted arrays:

# [
#   [1, 3, 5, 7],
#   [2, 4, 6],
#   [0, 8, 9, 10, 11]
# ]
# return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

# Challenge
# Do it in O(N log k).

# N is the total number of integers.
# k is the number of arrays.

try:
    import Queue as Q
except ImportError:
    import queue as Q

class Element:
    def __init__(self, row, col, val):
        self.row = row
        self.col = col
        self.val = val
    def __cmp__(self, other):
        return cmp(self.val, other.val) # use the val as metric, the top is min one

def mergeKSortedArray(arrays):
    if not arrays:
        return arrays
    q = Q.PriorityQueue()
    result = []
    # put the first num of each array into q
    for i in range(len(arrays)):
        if len(arrays[i]) > 0:
            elem = Element(i, 0, arrays[i][0])
            q.put(elem)

    # get the min num from q to result
    # each time get the elem from the q, put the next num with same row in q from arrays(if any)
    while not q.empty():
        elem = q.get()
        result.append(elem.val)
        if elem.col < len(arrays[elem.row]) - 1:
            elem = Element(elem.row, elem.col + 1, arrays[elem.row][elem.col + 1])
            q.put(elem)

    return result


print mergeKSortedArray([[1, 3, 5, 7], [2, 4, 6], [0, 8, 9, 10, 11]])
