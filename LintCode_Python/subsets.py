# Given a set of distinct integers, return all possible subsets.

# Have you met this question in a real interview? Yes
# Example
# If S = [1,2,3], a solution is:

# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ]
# Note
# Elements in a subset must be in non-descending order.
# The solution set must not contain duplicate subsets.
# Challenge
# Can you do it in both recursively and iteratively?

def subsets(S):
    result = []
    if (S == None or len(S) == 0):
        return result
    S.sort()
    helper(S, 0, [], result)
    return result


def helper(S, pos, curr_list, result):
    result.append(curr_list[:])
    for i in range(pos, len(S)):
        curr_list.append(S[i])
        helper(S, i + 1, curr_list, result)
        curr_list.pop()



print subsets([1, 2, 3])














