class TreeNode(object):
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    # def arrayToTree()
    def printTreebyBFS(self, root):
        if root == None:
            return

        print root.val


