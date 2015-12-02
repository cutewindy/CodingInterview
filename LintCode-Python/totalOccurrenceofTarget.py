# Given a target number and an integer array sorted in ascending order.
# Find the total number of occurrences of target in the array.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 3, 3, 4, 5] and target = 3, return 2.

# Given [2, 2, 3, 4, 6] and target = 4, return 1.

# Given [1, 2, 3, 4, 5] and target = 6, return 0.

# Challenge
# Time complexity in O(logn)

def totalOccurenceofTarget(A, target):
    rang = [0, 0]
    if not A or target is None:
        return 0
    start = 0
    end = len(A) - 1

    #find the left range
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
    else:                # not find the target
        return 0

    #find the right range
    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] <= target:
            start = mid
        else:
            end = mid
    if A[end] == target:
        rang[1] = end
    elif A[start] == target:
        rang[1] = start
    return rang[1] - rang[0] + 1


print totalOccurenceofTarget([1, 3, 3, 4, 5], 3)
