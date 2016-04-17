# The Nqueen puzzle is the problem of placing n queens on an n*n chessboard such
# that no two queens attack each other.

# Given an integer n, return all distinct solutions to the n-queens puzzle.

# Each solution contains a distinct board configuration of the n-queens' placement,
# where 'Q' and '.' both indicate a queen and an empty space respectively.

# Have you met this question in a real interview? Yes
# Example
# There exist two distinct solutions to the 4-queens puzzle:

# [
#   // Solution 1
#   [".Q..",
#    "...Q",
#    "Q...",
#    "..Q."
#   ],
#   // Solution 2
#   ["..Q.",
#    "Q...",
#    "...Q",
#    ".Q.."
#   ]
# ]
# Challenge
# Can you do it without recursion?

def drawChessBoard(cols):
    chessBoard = []
    for i in range(len(cols)):
        chessBoard.append("")
        for j in range(len(cols)):
            if cols[j] == i:
                chessBoard[i] += "Q"
            else:
                chessBoard[i] += "."
    return chessBoard


def isValid(col, cols):
    row = len(cols)
    for i in range(row):
        # same column
        if cols[i] == col:
            return False
        # left top to right bottom
        if i - cols[i] == row - col:
            return False
        # right top to left bottom
        if i + cols[i] == row + col:
            return False
    return True

def search(n, cols, result):     # permutation
    if len(cols) == n:
        result.append(drawChessBoard(cols))
        return

    for i in range(n):
        if isValid(i, cols):      # if it is True, Q in row i, col cols[i]
            cols.append(i)
            search(n, cols, result)
            cols.pop()

def NQueens(n):
    if not n:
        return None
    result = []
    search(n, [], result)
    return result

print NQueens(4)
