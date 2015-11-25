# For a given source string and a target string,
# you should output the first index(from 0) of target string in source string.

# If target does not exist in source, just return -1.

# Have you met this question in a real interview? Yes
# Example
# If source = "source" and target = "target", return -1.

# If source = "abcdabcdefg" and target = "bcd", return 1.

# Challenge
# O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

def strStr(source, target):
    if source == None or target == None:
        return -1
    if target == "":
        return 0
    for i in range(len(source)):
        for j in range(len(target)):
            if i + j >= len(source):
                return -1
            if source[i + j] != target[j]:
                break
        else:
            return i
    return -1




print strStr("abcdabcdefg", "bcd")
print strStr("abcdabcdefg", "g")
print strStr("3", "332")
