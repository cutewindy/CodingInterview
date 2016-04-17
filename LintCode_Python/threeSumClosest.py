# Given an array S of n integers, find three integers in S such that the sum is
# closest to a given number, target. Return the sum of the three integers.

# Have you met this question in a real interview? Yes
# Example
# For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest
#  to the target is 2. (-1 + 2 + 1 = 2).

# Note
# You may assume that each input would have exactly one solution.

# Challenge
# O(n^2) time, O(1) extra space

import sys

def threeSumClosest(numbers, target):
    if not numbers or len(numbers) < 3:
        return None
    numbers.sort()
    n = len(numbers)
    result = sys.maxint
    for i in range(n - 2):
        left = i + 1
        right = n - 1
        while left < right:
            sums = numbers[i] + numbers[left] + numbers[right]
            if sums == target:
                return sums
            elif sums < target:
                left += 1
            else:
                right -= 1
            if abs(sums - target) < abs(result - target):
                result = sums

    return result


# print threeSumClosest([-1, 2, 1, -4], 1)
# print threeSumClosest([-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5], 45)
print threeSumClosest([-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5], 77)
