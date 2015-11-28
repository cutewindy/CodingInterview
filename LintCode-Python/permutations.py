# Given a list of numbers, return all possible permutations.

# Have you met this question in a real interview? Yes
# Example
# For nums = [1,2,3], the permutations are:

# [
#   [1,2,3],
#   [1,3,2],
#   [2,1,3],
#   [2,3,1],
#   [3,1,2],
#   [3,2,1]
# ]
# Challenge
# Do it without recursion.


def permutations(nums):
    result = []
    if not nums:  #if nums == None or len(nums) == 0:
        return result
    # nums.sort()
    helper(sorted(nums), [], result)
    return result

def helper(nums, curr_list, result):
    if len(curr_list) == len(nums):
        result.append(curr_list[:])
        return
    for i in range(len(nums)):
        if nums[i] in curr_list:
            continue
        curr_list.append(nums[i])
        helper(nums, curr_list, result)
        curr_list.pop()







print permutations([1, 2, 3])
