class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        cur = []
        ans = []
        
        def dfs(depth, L):
            if len(cur) == L:
                ans.append(list(cur))
                return
            
            if depth >= len(nums): return
            
            cur.append(nums[depth])
            dfs(depth + 1, L)
            cur.pop()
            dfs(depth + 1, L)
        
        for L in range(len(nums) + 1):
            dfs(0, L)
        
        return ans
            
            
            