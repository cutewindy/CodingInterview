# Given an array with integers.

# Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

# Return the largest difference.

# Have you met this question in a real interview? Yes
# Example
# For [1, 2, -3, 1], return 6.

# Note
# The subarray should contain at least one number

# Challenge
# O(n) time and O(n) space.

import sys

def maximumSubarrayDifference(nums):
    if not nums or len(nums) < 2:
        return None

# method2:
    # first: max and min construction
    n = len(nums)
    result = -sys.maxint
    currSum = nums[0]
    left = [nums[0]]
    for i in range(1, n - 1):        # maximum of left
        currSum = max(currSum + nums[i], nums[i])
        left.append(max(currSum, left[i - 1]))
    currSum = nums[n - 1]
    right = [nums[n - 1]]
    for i in range(n - 2, 0, -1):    # minimum of right
        currSum = min(currSum + nums[i], nums[i])
        right.append(min(currSum, right[n - i - 2]))
    for i in range(n - 1):           # max(left - rihgt, result)
        result = max(left[i] - right[n - i - 2], result)

    # second: min and max construction
    currSum = nums[0]
    left = [nums[0]]
    for i in range(1, n - 1):        # minimum of left
        currSum = min(currSum + nums[i], nums[i])
        left.append(min(currSum, left[i - 1]))
    currSum = nums[n - 1]
    right = [nums[n - 1]]
    for i in range(n - 2, 0, -1):    # maximum of right
        currSum = max(currSum + nums[i], nums[i])
        right.append(max(currSum, right[n - i - 2]))
    for i in range(n - 1):           # max(right - left, result)
        result = max(right[n - i - 2] - left[i], result)
    return result


# method1:
#     maxDiff = -sys.maxint
#     for i in range(1, len(nums)):
#         maxDiff = max(maxSubarray(nums[:i]) - minSubarray(nums[i:]), maxDiff)
#         maxDiff = max(maxSubarray(nums[i:]) - minSubarray(nums[:i]), maxDiff)
#     return maxDiff

# def maxSubarray(nums):
#     if not nums:
#         return None
#     currSum = nums[0]
#     maxSum = nums[0]
#     for i in range(1, len(nums)):
#         currSum = max(currSum + nums[i], nums[i])
#         maxSum = max(currSum, maxSum)
#     return maxSum

# def minSubarray(nums):
#     if not nums:
#         return None
#     currSum = nums[0]
#     minSum = nums[0]
#     for i in range(1, len(nums)):
#         currSum = min(currSum + nums[i], nums[i])
#         minSum = min(currSum, minSum)
#     return minSum



print maximumSubarrayDifference([-5,3,-4,0,0,0,-1,20,1,1,-1,-1,-1,-1,-1])
# print maximumSubarrayDifference([1, 2, -3, 1])
