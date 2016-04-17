# Follow up for "Search in Rotated Sorted Array":
# What if duplicates are allowed?

# Would this affect the run-time complexity? How and why?

# Write a function to determine if a given target is in the array.


def searchinRotatedSortedArrayII(A, target):
    if not A or target is None:  # -> target == None
        return False
    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] == target:
            return True
        elif A[mid] > A[end]:
            if A[start] <= target and target < A[mid]:
                end = mid
            else:
                start = mid
        elif A[mid] < A[end]:
            if A[mid] < target and target <= A[end]:
                start = mid
            else:
                end = mid
        else:
            end -= 1

    if A[start] == target or A[end] == target:
        return True
    else:
        return False



print searchinRotatedSortedArrayII([1, 1, 1, 1, 0, 1, 1], 0)
print searchinRotatedSortedArrayII([4, 5, 5, 0, 1, 2, 3, 3, 4], 3)
print searchinRotatedSortedArrayII([4, 5, 5, 0, 1, 2, 3, 3, 4], 6)
