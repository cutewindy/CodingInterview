# Given a string s, cut s into some substrings such that every substring is a
# palindrome.

# Return the minimum cuts needed for a palindrome partitioning of s.

# Have you met this question in a real interview? Yes
# Example
# Given s = "aab",

# Return 1 since the palindrome partitioning ["aa", "b"] could be produced using
# 1 cut.

def isPalindrome(s, start, end):
    if not s or start > end:
        return False
    if start == end:
        return True
    while start < end:
        if s[start] != s[end]:
            return False
        else:
            start += 1
            end -= 1
    return True

def getIsPalindrome(s): #DP
    if not s:
        return []
    n = len(s)
    isPalindromeTable = [[False for j in range(n)] for i in range(n)]

    # init
    for i in range(n):
        isPalindromeTable[i][i] = True
    for i in range(n - 1):
        isPalindromeTable = (s[i] == s[i + 1])

    # func
    for length in range(2, n):
        for start in range(n - length):
            if s[start] == s[start + length] and isPalindromeTable[start + 1][start + length - 1]:
                isPalindromeTable[start][start + length] = True



    # for i in range(n):
    #     for j in range(i, n):
    #         isPalindromeTable[i][j] = isPalindrome(s, i, j)
    # print isPalindromeTable

    # answer:
    return isPalindromeTable



def palindromePartitionII(s):
    if not s:
        return False
    n = len(s)
    isPalindromeTable = getIsPalindrome(s)

    # init
    minCut = [i - 1 for i in range(len(s) + 1)]
    print minCut

    # func
    for i in range(1, n + 1):
        for j in range(i):
            # print i, j
            if isPalindromeTable[j][i - 1]:
                # print minCut[j + 1] + 1, minCut[i + 1]
                minCut[i] = min(minCut[j] + 1, minCut[i])
    print minCut


    # answer
    return minCut[n]




print palindromePartitionII("aabcddc")
# print getIsPalindrome("aab")
