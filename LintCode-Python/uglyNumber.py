# Write a program to check whether a given number is an ugly number`.

# Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
# For example, 6, 8 are ugly while 14 is not ugly since it includes another prime
# factor 7.

# Have you met this question in a real interview? Yes
#  Notice

# Note that 1 is typically treated as an ugly number.

# Example
# Given num = 8 return true
# Given num = 14 return false


def uglyNumber(num):
    if num <= 0:
        return False
    while num >= 2 and num % 2 == 0:
        num /= 2
    while num >= 3 and num % 3 == 0:
        num /= 3
    while num >= 5 and num % 5 == 0:
        num /= 5
    return num == 1

print uglyNumber(8)

