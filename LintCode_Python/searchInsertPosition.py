# Given a sorted array and a target value, return the index if the target is found.
# If not, return the index where it would be if it were inserted in order.

# You may assume NO duplicates in the array.

# Have you met this question in a real interview? Yes
# Example
# [1,3,5,6], 5 -> 2

# [1,3,5,6], 2 -> 1

# [1,3,5,6], 7 -> 4

# [1,3,5,6], 0 -> 0

# Challenge
# O(log(n)) time


def searchInsertPosition(A, target):
    if (A == None) or (target == None):
        return False
    if A == []:
        return 0
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

    if A[start] >= target:
        return start
    elif A[end] >= target:
        return end
    else:
        return end + 1





print searchInsertPosition([1, 3, 5 ,6], 5)
print searchInsertPosition([1, 3, 5, 6], 2)
