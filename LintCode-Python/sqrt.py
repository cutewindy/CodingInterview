# Implement int sqrt(int x).

# Compute and return the square root of x.

# Have you met this question in a real interview? Yes
# Example
# sqrt(3) = 1

# sqrt(4) = 2

# sqrt(5) = 2

# sqrt(10) = 3

# Challenge
# O(log(x))


def sqrt(x):

# method2:
    # start = 1
    # end = x
    # while start + 1 < end:
    #     mid = start + (end - start) / 2
    #     if mid * mid <= x:
    #         start = mid
    #     else:
    #         end = mid
    # if end * end <= x:
    #     return end
    # else:
    #     return start


# method1:
    if not x or x == 1:
        return x
    for i in range(x / 2, 0, -1):
        if i * i <= x:
            return i

print sqrt(1)
print sqrt(3)
print sqrt(4)
print sqrt(5)
print sqrt(10)
# print sqrt(999999999)
# print 1
