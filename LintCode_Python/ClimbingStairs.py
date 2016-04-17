# You are climbing a stair case. It takes n steps to reach to the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you
# climb to the top?

# Have you met this question in a real interview? Yes
# Example
# Given an example n=3 , 1+1+1=2+1=1+2=3

# return 3

def climbStairs(n):
    if not n:
        return 0
    if n == 1 or n == 2:
        return n

    # init
    result = 0
    last = 1
    lastLast = 2

    # func
    for i in range(2, n):
        result = last + lastLast
        last = lastLast
        lastLast = result

    # answer
    return result




print climbStairs(3)
