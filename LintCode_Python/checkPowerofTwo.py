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
    # if n & (n - 1) == 0:
    #     return True
    # else:
    #     return False

# method1:
    if n < 0:
        return False
    count = 0
    for i in range(32):
        count += n & 1
        n = n >> 1
    return count == 1

print checkPowerofTwo(-238927)
print checkPowerofTwo(512)
