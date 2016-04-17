# Implement a stack by two queues. The queue is first in first out (FIFO).
# That means you can not directly pop the last element in a queue.

# Have you met this question in a real interview? Yes
# Example
# push(1)
# pop()
# push(2)
# isEmpty() // return false
# top() // return 2
# pop()
# isEmpty() // return true


class Stack:
    def __init__(self):
        self.q1 = []
        self.q2 = []

    def push(self, x):
        self.q1.append(x)

    def pop(self):
        while len(self.q1) > 1:
            self.q2.append(self.q1.pop(0))
        self.q1 = self.q2
        self.q2 = []

    def top(self):
        while self.q1:
            result = self.q1.pop(0)
            self.q2.append(result)
        self.q1 = self.q2
        self.q2 = []
        return result

    def isEmpty(self):
        return len(self.q1) == 0

s = Stack()
s.push(1)
s.pop()
s.push(2)
print s.isEmpty()
print s.top()
s.pop()
print s.isEmpty()









