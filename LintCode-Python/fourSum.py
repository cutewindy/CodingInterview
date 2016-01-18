# Given an array S of n integers, are there elements a, b, c, and d in S such
# that a + b + c + d = target?

# Find all unique quadruplets in the array which gives the sum of target.

# Have you met this question in a real interview? Yes
# Example
# Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

# (-1, 0, 0, 1)
# (-2, -1, 1, 2)
# (-2, 0, 0, 2)
# Note
# Elements in a quadruplet (a,b,c,d) must be in non-descending order.
# (ie, a <= b <= c <= d)
# The solution set must not contain duplicate quadruplets.

# def fourSum(numbers, target):
#     if not numbers or len(numbers) < 4:
#         return None

def fourSum(numbers, target):
    if not numbers or len(numbers) < 4:
        return None
    numbers = sorted(numbers)
    n = len(numbers)
    result = []
    for i in range(n - 3):
        if i != 0 and numbers[i] == numbers[i - 1]: # to skip duplicate numbers
            continue
        for j in range(i + 1, n - 2):
            if j != i + 1 and numbers[j] == numbers[j - 1]: # to skip duplicate numbers
                continue
            left = j + 1
            right = n - 1
            while left < right:
                if numbers[i] + numbers[j] + numbers[left] + numbers[right] == target:
                    temp = []
                    temp.append(numbers[i])
                    temp.append(numbers[j])
                    temp.append(numbers[left])
                    temp.append(numbers[right])
                    result.append(temp)
                    left += 1
                    right -= 1
                    while left < right and numbers[left] == numbers[left - 1]: # to skip duplicate numbers
                        left += 1
                    while left < right and numbers[right] == numbers[right + 1]: # to skip duplicate numbers
                        right -= 1
                elif numbers[i] + numbers[j] + numbers[left] + numbers[right] < target:
                    left += 1
                else:
                    right -= 1
    return result


print fourSum([1,0,-1,-1,-1,-1,0,1,1,1,2], 2)

# print fourSum([1, 0, -1, 0, -2, 2], 0)

