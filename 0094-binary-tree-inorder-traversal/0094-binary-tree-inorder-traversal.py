# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        s = []
        ans = []
        cur = root
        while len(s) != 0 or cur != None:
            while cur != None:
                s.append(cur)
                cur = cur.left                
            cur = s.pop()
            ans.append(cur.val)
            cur = cur.right
        
        return ans