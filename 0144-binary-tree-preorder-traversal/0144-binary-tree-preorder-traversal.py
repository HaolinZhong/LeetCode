# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        s = []
        cur = root
        ans = []
        
        while len(s) > 0 or cur != None:
            while cur != None:
                ans.append(cur.val)
                s.append(cur)
                cur = cur.left
            
            cur = s.pop().right
        
        return ans