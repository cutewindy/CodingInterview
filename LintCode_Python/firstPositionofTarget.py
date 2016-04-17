# For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

# If the target number does not exist in the array, return -1.

# Have you met this question in a real interview? Yes
# Example
# If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

# Challenge
# If the count of numbers is bigger than 2^32, can your code work properly?

def firstPositionofTarget(nums, target):
    if not nums or (target == None):
        return -1
    start = 0
    end = len(nums) - 1
    while start + 1 < end:
        mid = start + (end - start) / 2
        if nums[mid] < target:
            start = mid
        else:
            end = mid
    if nums[start] == target:
        return start
    elif nums[end] == target:
        return end
    return -1


print firstPositionofTarget([0, 1, 2, 3, 3, 4, 5, 10], 3)
