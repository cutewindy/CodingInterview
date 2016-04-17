# Given two strings, find the longest common substring.

# Return the length of it.

# Have you met this question in a real interview? Yes
# Example
# Given A = "ABCD", B = "CBCE", return 2.

# Note
# The characters in substring should occur continuously in original string.
# This is different with subsequence.

# Challenge
# O(n x m) time and memory.

def longestCommonSubstring(A, B):
    if not A or not B:
        return 0

    m = len(A)
    n = len(B)

    # init
    f = [[0 for j in range(n + 1)] for i in range(m + 1)]
    longest = 0

    # func
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if A[i - 1] == B[j - 1]:
                f[i][j] = f[i - 1][j - 1] + 1
                longest = max(f[i][j], longest)

    # answer:
    return longest






print longestCommonSubstring("ABCD", "CBCE")  #2
