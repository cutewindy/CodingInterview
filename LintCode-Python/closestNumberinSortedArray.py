# Given a target number and an integer array A sorted in ascending order,
# find the index i in A such that A[i] is closest to the given target.

# Return -1 if there is no element in the array.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 2, 3] and target = 2, return 1.

# Given [1, 4, 6] and target = 3, return 1.

# Given [1, 4, 6] and target = 5, return 1 or 2.

# Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

# Note
# There can be duplicate elements in the array, and we can return any of
# the indices with same value.

# Challenge
# O(logn) time complexity.y

def closetNumberinSortedArray(A, target):
    if not A or target is None:
        return -1
    start = 0
    end = len(A)
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] == target:
            return mid
        elif A[mid] < target:
            start = mid
        else:
            end = mid



    if abs(A[start] - target) < abs(A[end] - target):  #=> if target - A[start] < A[end] - target:
        return start
    else:
        return end

    # return start if abs(A[start] - target) < abs(A[end] - target) else end





print closetNumberinSortedArray([1, 2, 3], 2)
print closetNumberinSortedArray([1, 3, 3, 4], 2)
