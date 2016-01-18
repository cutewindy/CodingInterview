# Given an array of integers, find two numbers such that they add up to a specific
# target number.

# The function twoSum should return indices of the two numbers such that they add
# up to the target, where index1 must be less than index2. Please note that your
#  returned answers (both index1 and index2) are NOT zero-based.

# Have you met this question in a real interview? Yes
# Example
# numbers=[2, 7, 11, 15], target=9

# return [1, 2]

# Note
# You may assume that each input would have exactly one solution

# Challenge
# Either of the following solutions are acceptable:

# O(n) Space, O(nlogn) Time
# O(n) Space, O(n) Time


def twoSum(numbers, target):
    if not numbers or len(numbers) == 1:
        return None
    d = dict()
    for i in range(len(numbers)):
        d[numbers[i]] = i
    print d
    result = []
    for i in range(len(numbers)):
        if target - numbers[i] in d:
            result.append(i + 1)
            result.append(d[target - numbers[i]] + 1)
            return result
    return result


    # d = dict()
    # d[0] = -1
    # sums = 0
    # result = []
    # for i in range(len(numbers)):
    #     sums += numbers[i]
    #     if sums - target in d:
    #         result.append(d[sums - target] + 2)
    #         result.append(i + 1)
    #         if result[0] == result[1]:
    #             continue
    #         return result
    #     else:
    #         d[sums] = i
    #     print d
    # return result


# print twoSum([2, 7 ,11, 15], 9)
# print twoSum([1, 0, -1], -1)
print twoSum([1, 0, -1], 0)














