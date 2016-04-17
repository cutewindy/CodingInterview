# Given a target number, a non-negative integer k and an integer array A
# sorted in ascending order, find the k closest numbers to target in A,
# sorted in ascending order by the difference between the number and target.
#  Otherwise, sorted in ascending order by number if the difference is same.

# Have you met this question in a real interview? Yes
# Example
# Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

# Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

# Challenge
# O(logn + k) time complexity.


class ArrayReader:
    def get(self, index):
        array = [1, 3, 6, 9, 21]
        if index < len(array):
            return array[index]
        else:
            return -1


def searchinaBigArray(reader, target):
    if not reader or target is None:
        return -1
    index = 0
    while reader.get(index) != -1 and reader.get(index) < target:
        index = index * 2 + 1

    start = (index - 1) / 2 + 1
    end = index
    while start + 1 < end:
        mid = start + (end - start) / 2
        if reader.get(mid) == -1:
            end = mid
        elif reader.get(mid) < target:
            start = mid
        else:
            end = mid

    if reader.get(start) == target:
        return start
    elif reader.get(end) == target:
        return end
    else:
        return -1




print searchinaBigArray(ArrayReader(), 21)


