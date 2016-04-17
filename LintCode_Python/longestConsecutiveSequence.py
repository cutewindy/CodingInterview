# Given an unsorted array of integers, find the length of the longest consecutive
# elements sequence.

# Have you met this question in a real interview? Yes
# Example
# Given [100, 4, 200, 1, 3, 2],
# The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

# Clarification
# Your algorithm should run in O(n) complexity.


def longestConsecutiveSequence(num):
    if not num:
        return None
    s = set()
    for key in num:
        s.add(key)
    result = 0
    for key in num:
        # count = 1
        up = key + 1
        while up in s:
            s.remove(up)
            # count += 1
            up += 1
        down = key - 1
        while down in s:
            s.remove(down)
            # count += 1
            down -= 1
        result = max(up - down - 1, result)
    return result

print longestConsecutiveSequence([100, 4, 200, 1, 3, 2])
