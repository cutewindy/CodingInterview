# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# Find the minimum element.

# Have you met this question in a real interview? Yes
# Example
# Given [4, 5, 6, 7, 0, 1, 2] return 0

# Note
# You may assume no duplicate exists in the array.

def findMinimuminRotatedSortedArray(num):
    if not num:
        return
    start = 0
    end = len(num) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if num[mid] > num[end]:
            start = mid
        else:
            end = mid

    if num[start] < num[end]:
        return num[start]
    else:
        return num[end]





print findMinimuminRotatedSortedArray([1, 2, 3, 4, 5])


print findMinimuminRotatedSortedArray([4, 5, 6, 7, 0, 1, 2])
