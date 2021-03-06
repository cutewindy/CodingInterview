# Write an algorithm which computes the number of trailing zeros in n factorial.

# Have you met this question in a real interview? Yes
# Example
# 11! = 39916800, so the out should be 2

# Challenge
# O(log N) time


def trailingZeros(n):
    if not n:
        return n
    count = 0
    while n != 0:
        count += n / 5
        n /= 5
    return count

print trailingZeros(11)
