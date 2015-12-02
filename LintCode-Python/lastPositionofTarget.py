# Find the last position of a target number in a sorted array.
# Return -1 if target does not exist.

# Have you met this question in a real interview? Yes
# Example
# Given [1, 2, 2, 4, 5, 5].

# For target = 2, return 2.

# For target = 5, return 5.

# For target = 6, return -1.

def lastPositionofTarget(A, target):
    if not A or target is None:
        return -1
    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] <= target:
            start = mid
        else:
            end = mid

    if A[end] == target:
        return end
    elif A[start] == target:
        return start
    else:
        return -1


print lastPositionofTarget([1, 2, 2, 4 ,5, 5], 2)
print lastPositionofTarget([1, 2, 2, 4 ,5, 5], 5)
print lastPositionofTarget([1, 2, 2, 4 ,5, 5], 6)

