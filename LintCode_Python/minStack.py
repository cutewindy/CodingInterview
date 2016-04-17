# Implement a stack with min() function, which will return the smallest number
# in the stack.

# It should support push, pop and min operation all in O(1) cost.

# Have you met this question in a real interview? Yes
# Example
# push(1)
# pop()   // return 1
# push(2)
# push(3)
# min()   // return 2
# push(1)
# min()   // return 1
# Note
# min operation will never be called if there is no number in the stack.


# class MinStack(object):
#     def __init__(self):
#         self.stack = []
#         self.minStack = []

#     def push(self, number):
#         self.stack.append(number)
#         print self.stack
#         if len(self.minStack) == 0 or number <= self.minStack[-1]:  # optimize minStack
#             self.minStack.append(number)

#         # self.stack.append(number)
#         # if len(self.minStack) == 0 or self.minStack[-1] > number:
#         #     self.minStack.append(number)
#         # else:
#         #     self.minStack.append(self.minStack[-1])

#     def pop(self):
#         if not self.stack or not self.minStack:
#             return
#         if self.stack[-1] == self.minStack[-1]:
#             self.minStack.pop()
#         return self.stack.pop()

#         # self.minStack.pop()
#         # return self.stack.pop()

#     def min(self):
#         return self.minStack[-1]

#     push(1)
#     push(2)
#     # print stack
#     # print pop()



stack = []
minStack = []

def push(number):
    stack.append(number)
    if len(minStack) == 0 or number <= minStack[-1]:  # optimize minStack
        minStack.append(number)

    # self.stack.append(number)
    # if len(self.minStack) == 0 or self.minStack[-1] > number:
    #     self.minStack.append(number)
    # else:
    #     self.minStack.append(self.minStack[-1])

def pop():
    if not stack or not minStack:
        return
    if stack[-1] == minStack[-1]:
        minStack.pop()
    return stack.pop()

    # self.minStack.pop()
    # return self.stack.pop()

def min():
    return minStack[-1]

push(1)
print pop()
push(2)
push(3)
print min()
push(1)
print min()

