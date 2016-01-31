# Given an array of integers and a number k, the majority number is the number
# that occurs more than 1/k of the size of the array.

# Find it.

# Have you met this question in a real interview? Yes
# Example
# Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

# Note
# There is only one majority number in the array.

# Challenge
# O(n) time and O(k) extra space

import sys

def majorityNumberIII(nums, k):
# method1: dictionary
    if not nums:
        return nums
    d = dict()
    for num in nums:
        if num in d:
            d[num] += 1
        else:
            d[num] = 1
    count = -sys.maxint
    result = 0
    for num in nums:
        if d[num] > count:
            result = num
            count = d[num]
    return result


print majorityNumberIII([3, 1, 2, 3, 2, 3, 3, 4, 4, 4], 3)
