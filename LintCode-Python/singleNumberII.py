# Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

# Have you met this question in a real interview? Yes
# Example
# Given [1,1,2,3,3,3,2,2,4,1] return 4

# Challenge
# One-pass, constant extra space.


def singleNumberII(A):
    if not A:
        return None
    bits = [0 for i in range(32)]
    result = 0
    for i in range(len(bits)):             # i stand for bit
        for j in range(len(A)):            # j stand for number
            bits[i] += (A[j] >> i) & 1     # add the ith bits
        bits[i] %= 3                       # bits[i]=bits[i]%3  if the ith bits appears three times, bits[i]=0
        result |= bits[i] << i             # change the single number from binary to decimal
    return result

print singleNumberII([1, 1, 2, 3, 3, 3, 2, 2, 4, 1])
