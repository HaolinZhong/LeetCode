"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        
        if root == None: return []
        
        q = deque()
        q.append(root)
        ans = []
        
        while len(q) > 0:
            l = len(q)
            cur_level = []
            for i in range(l):
                cur = q.popleft()
                cur_level.append(cur.val)
                for child in cur.children:
                    q.append(child)
            ans.append(list(cur_level))
        
        return ans