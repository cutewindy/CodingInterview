# Follow up for "Unique Paths":

# Now consider if some obstacles are added to the grids. How many unique paths
# would there be?

# An obstacle and empty space is marked as 1 and 0 respectively in the grid.

# Have you met this question in a real interview? Yes
# Example
# For example,
# There is one obstacle in the middle of a 3x3 grid as illustrated below.

# [
#   [0,0,0],
#   [0,1,0],
#   [0,0,0]
# ]
# The total number of unique paths is 2.

# Note
# m and n will be at most 100.

def uniquePathsII(obstacleGrid):
    if not obstacleGrid or not obstacleGrid[0]:
        return 0
    m = len(obstacleGrid)
    n = len(obstacleGrid[0])
    path = [[0 for j in range(n)] for i in range(m)]

    # init
    for i in range(m):
        if obstacleGrid[i][0] == 1:
            break
        else:
            path[i][0] = 1
    for j in range(n):
        if obstacleGrid[0][j] == 1:
            break
        else:
            path[0][j] = 1

    # func
    for i in range(1, m):
        for j in range(1, n):
            if obstacleGrid[i][j] != 1:
                path[i][j] = path[i - 1][j] + path[i][j -1]

    # answer
    return path[m - 1][n - 1]



print uniquePathsII([
  [0,0,0],
  [0,1,0],
  [0,0,0]
])

