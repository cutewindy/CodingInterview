# Given an array and a value, remove all occurrences of that value in place and return the new length.

# The order of elements can be changed, and the elements after the new length don't matter.

# Have you met this question in a real interview? Yes
# Example
# Given an array [0,4,4,0,0,2,4,4], value=4

# return 4 and front four elements of the array is [0,0,0,2]


def removeElem(A, elem):
    if not A or not elem:
        return A
    pointer = len(A) - 1
    i = 0
    while i <= pointer:
        if A[i] == elem:
            A[i] = A[pointer]
            pointer -= 1
        else:
            i += 1
    return pointer + 1

print removeElem([0, 4, 4, 0, 0, 2 ,4, 4], 4)
