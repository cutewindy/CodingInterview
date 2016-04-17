# Given a string s and a dictionary of words dict, determine if s can be break
# into a space-separated sequence of one or more dictionary words.

# Have you met this question in a real interview? Yes
# Example
# Given s = "lintcode", dict = ["lint", "code"].

# Return true because "lintcode" can be break as "lint code".

def wordBreak(s, dictList):
    if len(dictList) == 0:
        return len(s) == 0

    n = len(s)
    maxLength = max(len(word) for word in dictList)
    canSegment = [False for i in range(n + 1)]

    # init
    canSegment[0] = True

    # func
    for i in range(1, n + 1):
        length = min(i, maxLength)     #optimization
        for lastWordLenght in range(1, length + 1):
            if canSegment[i - lastWordLenght] == True:
                word = s[i - lastWordLenght:i]
                if word in dictList:
                    canSegment[i] = True
                    break

    # answer
    return canSegment[n]


print wordBreak("lintcodeeee", ["lint", "codeeee"])
