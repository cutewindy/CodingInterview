# As the title described, you should only use two stacks to implement a queue's
# actions.

# The queue should support push(element), pop() and top() where pop is pop the
# first(a.k.a front) element in the queue.

# Both pop and top methods should return the value of first element.

# Have you met this question in a real interview? Yes
# Example
# push(1)
# pop()     // return 1
# push(2)
# push(3)
# top()     // return 2
# pop()     // return 2
# Challenge
# implement it by two stacks, do not use any other data structure and push, pop and
# top should be O(1) by AVERAGE.

stack1 = []
stack2 = []
def push(number):
    stack1.append(number)

def pop():
    if not stack2:
        while len(stack1) != 0:
            stack2.append(stack1.pop())
    return stack2.pop()

def top():
    if not stack2:
        while len(stack1) != 0:
            stack2.append(stack1.pop())
    return stack2[-1]

push(1)
print pop()
push(2)
push(3)
print top()
print top()

