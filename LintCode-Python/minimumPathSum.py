# Given a m x n grid filled with non-negative numbers, find a path from top left
# to bottom right which minimizes the sum of all numbers along its path.

# Have you met this question in a real interview? Yes
# Example
# Note
# You can only move either down or right at any point in time.


def minimumPathSum(grid):
    if not grid or not grid[0]:
        return 0
    m = len(grid)
    n = len(grid[0])
    sum = [[0 for j in range(n)] for i in range(m)]

    # init
    sum[0][0] = grid[0][0]
    for i in range(1, m):
        sum[i][0] = sum[i - 1][0] + grid[i][0]
    for j in range(1, n):
        sum[0][j] = sum[0][j - 1] + grid[0][j]

    # func
    for i in range(1, m):
        for j in range(1, n):
            sum[i][j] = min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j]

    # answer
    return sum[m - 1][n - 1]

print minimumPathSum([[1,3,1],[1,5,1],[4,2,1]])
