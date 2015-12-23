# Given a string S and a string T, count the number of distinct subsequences of T
# in S.

# A subsequence of a string is a new string which is formed from the original
#  string by deleting some (can be none) of the characters without disturbing
#  the relative positions of the remaining characters. (ie, "ACE" is a subsequence
#   of "ABCDE" while "AEC" is not).

# Have you met this question in a real interview? Yes
# Example
# Given S = "rabbbit", T = "rabbit", return 3.

# Challenge
# Do it in O(n2) time and O(n) memory.

# O(n2) memory is also acceptable if you do not know how to optimize memory.

def distinctSubsequences(S, T):
    if S == None or T == None:
        return 0
    m = len(S)
    n = len(T)
    f = [[0 for j in range(n + 1)] for i in range(m + 1)]

    # init:
    for i in range(m + 1):
        f[i][0] = 1

    # func
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if S[i - 1] == T[j - 1]:
                f[i][j] = f[i - 1][j - 1] + f[i - 1][j]
            else:
                f[i][j] = f[i - 1][j]

    # answer:
    return f[m][n]



print distinctSubsequences("rabbbit", "rabbit") #3
