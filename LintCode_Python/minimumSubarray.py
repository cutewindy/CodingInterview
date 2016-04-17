# Given an array of integers, find the subarray with smallest sum.

# Return the sum of the subarray.

# Have you met this question in a real interview? Yes
# Example
# For [1, -1, -2, 1], return -3

# Note
# The subarray should contain at least one integer.

def minimumSubarray(nums):
    if not nums:
        return 0
    currSum = nums[0]
    minSum = nums[0]
    for i in range(1, len(nums)):
        currSum = min(currSum + nums[i], nums[i])
        minSum = min(currSum, minSum)
    return minSum


print minimumSubarray([1, -1, -2, 1])
