# Given a sequence of integers, find the longest increasing subsequence (LIS).

# You code should return the length of the LIS.

# Have you met this question in a real interview? Yes
# Example
# For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

# For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

# Challenge
# Time complexity O(n^2) or O(nlogn)


def longestIncreasingSubsequence(nums):
    if not nums:
        return 0

    m = len(nums)

    # init
    f = [1 for i in range(m)]
    longest = 1

    # func
    for i in range(1, m):
        for j in range(i):
            if nums[i] >= nums[j]:
                f[i] = max(f[j] + 1, f[i])
                longest = max(f[i], longest)

    # answer
    return longest




print longestIncreasingSubsequence([5, 4, 1, 2, 3])  #3
print longestIncreasingSubsequence([4, 2, 4, 5, 3, 7])  #4
