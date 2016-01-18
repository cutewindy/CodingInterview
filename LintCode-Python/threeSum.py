# Given an array S of n integers, are there elements a, b, c in S such that
# a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

# Have you met this question in a real interview? Yes
# Example
# For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

# (-1, 0, 1)
# (-1, -1, 2)
# Note
# Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)

# The solution set must not contain duplicate triplets.


def threeSum(numbers):
    if not numbers or len(numbers) < 3:
        return None
    numbers = sorted(numbers)
    result = []
    for i in range(len(numbers) - 2):
        if i != 0 and numbers[i] == numbers[i - 1]:  # to skip duplicate numbers
            continue
        left = i + 1
        right = len(numbers) - 1
        while left < right:
            if numbers[i] + numbers[left] + numbers[right] == 0:
                temp = []
                temp.append(numbers[i])
                temp.append(numbers[left])
                temp.append(numbers[right])
                result.append(temp)
                left += 1
                right -= 1
                while left < right and numbers[left] == numbers[left - 1]: # to skip duplicate numbers
                    left += 1
                while left < right and numbers[right] == numbers[right + 1]: # to skip duplicate numbers
                    right -= 1
            elif numbers[i] + numbers[left] + numbers[right] < 0:
                left += 1
            else:
                right -= 1
    return result



print threeSum([-1, 0, 1, 2, -1, -4])
