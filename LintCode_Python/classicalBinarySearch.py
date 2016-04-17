# Find any position of a target number in a sorted array. Return -1
# if target does not exist.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 2, 2, 4, 5, 5].

# For target = 2, return 1 or 2.

# For target = 5, return 4 or 5.

# For target = 6, return -1.

# Challenge
# O(logn) time

def classicalBinarySearch(A, target):
    if not A or target is None:
        return -1
    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] == target:
            return mid
        elif A[mid] < target:
            start = mid
        else:
            end = mid

    if A[start] == target:
        return start
    elif A[end] == target:
        return end
    else:
        return -1





print classicalBinarySearch([1, 2, 2, 4, 5, 5], 2)
print classicalBinarySearch([1, 2, 2, 4, 5, 5], 5)
print classicalBinarySearch([1, 2, 2, 4, 5, 5], 6)
