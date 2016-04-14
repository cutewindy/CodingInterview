# Given a collection of candidate numbers (C) and a target number (T), find all
# unique combinations in C where the candidate numbers sums to T.

# Each number in C may only be used once in the combination.

# Have you met this question in a real interview? Yes
#  Notice

# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
# (ie, a1 <= a2 <= ... <= ak).
# The solution set must not contain duplicate combinations.
# Example
# Given candidate set [10,1,6,7,2,1,5] and target 8,

# A solution set is:

# [
#   [1,7],
#   [1,2,5],
#   [2,6],
#   [1,1,6]
# ]

def search(candidates, target, pos, list, result):
    if target == 0:
        result.append(list[:])
        return
    prev = -1
    for i in range(pos, len(candidates)):
        if i != pos and candidates[i] == prev:
            continue
        if candidates[i] > target:
            break
        list.append(candidates[i])
        search(candidates, target - candidates[i], i + 1, list, result)
        list.pop()
        prev = candidates[i]

def combinationSumII(candidates, target):
    if not candidates or not target:
        return []
    result = []
    candidates.sort()
    print candidates
    search(candidates, target, 0, [], result)
    return result

# print combinationSumII([10, 1, 6, 7, 2, 1, 5], 8)
print combinationSumII([3,1,3,5,1,1], 8)
