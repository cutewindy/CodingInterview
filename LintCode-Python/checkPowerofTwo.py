# Using O(1) time to check whether an integer n is a power of 2.

# Have you met this question in a real interview? Yes
# Example
# For n=4, return true;

# For n=5, return false;

# Challenge
# O(1) time


def checkPowerofTwo(n):
    if not n:
        return False
# method2:
    if n & (n - 1) == 0:
        return True
    else:
        return False

# method1:
    # count = 0
    # for i in range(n):
    #     count += n & 1
    #     n = n >> 1
    # if count == 1:
    #     return True
    # else:
    #     return False

print checkPowerofTwo(4)
