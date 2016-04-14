# Clone an undirected graph. Each node in the graph contains a label and a list of
# its neighbors.

# How we serialize an undirected graph:

# Nodes are labeled uniquely.

# We use # as a separator for each node, and , as a separator for node label and
# each neighbor of the node.
# As an example, consider the serialized graph {0,1,2#1,2#2,2}.

# The graph has a total of three nodes, and therefore contains three parts as
# separated by #.

# First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
# Second node is labeled as 1. Connect node 1 to node 2.
# Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a
# self-cycle.
# Visually, the graph looks like the following:

#    1
#   / \
#  /   \
# 0 --- 2
#      / \
#      \_/
# Have you met this question in a real interview? Yes
# Example
# return a deep copied graph.

class UndirectedGraphNode:
    def __init__(self, label):
        self.label = label
        self.neighbors = []



class CloneGraph:
    def __init__(self, dict):
        self.dict = {}

    def cloneGraph(self, node):
        if not node:
            return None
        nodes = [node]
        self.dict[node] = UndirectedGraphNode(node.label)
        # clone node
        start = 0
        while start < len(nodes):
            for i in range(len(nodes[start].neighbors)):
                newNode = nodes[start].neighbors[i]
                if newNode not in self.dict:
                    nodes.append(newNode)
                    self.dict[newNode] = UndirectedGraphNode(newNode.label)
            start += 1

        # clone neighbors
        for i in range(len(nodes)):
            newNode = self.dict[nodes[i]]
            for j in range(len(nodes[i].neighbors)):
                newNode.neighbors.append(self.dict[nodes[i].neighbors[j]])

        return self.dict[node]


n0 = UndirectedGraphNode(0)
n1 = UndirectedGraphNode(1)
n2 = UndirectedGraphNode(2)
n0.neighbors = [n1, n2]
n1.neighbors = [n0, n2]
n2.neighbors = [n0, n1, n2]


cG = CloneGraph({})
_n0 = cG.cloneGraph(n0)
print _n0.label, [n.label for n in _n0.neighbors]




















