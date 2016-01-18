# Given two sorted integer arrays A and B, merge B into A as one sorted array.

# Have you met this question in a real interview? Yes
# Example
# A = [1, 2, 3, empty, empty], B = [4, 5]

# After merge, A will be filled as [1, 2, 3, 4, 5]

# Note
# You may assume that A has enough space (size that is greater or equal to m + n)
# to hold additional elements from B. The number of elements initialized in A and
#  B are m and n respectively.

def mergeSortedArray(A, m, B, n):
    if not A and not B:
        return
    i = m - 1
    j = n - 1
    index = m + n - 1
    while i >= 0 and j >= 0:
        if A[i] > B[j]:
            A[index] = A[i]
            i -= 1
        else:
            A[index] = B[j]
            j -= 1
        index -= 1
    while j >= 0:
        A[index] = B[j]
        j -= 1
        index -= 1
    return A

print mergeSortedArray([1, 2, 3, 0, 0], 3, [4, 5], 2)







