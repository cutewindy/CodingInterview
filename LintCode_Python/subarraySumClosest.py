# Given an integer array, find a subarray with sum closest to zero. Return the
#  indexes of the first number and last number.

# Have you met this question in a real interview? Yes
# Example
# Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

# Challenge
# O(nlogn) time

class Pair(object):
    def __init__(self, sum, index):
        self.sum = sum
        self.index = index

import sys

def subarraySumClosest(nums):
    if not nums:
        return None
    n = len(nums)
    result = []
    if n == 1:
        result.append(0)
        result.append(0)
        return result
    sums = [Pair(0, 0)]
    for i in range(1, n + 1):
        sums.append(Pair(sums[i - 1].sum + nums[i - 1], i))
    sums.sort(key=lambda x: x.sum)
    # for i in range(1, n + 1):
    #     print sums[i].sum, i
    rang = sys.maxint
    for i in range(1, n + 1):
        if sums[i].sum - sums[i - 1].sum < rang:
            rang = sums[i].sum - sums[i - 1].sum
            result = []
            temp = [sums[i - 1].index, sums[i].index]
            temp.sort()
            result.append(temp[0])
            result.append(temp[1] - 1)

    return result



print subarraySumClosest([-3, 1, 1, -3, 5])
