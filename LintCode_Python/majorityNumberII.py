# Given an array of integers, the majority number is the number that occurs more
# than 1/3 of the size of the array.

# Find it.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 2, 1, 2, 1, 3, 3], return 1.

# Note
# There is only one majority number in the array.

# Challenge
# O(n) time and O(1) extra space.

import sys

def majorityNumberII(nums):
    if not nums:
        return None

# method2:
    count1, count2 = 0, 0
    result1, result2 = -1, -1
    for num in nums:
        if result1 == num:
            count1 += 1
        elif result2 == num:
            count2 += 1

        elif count1 == 0:
            result1 = num
            count1 = 1
        elif count2 == 0:
            result2 = num
            count2 = 1
        else:
            count1 -= 1
            count2 -= 1
    count1, count2 = 0, 0
    for num in nums:
        if num == result1:
            count1 += 1
        elif num == result2:
            count2 += 1
    if count1 > count2:
        return result1
    else:
        return result2


# method1: dictionary
    # d = dict()
    # for num in nums:
    #     if num in d:
    #         d[num] += 1
    #     else:
    #         d[num] = 1
    # count = -sys.maxint
    # result = 0
    # for num in d:
    #     if d[num] > count:
    #         result = num
    #         count = d[num]
    # return result


print majorityNumberII([1,1,1,1,2,2,3,3,4,4,4])
# print majorityNumberII([1, 2, 1, 2, 1, 3, 3])
