# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# You are given a target value to search. If found in the array return its index,
# otherwise return -1.

# You may assume no duplicate exists in the array.

# Have you met this question in a real interview? Yes
# Example
# For [4, 5, 1, 2, 3] and target=1, return 2.

# For [4, 5, 1, 2, 3] and target=0, return -1.

# Challenge
# O(logN) time

def searchinRotatdSortedArray(A, target):
    if not A or not target:
        return -1

    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] == target:
            return mid
        elif A[mid] > A[end]:
            if A[start] <= target and target < A[mid]:
                end = mid
            else:
                start = mid
        else:
            if A[mid] < target and target <= A[end]:
                start = mid
            else:
                end = mid

    if A[start] == target:
        return start
    elif A[end] == target:
        return end
    else:
        return  -1





print searchinRotatdSortedArray([4, 5, 1, 2, 3], 1)
print searchinRotatdSortedArray([4, 5, 1, 2, 3], 0)
