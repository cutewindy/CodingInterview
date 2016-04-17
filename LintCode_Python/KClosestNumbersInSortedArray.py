# Given a target number, a non-negative integer k and an integer array
# A sorted in ascending order, find the k closest numbers to target in A,
# sorted in ascending order by the difference between the number and target.
# Otherwise, sorted in ascending order by number if the difference is same.

# Have you met this question in a real interview? Yes
# Example
# Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

# Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

# Challenge
# O(logn + k) time complexity.


def KClosestNumberInSortedArray(A, target, k):
    result = []
    if not A or target is None or not k:
        return result

    start = 0
    end = len(A) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if A[mid] < start:
            start = mid
        else:
            end = mid

    while k > 0:
        if start < 0 and end <= len(A) - 1:
            result.append(A[end])
            end += 1
        elif start >= 0 and end > len(A) - 1:
            result.append(A[start])
            start -= 1
        else:
            if abs(A[start] - target) <= abs(A[end] - target):
                result.append(A[start])
                start -= 1
            else:
                result.append(A[end])
                end += 1
        k -= 1
    return result






print KClosestNumberInSortedArray([1, 2, 3], 2, 3)
print KClosestNumberInSortedArray([1, 4, 6, 8], 3, 3)












