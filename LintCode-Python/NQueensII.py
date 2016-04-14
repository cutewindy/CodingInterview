# Follow up for N-Queens problem.

# Now, instead outputting board configurations, return the total number of distinct
# solutions.

# Have you met this question in a real interview? Yes
# Example
# For n=4, there are 2 distinct solutions.

def isValid(col, cols):
    row = len(cols)
    for i in range(row):
        if cols[i] == col:
            return False
        if i - cols[i] == row - col:
            return False
        if i + cols[i] == row + col:
            return False
    return True

def search(n, cols, result):
    if len(cols) == n:
        result.append(cols[:])
        return
    for i in range(n):
        if isValid(i, cols):
            cols.append(i)
            search(n, cols, result)
            cols.pop()

def NQueensII(n):
    if not n:
        return None
    result = []
    search(n, [], result)
    return len(result)

print NQueensII(4)
