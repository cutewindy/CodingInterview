# Given two strings, find the longest common subsequence (LCS).

# Your code should return the length of LCS.

# Have you met this question in a real interview? Yes
# Example
# For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

# For "ABCD" and "EACB", the LCS is "AC", return 2.
import sys
def longestCommonSubsequence(A, B):
    if not A or not B:
        return 0

    m = len(A)
    n = len(B)

    longCommomSub = [[-sys.maxint for j in range(n + 1)] for i in range(m + 1)]

    # init
    for i in range(m + 1):
        longCommomSub[i][0] = 0
    for j in range(n + 1):
        longCommomSub[0][j] = 0

    # func
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if A[i - 1] == B[j - 1]:
                longCommomSub[i][j] = longCommomSub[i - 1][j - 1] + 1
            else:
                longCommomSub[i][j] = max(longCommomSub[i - 1][j], longCommomSub[i][j - 1])

    # answer
    return longCommomSub[m][n]



print longestCommonSubsequence("ABCDe", "EDCA") #1
print longestCommonSubsequence("ABCD", "EACB") #2
