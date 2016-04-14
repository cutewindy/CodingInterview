# Given a list of words and an integer k, return the top k frequent words in the
# list.

# Have you met this question in a real interview? Yes
#  Notice

# You should order the words by the frequency of them in the return list, the most
#  frequent one comes first. If two words has the same frequency, the one with
#  lower alphabetical order come first.

# Example
# Given

# [
#     "yes", "lint", "code",
#     "yes", "code", "baby",
#     "you", "baby", "chrome",
#     "safari", "lint", "code",
#     "body", "lint", "code"
# ]
# for k = 3, return ["code", "lint", "baby"].

# for k = 4, return ["code", "lint", "baby", "yes"],

# Challenge
# Do it in O(nlogk) time and O(n) extra space.

# Extra points if you can do it in O(n) time with O(k) extra space.

# from collections import Counter

def cmp(a, b):
    if a[0] > b[0] or (a[0] == b[0] and a[1] < b[1]):
        return -1
    elif a[0] == b[0] and a[1] == b[1]:
        return 0
    else:
        return 1

def topKFrequentWords(words, k):

    # Method 1:
    # d = dict()
    # for word in words:
    #     if word in d:
    #         d[word] += 1
    #     else:
    #         d[word] = 1
    # # print d
    # result = []
    # count = 0
    # while count < k:
    #     freq = 0
    #     freqWord = "test"
    #     for word in d:
    #         if d[word] > freq or (d[word] == freq and word < freqWord):
    #             freq = d[word]
    #             freqWord = word
    #     del d[freqWord]
    #     result.append(freqWord)
    #     count += 1
    # return result


    # Method 2:
    d = dict()
    for word in words:
        if word in d:
            d[word] += 1
        else:
            d[word] = 1
    p = []
    for key, value in d.items():
        p.append([value, key])
    p.sort(cmp=cmp)
    result = []
    for i in range(k):
        result.append(p[i][1])
    return result



# print topKFrequentWords(["ba","fe","bd","bf","fe","ae","ae","ed","ef","ab",
    # "cd","ac","cf","af","ed","ef","fb","ba","dc","ca","cb","ca","bc","bf","ae",
    # "ec","fa","ac","bd","af","fa","dc","cb","ed","db","fa","cb","fe","ab","bd",
    # "eb","af","ad","cd","bf","bc","cd","fd","de","fc","ef","bc","ca","fe","ac",
    # "ac","cb","eb","ca","fa","bf","ed","cb","ef","be","de","da","bc","ad","cf",
    # "ef","fd","ce","be","df","bf","fd","ef","ab","ef"], 3)
# print Counter(l)
print topKFrequentWords([
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
], 4)
