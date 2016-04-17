# Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

# Have you met this question in a real interview? Yes
# Example
# Given [1,2,2,3,4,4,5,3] return 1 and 5

# Challenge
# O(n) time, O(1) extra space.


def singleNumberIII(A):
    if not A:
        return None
    xor = 0
    for i in range(len(A)):        # compute the xor of two numbers
        xor ^= A[i]
    lastbit = xor - (xor & (xor - 1))    # find the last diff bit between two numbers
    group0 = 0                     # group0 ^ the number without the lastbit
    group1 = 0                     # group1 ^ the number with the lastbit
    for i in range(len(A)):
        if A[i] & lastbit == 0:
            group0 ^= A[i]
        else:
            group1 ^= A[i]
    return group0, group1



print singleNumberIII([1, 2, 2, 3, 4, 4, 5, 8, 8, 3])

