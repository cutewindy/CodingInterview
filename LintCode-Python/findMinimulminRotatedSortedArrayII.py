# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# Find the minimum element.

# The array may contain duplicates.

# Have you met this question in a real interview? Yes
# Example
# Given [4,4,5,6,7,0,1,2] return 0


# def findMinimuminRotatedSortedArrayII(num):
#     if not num:
#         return
#     minimum = num[0]
#     for i in range(len(num)):
#         if num[i] < minimum:
#             minimum = num[i]
#     return minimum


def findMinimuminRotatedSortedArrayII(num):
    if not num:
        return
    start = 0
    end = len(num) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if num[mid] > num[end]:
            start = mid
        elif num[mid] < num[end]:
            end = mid
        else:
            end -= 1

    if num[start] < num[end]:
        return num[start]
    else:
        return num[end]




print findMinimuminRotatedSortedArrayII([1, 1, 1, 1, 0, 1, 1])
print findMinimuminRotatedSortedArrayII([4, 4, 5, 6, 7, 0, 1, 2])
