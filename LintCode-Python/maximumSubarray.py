# Given an array of integers, find a contiguous subarray which has the largest sum.

# Have you met this question in a real interview? Yes
# Example
# Given the array [-2, 2, -3, 4, -1, 2, 1, -5, 3], the contiguous subarray [4, -1, 2, 1] has
# the largest sum = 6.

# Note
# The subarray should contain at least one number.

# Challenge
# Can you do it in time complexity O(n)?


# method1:
def maximumSubarray(nums):
    if not nums:
        return 0
    localSum = []
    localSum.append(nums[0])
    globalSum = nums[0]
    for i in range(1, len(nums)):
        localSum.append(max(localSum[i - 1] + nums[i], nums[i]))
        globalSum = max(localSum[i], globalSum)
    return globalSum


print maximumSubarray([-2, 2, -3, 4, -1, 2, 1, -5, 3])

