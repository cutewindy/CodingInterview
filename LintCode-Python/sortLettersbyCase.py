# Given a string which contains only letters. Sort it by lower case first and
# upper case second.

# Have you met this question in a real interview? Yes
# Example
# For "abAcD", a reasonable answer is "acbAD"

# Note
# It's NOT necessary to keep the original order of lower-case letters and upper
# case letters.

# Challenge
# Do it in one-pass and in-place.



def sortLettersbyCase(chars):
    if not chars:
        return None

    left = 0
    right = len(chars) - 1
    while left < right:
        if chars[left].isupper():
            chars[left], chars[right] = chars[right], chars[left]
            right -= 1
        else:
            left += 1
    return chars


print sortLettersbyCase(['a', 'b', 'A', 'c', 'D'])



