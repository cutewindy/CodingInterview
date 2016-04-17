# Implement a stack. You can use any data structure inside a stack except stack
# itself to implement it.

# Have you met this question in a real interview? Yes
# Example
# push(1)
# pop()
# push(2)
# top()  // return 2
# pop()
# isEmpty() // return true
# push(3)
# isEmpty() // return false

stack = []

def push(x):
    stack.append(x)

def pop():
    if not stack:
        return None
    else:
        return stack.pop()

def top():
    if not stack:
        return None
    else:
        return stack[-1]

def isEmpty():
    return len(stack) == 0


push(1)
pop()
push(2)
print top()
pop()
print isEmpty()
push(3)
print isEmpty()
