# Given an array of integers, the majority number is the number that occurs more
#  than half of the size of the array. Find it.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 1, 1, 1, 2, 2, 2], return 1

# Challenge
# O(n) time and O(1) extra space

import sys

def majorityNumber(nums):
    if not nums:
        return None
# method2:
    count = 0
    result = -1
    for num in nums:
        if count == 0:
            count = 1
            result = num
        elif result == num:
            count += 1
        else:
            count -= 1
    return result

# method1: dictionary
    # d = dict()
    # for num in nums:
    #     if num in d:
    #         d[num] += 1
    #     else:
    #         d[num] = 1
    # count = -sys.maxint
    # for num in d:
    #     if d[num] > count:
    #         result = num
    #         count = d[num]
    # return result


print majorityNumber([1, 1, 1, 1, 2, 2, 2])
