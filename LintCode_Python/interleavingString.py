# Given three strings: s1, s2, s3, determine whether s3 is formed by the
# interleaving of s1 and s2.

# Have you met this question in a real interview? Yes
# Example
# For s1 = "aabcc", s2 = "dbbca"

# When s3 = "aadbbcbcac", return true.
# When s3 = "aadbbbaccc", return false.
# Challenge
# O(n2) time or better


def interleavingString(s1, s2, s3):
    if s1 == None or s2 == None or s3 == None:
        return False
    if len(s1) + len(s2) != len(s3):
        return False
    m = len(s1)
    n = len(s2)
    f = [[False for j in range(n + 1)] for i in range(m + 1)]

    # init
    f[0][0] = True
    for i in range(1, m + 1):
        if s1[i - 1] == s3[i - 1]:
            f[i][0] = True
    for j in range(1, n + 1):
        if s2[j - 1] == s3[j - 1]:
            f[0][j] = True

    # func
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s3[i + j - 1] and f[i - 1][j]:
                f[i][j] = True
            elif s2[j - 1] == s3[i + j - 1] and f[i][j - 1]:
                f[i][j] = True

    # answer:
    return f[m][n]





print interleavingString("aabcc", "dbbca", "aadbbcbcac")
print interleavingString("aabcc", "dbbca", "aadbbbaccc")
