# Given two words word1 and word2, find the minimum number of steps required
# to convert word1 to word2. (each operation is counted as 1 step.)

# You have the following 3 operations permitted on a word:

# Insert a character
# Delete a character
# Replace a character
# Have you met this question in a real interview? Yes
# Example
# Given word1 = "mart" and word2 = "karma", return 3.
import sys

def editDistance(word1, word2):
    if word1 == None or word2 == None:
        return None

    m = len(word1)
    n = len(word2)
    operations = [[sys.maxint for j in range(n + 1)] for i in range(m + 1)]

    # init
    for i in range(m + 1):
        operations[i][0] = i
    for j in range(n + 1):
        operations[0][j] = j

    # func
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if word1[i - 1] == word2[j - 1]:
                operations[i][j] = operations[i - 1][j - 1]
            else:
                operations[i][j] = min(operations[i][j - 1], operations[i - 1][j], operations[i - 1][j - 1]) + 1

    # answer
    return operations[m][n]

print editDistance("mart", "karma") #3








