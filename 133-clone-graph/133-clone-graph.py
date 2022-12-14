"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return node
        
        q = deque([node])
        clones = {node.val: Node(node.val)}
        
        while q:
            cur = q.popleft()
            cur_clone = clones[cur.val]
            for n in cur.neighbors:
                if n.val not in clones.keys():
                    clones[n.val] = Node(n.val)
                    q.append(n)
                cur_clone.neighbors.append(clones[n.val])
        
        return clones[node.val]
                
                
            
                