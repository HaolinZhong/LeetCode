# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        s = []
        ans = deque()
        cur = root
        
        while len(s) > 0 or cur != None:
            while cur != None:
                ans.appendleft(cur.val)
                s.append(cur)
                cur = cur.right
            
            cur = s.pop().left
        
        return ans