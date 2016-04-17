# Given an array of n objects with k different colors (numbered from 1 to k),
# sort them so that objects of the same color are adjacent, with the colors in
# the order 1, 2, ... k.

# Have you met this question in a real interview? Yes
# Example
# Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to
#  [1, 2, 2, 3, 4].

# Note
# You are not suppose to use the library's sort function for this problem.

# Challenge
# A rather straight forward solution is a two-pass algorithm using counting sort.
# That will cost O(k) extra memory. Can you do it without using extra memory?

import sys

def sortColorsII(colors, k):
    if not colors or not k:
        return None
    left = 0
    right = len(colors) - 1
    count = 0
    while count < k:
        maxColor = -sys.maxint
        minColor = sys.maxint
        for i in range(left, right + 1):
            maxColor = max(colors[i], maxColor)
            minColor = min(colors[i], minColor)
        curr = left
        while curr <= right:
            if colors[curr] == minColor:
                colors[left], colors[curr] = colors[curr], colors[left]
                curr += 1
                left += 1
            elif minColor < colors[curr] and colors[curr] < maxColor:
                curr += 1
            else:
                colors[right], colors[curr] = colors[curr], colors[right]
                right -= 1
        count += 2
    return colors



print sortColorsII([3, 2, 2, 1, 4], 4)









