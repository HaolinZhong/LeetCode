# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        self.max_d = 0
        
        def dfs(d, cur):
            if cur == None: return
            if d == self.max_d:
                self.sum += cur.val
            elif d > self.max_d:
                self.max_d = d
                self.sum = cur.val
            
            dfs(d+1, cur.left), dfs(d+1, cur.right)
        
        dfs(0, root)
        
        return self.sum
            
            