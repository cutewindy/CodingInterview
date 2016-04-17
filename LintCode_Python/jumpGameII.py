# Given an array of non-negative integers, you are initially positioned at the
# first index of the array.

# Each element in the array represents your maximum jump length at that position.

# Your goal is to reach the last index in the minimum number of jumps.

# Have you met this question in a real interview? Yes
# Example
# Given array A = [2,3,1,1,4]

# The minimum number of jumps to reach the last index is 2. (Jump 1 step from
# index 0 to 1, then 3 steps to the last index.)

# greedy
def jumpGameIIGreedy(A):
    if not A:
        return 0
    jumps = 0
    start, end = 0, 0
    while end < len(A) - 1:
        jumps += 1
        farthest = end
        for i in range(start, end + 1):
            if farthest < A[i] + i:
                farthest = A[i] + i
        start = end + 1
        end = farthest
    return jumps


import sys
# dp
def jumpGameII(A):
    if not A:
        return 0
    n = len(A)
    step = [sys.maxint for i in range(n)]

    # init
    step[0] = 0

    # func
    for i in range(1, n):
        for j in range(i):
            if step[j] != sys.maxint and j + A[j] >= i:
                step[i] = min(step[j] + 1, step[i])

    # answer:
    return step[n - 1]


print jumpGameII([2, 3, 1, 1, 4])
print jumpGameIIGreedy([2, 3, 1, 1, 4])
