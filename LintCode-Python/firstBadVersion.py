# The code base version is an integer start from 1 to n. One day, someone
# committed a bad version in the code case, so it caused this version and the
# following versions are all failed in the unit tests. Find the first bad version.

# You can call isBadVersion to help you determine which version is the first
#  bad one. The details interface can be found in the code's annotation part.

# Have you met this question in a real interview? Yes
# Example
# Given n = 5:

# isBadVersion(3) -> false
# isBadVersion(5) -> true
# isBadVersion(4) -> true
# Here we are 100% sure that the 4th version is the first bad version.

# Note
# Please read the annotation in code area to get the correct way to call
# isBadVersion in different language. For example, Java is SVNRepo.isBadVersion(v)

# Challenge
# You should call isBadVersion as few as possible.

def firstBadVersion(n):
    if not n:
        return 0
    start = 1
    end = n
    while start + 1 < end:
        mid = start + (end - start) / 2
        if isBadVersion(mid) == False:
            start = mid
        else:
            end = mid

    if isBadVersion(start):
        return start
    elif isBadVersion(end):
        return end
    else:
        return 0




def isBadVersion(n):
    if n >= 4:
        return True
    else:
        return False


print firstBadVersion(5)
print firstBadVersion(6)
print firstBadVersion(2)
