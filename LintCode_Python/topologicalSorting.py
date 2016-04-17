# Given an directed graph, a topological order of the graph nodes is defined as follow:

# For each directed edge A -> B in graph, A must before B in the order list.
# The first node in the order can be any node in the graph with no nodes direct to it.
# Find any topological order for the given graph.

# Have you met this question in a real interview? Yes
#  Notice

# You can assume that there is at least one topological order in the graph.

# Example
# For graph as follow:

# picture

# The topological order can be:

# [0, 1, 2, 3, 4, 5]
# [0, 2, 3, 1, 5, 4]
# ...
# Challenge
# Can you do it in both BFS and DFS?



# Definition for a Directed graph node
class DirectionGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []


class TopologicalSorting:
    def topologicalSorting(self, graph):
        if not graph:
            return None

        d = dict()
        q = []      # queue
        result = []

        # count the in_degree of each node in the graph,
        # except the node with 0 in_degree, since it is not the neighbor of other node
        for node in graph:
            for neighbor in node.neighbors:
                if neighbor in d:
                    d[neighbor] += 1
                else:
                    d[neighbor] = 1

        # find the first node with 0 in_degree, which is not in the dict
        for node in graph:
            if node not in d:
                q.append(node)
                result.append(node)

        # sort the node according to the in_degree
        # (set it's neighbor in_degree minused 1
        # find the node with 0 in_degree, add the node to q and result)
        while q != []:
            node = q.pop(0)
            for neighbor in node.neighbors:
                d[neighbor] -= 1
                if d[neighbor] == 0:
                    q.append(neighbor)
                    result.append(neighbor)

        return result


n0 = DirectionGraphNode(0)
n1 = DirectionGraphNode(1)
n2 = DirectionGraphNode(2)
n3 = DirectionGraphNode(3)
n4 = DirectionGraphNode(4)
n5 = DirectionGraphNode(5)
n0.neighbors = [n1, n2, n3]
n1.neighbors = [n4]
n2.neighbors = [n4, n5]
n3.neighbors = [n5]
graph = [n5, n4, n3, n2, n1, n0]

result = TopologicalSorting().topologicalSorting(graph)
print [node.label for node in result]














