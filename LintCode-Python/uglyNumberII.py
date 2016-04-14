# Ugly number is a number that only have factors 2, 3 and 5.

# Design an algorithm to find the nth ugly number. The first 10 ugly numbers are
# 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

# Have you met this question in a real interview? Yes
#  Notice

# Note that 1 is typically treated as an ugly number.

# Example
# If n=9, return 10.

# Challenge
# O(n log n) or O(n) time.

def uglyNumberII(k):
    if not k:
        return None

    # Method 1
    # count = 1
    # result = 1
    # while count < k:
    #     result += 1
    #     num = result
    #     while num >= 2 and num % 2 == 0:
    #         num /= 2
    #     while num >= 3 and num % 3 == 0:
    #         num /= 3
    #     while num >= 5 and num % 5 == 0:
    #         num /= 5
    #     if num == 1:
    #         count += 1
    # return result

    # Method 2
    result = [1]
    curr = 2
    p2, p3, p5 = 0, 0, 0
    while len(result) < k:
        while 2 * result[p2] < curr:
            p2 += 1
        min2 = 2 * result[p2]
        while 3 * result[p3] < curr:
            p3 += 1
        min3 = 3 * result[p3]
        while 5 * result[p5] < curr:
            p5 += 1
        min5 = 5 * result[p5]
        next = min(min2, min3, min5)
        curr = next + 1
        result.append(next)
    return result[-1]

print uglyNumberII(9)








