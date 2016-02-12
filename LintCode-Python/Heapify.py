# Given an integer array, heapify it into a min-heap array.

# For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1]
# is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
# Have you met this question in a real interview? Yes
# Example
# Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

# Challenge
# O(n) time complexity

# Clarification
# What is heap?

# Heap is a data structure, which usually have three methods: push, pop and top.
# where "push" add a new element the heap, "pop" delete the minimum/maximum element
# in the heap, "top" return the minimum/maximum element.

# What is heapify?
# Convert an unordered integer array into a heap array. If it is min-heap, for each
# element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

# What if there is a lot of solutions?
# Return any of them.

import heapq
def siftup(A, i):
    while i != 0:
        father = (i - 1) / 2
        if A[i] < A[father]:
            A[i], A[father] = A[father], A[i]
        i = father
    return

def siftdown(A, i):
    while i < len(A):
        # find the smallest elem in i, leftchild and rightchild
        smallest = i
        if i * 2 + 1 < len(A) and A[smallest] > A[i * 2 + 1]:
            smallest = i * 2 + 1
        if i * 2 + 2 < len(A) and A[smallest] > A[i * 2 + 2]:
            smallest = i * 2 + 2
        if smallest == i:
            return
        A[i], A[smallest] = A[smallest], A[i]
        i = smallest
    return


def heapify(A):
    if not A:
        return None

    # for i in range(len(A)):
    #     siftup(A, i)

    for i in range((len(A) - 2) / 2, -1, -1):
        siftdown(A, i)
    return A

print heapify([3, 2, 1, 4, 5])
















