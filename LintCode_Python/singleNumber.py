# Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

# Have you met this question in a real interview? Yes
# Example
# Given [1,2,2,1,3,4,3], return 4

# Challenge
# One-pass, constant extra space.


def singleNumber(A):
    if not A:
        return None
    result = 0
    for i in range(len(A)):
        result ^= A[i]
    return result

print singleNumber([1, 2, 2, 1, 3, 4, 3])
