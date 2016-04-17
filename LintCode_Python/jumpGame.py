# Given an array of non-negative integers, you are initially positioned at the
# first index of the array.

# Each element in the array represents your maximum jump length at that position.

# Determine if you are able to reach the last index.

# Have you met this question in a real interview? Yes
# Example
# A = [2,3,1,1,4], return true.

# A = [3,2,1,0,4], return false.

# Note
# This problem have two method which is Greedy and Dynamic Programming.

# The time complexity of Greedy method is O(n).

# The time complexity of Dynamic Programming method is O(n^2).

# We manually set the small data set to allow you pass the test in both ways.
# This is just to let you learn how to use this problem in dynamic programming
# ways. If you finish it in dynamic programming ways, you can try greedy method
# to make it accept again.


# greedy
def jumpGameI(A):
    if not A:
        return False
    n = len(A)
    farthest = A[0]
    for i in range(n):
        if i <= farthest and i + A[i] >= farthest:
            farthest = i + A[i]
    return farthest >= n - 1





# DP
def jumpGame(A):
    if not A:
        return False
    n = len(A)
    can = [False for i in range(n)]

    # init
    can[0] = True

    # func
    for i in range(1, n):
        for j in range(i):
            if can[j] and j + A[j] >= i:
                can[i] = True
                break

    # answer:
    return can[n - 1]


print jumpGame([2, 3, 1, 1, 4])
print jumpGame([3, 2, 1, 0, 4])

print jumpGameI([2, 3, 1, 1, 4])
print jumpGameI([3, 2, 1, 0, 4])
