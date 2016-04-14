# Given a set of candidate numbers (C) and a target number (T), find all unique
# combinations in C where the candidate numbers sums to T.

# The same repeated number may be chosen from C unlimited number of times.



# For example, given candidate set 2,3,6,7 and target 7,
# A solution set is:
# [7]
# [2, 2, 3]

# Have you met this question in a real interview? Yes
#  Notice

# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
# (ie, a1 <= a2 <= ... <= ak).
# The solution set must not contain duplicate combinations.
# Example
# given candidate set 2,3,6,7 and target 7,
# A solution set is:
# [7]
# [2, 2, 3]


def search(candidates, target, pos, list, result):
    if target == 0:
        result.append(list[:])
        return
    prev = -1
    for i in range(pos, len(candidates)):
        if i != pos and candidates[i] == prev:   # remove the duplicate candidate in the same level
            continue
        if candidates[i] > target:     # optimization
            break
        list.append(candidates[i])
        search(candidates, target - candidates[i], i, list, result)
        list.pop()
        prev = candidates[i]


def combinationSum(candidates, target):
    if not candidates or not target:
        return []
    result = []
    candidates.sort()
    search(candidates, target, 0, [], result)
    return result



print combinationSum([2, 2, 3, 6, 7], 7)
