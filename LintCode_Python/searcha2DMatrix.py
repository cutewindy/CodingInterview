# Write an efficient algorithm that searches for a value in an m x n matrix.

# This matrix has the following properties:

# Integers in each row are sorted from left to right.
# The first integer of each row is greater than the last integer of the previous
# row.
# Have you met this question in a real interview? Yes
# Example
# Consider the following matrix:

# [
#     [1, 3, 5, 7],
#     [10, 11, 16, 20],
#     [23, 30, 34, 50]
# ]
# Given target = 3, return true.


def searcha2DMatrix(matrix, target):
    if not matrix or not target:
        return False
    m = len(matrix)
    n = len(matrix[0])
    start = 0
    end = m * n - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if matrix[mid / n][mid % n] == target:
            return True
        elif matrix[mid / n][mid % n] < target:
            start = mid
        else:
            end = mid

    if (matrix[start / n][start % n] == target) or (matrix[end / n][end % n] == target):
        return True
    else:
        return False







print searcha2DMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3)
print searcha2DMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 12)

