# Determine the number of bits required to flip if you want to convert integer n to integer m.

# Have you met this question in a real interview? Yes
# Example
# Given n = 31 (11111), m = 14 (01110), return 2.

# Note
# Both n and m are 32-bit integers.


def flipBits(a, b):
    count = 0
    for i in range(32):
        m = a >> i & 1
        n = b >> i & 1
        count += m ^ n
    return count

print flipBits(31, 14)
