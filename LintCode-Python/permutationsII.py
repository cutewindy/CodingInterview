# Given a list of numbers with duplicate number in it. Find all unique permutations.

# Have you met this question in a real interview? Yes
# Example
# For numbers [1,2,2] the unique permutations are:

# [

#     [1,2,2],

#     [2,1,2],

#     [2,2,1]

# ]

# Challenge
# Do it without recursion.


def permutationsII(nums):
    result = []
    if not nums:
        return result
    visited = [False for i in range(len(nums))]
    helper(sorted(nums), visited, [], result)
    return result

def helper(nums, visited, curr_list, result):
    if len(curr_list) == len(nums):
        # visited = [False for i in range(len(nums))]
        result.append(curr_list[:])
        return
    for i in range(len(nums)):
        if visited[i] == True \
            or (i != 0 and nums[i] == nums[i - 1] and visited[i - 1] == False):
            continue
        visited[i] = True
        curr_list.append(nums[i])
        helper(nums, visited, curr_list, result)
        curr_list.pop()
        visited[i] = False





print permutationsII([1, 2, 2])
