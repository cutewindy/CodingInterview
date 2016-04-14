# Given n non-negative integers representing the histogram's bar height where the
# width of each bar is 1, find the area of largest rectangle in the histogram.

# histogram

# Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

# histogram

# The largest rectangle is shown in the shaded area, which has area = 10 unit.

# Have you met this question in a real interview? Yes
# Example
# Given height = [2,1,5,6,2,3],
# return 10.

import sys

def largestRectangleinHistogram(height):
    if not height:
        return 0

    # method1: burst
    # result = -sys.maxint
    # leng = 0
    # heig = 0
    # for start in range(len(height)):
    #     result = max(height[start], result)
    #     heig = height[start]
    #     for end in range(start + 1, len(height)):
    #         leng = end - start + 1
    #         heig = min(height[end], heig)
    #         result = max(leng * heig, result)
    # return result

    # method2:
    if not height:
        return 0
    stack = []
    result = 0
    for i in range(len(height) + 1):
        curr = -1 if i == len(height) else height[i]
        while stack != [] and curr <= height[stack[len(stack) - 1]]:
            h = height[stack.pop()]
            w = (i - 1) - 0 + 1 if stack == [] else (i - 1) - (stack[len(stack) - 1] + 1) + 1
            result = max(h * w, result)
        stack.append(i)
    return result


print largestRectangleinHistogram([2, 1, 5, 6, 2, 3])
