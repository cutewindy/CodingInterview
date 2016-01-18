# Given an integer array, find a subarray where the sum of numbers is zero.
#  Your code should return the index of the first number and the index of the
#  last number.

# Have you met this question in a real interview? Yes
# Example
# Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].

# Note
# There is at least one subarray that it's sum equals to zero.

def subarraySum(nums):
    if not nums:
        return None
    d = dict()
    d[0] = -1
    sums = 0
    result = []
    for i in range(len(nums)):
        sums += nums[i]
        if sums in d:
            result.append(d[sums] + 1)
            result.append(i)
            return result
        else:
            d[sums] = i
    return result

    # if not nums:
    #     return None
    # for i in range(len(nums)):
    #     sums = 0
    #     for j in range(i, len(nums)):
    #         sums += nums[j]
    #         if sums == 0:
    #             return [i, j]



print subarraySum([-3, 1, 2, -3, 4])

