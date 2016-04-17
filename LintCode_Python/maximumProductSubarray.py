# Find the contiguous subarray within an array (containing at least one number)
# which has the largest product.

# Have you met this question in a real interview? Yes
# Example
# For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the
# largest product = 6.

import sys

def maximumProductSubarray(nums):
    if not nums:
        return None
    maxProd = []
    minProd = []
    maxProd.append(nums[0])
    minProd.append(nums[0])
    result = nums[0]
    for i in range(1, len(nums)):
        maxProd.append(nums[i])
        minProd.append(nums[i])
        if nums[i] > 0:
            maxProd[i] = max(maxProd[i - 1] * nums[i], nums[i])
            minProd[i] = min(minProd[i - 1] * nums[i], nums[i])
        else:
            maxProd[i] = max(minProd[i - 1] * nums[i], nums[i])
            minProd[i] = min(maxProd[i - 1] * nums[i], nums[i])
        result = max(result, maxProd[i])
    return result

print maximumProductSubarray([1,0,-1,2,3,-5,-2])
# print maximumProductSubarray([2, 3, -2, 4])
