# Write an efficient algorithm that searches for a value in an m x n matrix,
# return the occurrence of it.

# This matrix has the following properties:

# Integers in each row are sorted from left to right.
# Integers in each column are sorted from up to bottom.
# No duplicate integers in each row or column.
# Have you met this question in a real interview? Yes
# Example
# Consider the following matrix:

# [
#   [1, 3, 5, 7],
#   [2, 4, 7, 8],
#   [3, 5, 9, 10]
# ]
# Given target = 3, return 2.

# Challenge
# O(m+n) time and O(1) extra space

def searcha2DMatrixII(matrix, target):
    count = 0
    if not matrix or not target:
        return count
    m = len(matrix)
    n = len(matrix[0])
    i = m - 1
    j = 0
    while i >= 0 and j <= n - 1:
        if matrix[i][j] == target:
            count += 1
            i -= 1
            j += 1
        elif matrix[i][j] < target:
            j += 1
        else:
            i -= 1
    return count









print searcha2DMatrixII([[1, 3, 5 ,7], [2, 4, 7, 8], [3, 5, 9, 10]], 3)
print searcha2DMatrixII([[1, 3, 5 ,7], [2, 4, 7, 8], [3, 5, 9, 10]], 11)

