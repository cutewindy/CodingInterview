# Given an array of integers, find two non-overlapping subarrays which have the
# largest sum.
# The number in each subarray should be contiguous.
# Return the largest sum.

# Have you met this question in a real interview? Yes
# Example
# For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or
#  [1, 3, -1, 2] and [2], they both have the largest sum 7.

import sys

def maximumSubarrayII(nums):
    if not nums or len(nums) < 2:
        return None

    # method2: O(n^2)    O(1)
    result = -sys.maxint
    for i in range(1, len(nums)):
        result = max(maxHelper(nums[:i]) + maxHelper(nums[i:]), result)
    return result

def maxHelper(nums):
    if not nums:
        return None
    currSum = nums[0]
    maxSum = nums[0]
    for i in range(1, len(nums)):
        currSum = max(currSum + nums[i], nums[i])
        maxSum = max(currSum, maxSum)
    return maxSum


    # method1: O(n)     O(n)
    # n = len(nums)
    # currSum = nums[0]
    # left = [nums[0]]
    # for i in range(1, n - 1):
    #     currSum = max(currSum + nums[i], nums[i])
    #     left.append(max(currSum, left[i - 1]))
    # currSum = nums[n - 1]
    # right = [nums[n - 1]]
    # for i in range(n - 2, 0, -1):
    #     currSum = max(currSum + nums[i], nums[i])
    #     right.append(max(currSum, right[n - i - 2]))
    # result = -sys.maxint
    # for i in range(n - 1):
    #     result = max(left[i] + right[n - i - 2], result)
    # return result




print maximumSubarrayII([1, 3, -1, 2, -1, 2])



