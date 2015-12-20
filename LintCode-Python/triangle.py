# Given a triangle, find the minimum path sum from top to bottom. Each step you
# may move to adjacent numbers on the row below.

# Have you met this question in a real interview? Yes
# Example
# For example, given the following triangle

# [
#      [2],
#     [3,4],
#    [6,5,7],
#   [4,1,8,3]
# ]
# The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

# Note
# Bonus point if you are able to do this using only O(n) extra space, where n is
# the total number of rows in the triangle.

import sys

# top-down
def triangleIIII(triangle):
    if not triangle or not triangle[0]:
        return 0
    n = len(triangle)
    result = [[-1 for j in range(len(triangle[i]))] for i in range(n)]

    # init
    result[0][0] = triangle[0][0]

    # func
    for i in range(1, n):
        for j in range(i + 1):
            if j == 0:
                result[i][j] = result[i - 1][j] + triangle[i][j]
            elif j == i:
                result[i][j] = result[i - 1][j - 1] + triangle[i][j]
            else:
                result[i][j] = min(result[i - 1][j - 1], result[i - 1][j]) + triangle[i][j]

    # answer
    best = sys.maxint
    for j in range(n):
        if best > result[n - 1][j]:
            best = result[n - 1][j]
    return best


# bottom-up
def triangleIII(triangle):
    n = len(triangle)
    if not triangle or not triangle[0]:
        return 0
    result = [[0 for j in range(len(triangle[i]))] for i in range(n)]
    for j in range(n):
        result[n - 1][j] = triangle[n - 1][j]
    for i in reversed(range(n - 1)):
        for j in range(i + 1):
            result[i][j] = min(result[i + 1][j], result[i + 1][j + 1]) + triangle[i][j]
    return result[0][0]

# dfs: divide & conquer(optimization)
def triangleII(triangle):
    if not triangle or not triangle[0]:
        return 0
    hashTable = [[-1 for j in range(len(triangle[i]))] for i in range(len(triangle))]
    return dfsHelperII(triangle, 0, 0, hashTable)

def dfsHelperII(triangle, i, j, hashTable):
    if i == len(triangle):
        return 0
    if hashTable[i][j] != -1:
        return hashTable[i][j]
    hashTable[i][j] = min(dfsHelperII(triangle, i + 1, j, hashTable), dfsHelperII(triangle, i + 1, j + 1, hashTable)) + triangle[i][j]
    return hashTable[i][j]



# dfs: divide & conquer
def triangleI(triangle):
    if not triangle or not triangle[0]:
        return 0
    return dfsHelperI(triangle, 0, 0)

def dfsHelperI(triangle, i, j):
    if i == len(triangle):
        return 0
    return min(dfsHelperI(triangle, i + 1, j), dfsHelperI(triangle, i + 1, j + 1)) + triangle[i][j]


print triangleI([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
print triangleII([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
print triangleIII([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
print triangleIIII([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]])
