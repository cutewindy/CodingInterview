# Given a string s, partition s such that every substring of the partition is a palindrome.

# Return all possible palindrome partitioning of s.

# Have you met this question in a real interview? Yes
# Example
# Given s = "aab", return:

# [
#   ["aa","b"],
#   ["a","a","b"]
# ]

def isPalindrome(s):
    start = 0
    end = len(s) - 1
    while start < end:
        if s[start] != s[end]:
            return False
        start += 1
        end -= 1
    return True

def search(s, pos, path, result):
    if pos == len(s):
        result.append(path[:])
        return
    for i in range(pos, len(s)):
        prefix = s[pos : i + 1]
        if isPalindrome(prefix):
            path.append(prefix)
            search(s, i + 1, path, result)
            path.pop()

def palindromePartitioning(s):
    if not s:
        return None
    result = []
    search(s, 0, [], result)
    return result

print palindromePartitioning("aab")
