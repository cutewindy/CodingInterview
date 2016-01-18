# Merge two given sorted integer array A and B into a new sorted integer array.

# Have you met this question in a real interview? Yes
# Example
# A=[1,2,3,4]

# B=[2,4,5,6]

# return [1,2,2,3,4,4,5,6]

# Challenge
# How can you optimize your algorithm if one array is very large and the other is
# very small?


def mergeSortedArray(A, B):
    if not A and not B:
        return None
    newArray = []
    i = 0
    j = 0
    while i < len(A) and j < len(B):
        if A[i] < B[j]:
            newArray.append(A[i])
            i += 1
        else:
            newArray.append(B[j])
            j += 1

    while i < len(A):
        newArray.append(A[i])
        i += 1
    while j < len(B):
        newArray.append(B[j])
        j += 1

    return newArray


print mergeSortedArray([1, 2, 3, 4], [2, 4, 5, 6])
