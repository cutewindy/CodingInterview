# Count how many 1 in binary representation of a 32-bit integer.

# Have you met this question in a real interview? Yes
# Example
# Given 32, return 1

# Given 5, return 2

# Given 1023, return 9

# Challenge
# If the integer is n bits with m 1 bits. Can you do it in O(m) time?

def countOneinBinary(num):
    if not num:
        return None
    count = 0
    for i in range(32):
        bit = num >> i & 1
        count += bit

    return count

print countOneinBinary(32)
