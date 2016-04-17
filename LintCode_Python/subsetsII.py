# Given a list of numbers that may has duplicate numbers, return all possible subsets

# Have you met this question in a real interview? Yes
# Example
# If S = [1,2,2], a solution is:

# [
#   [2],
#   [1],
#   [1,2,2],
#   [2,2],
#   [1,2],
#   []
# ]
# Note
# Each element in a subset must be in non-descending order.
# The ordering between two subsets is free.
# The solution set must not contain duplicate subsets.
# Challenge
# Can you do it in both recursively and iteratively?

def subsetsII(S):
    result = []
    if S == None or len(S) == 0:
        return result
    S.sort()
    helper(S, 0, [], result)
    return result

def helper(S, pos, curr_list, result):
    result.append(curr_list[:])
    for i in range(pos, len(S)):
        if i != pos and S[i] == S[i - 1]:
            continue
        curr_list.append(S[i])
        helper(S, i + 1, curr_list, result)
        curr_list.pop()







print subsetsII([1, 2, 2, 2, 2])
