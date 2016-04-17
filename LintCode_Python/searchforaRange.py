# Given a sorted array of n integers, find the starting and ending position of
# a given target value.

# If the target is not found in the array, return [-1, -1].

# Have you met this question in a real interview? Yes
# Example
# Given [5, 7, 7, 8, 8, 10] and target value 8,
# return [3, 4].

# Challenge
# O(log n) time.


def searchforaRange(A, target):
    rang = [-1, -1]
    if not A or (target == None):
        return rang
    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] < target:
            start = mid
        else:
            end = mid
    if A[start] == target:
        rang[0] = start
    elif A[end] == target:
        rang[0] = end

    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] > target:
            end = mid
        else:
            start = mid
    if A[end] == target:
        rang[1] = end
    elif A[start] == target:
        rang[1] = start
    return rang





print searchforaRange([5, 7, 7, 8, 8, 8, 8], 8)
