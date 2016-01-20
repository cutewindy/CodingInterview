# Given an array nums of integers and an int k, partition the array
# (i.e move the elements in "nums") such that:

# All elements < k are moved to the left
# All elements >= k are moved to the right
# Return the partitioning index, i.e the first index i nums[i] >= k.

# Have you met this question in a real interview? Yes
# Example
# If nums = [3,2,2,1] and k=2, a valid answer is 1.

# Note
# You should do really partition in array nums instead of just counting the
# numbers of integers smaller than k.

# If all elements in nums are smaller than k, then return nums.length

# Challenge
# Can you partition the array in-place and in O(n)?


def partitionArray(nums, k):
    if not nums or not k:
        return 0

    i = 0
    left = 0
    right = len(nums) - 1
    while i <= right:
        if nums[i] < k:
            nums[i], nums[left] = nums[left], nums[i]
            i += 1
            left += 1
        elif nums[i] == k:
            i += 1
        else:
            nums[i], nums[right] = nums[right], nums[i]
            right -= 1

    return left

print partitionArray([3, 2, 2, 1], 2)
