class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        
        cur = []
        ans = []
        used = defaultdict(bool)
        
        def dfs(depth, L):
            
            if len(cur) == L:
                ans.append(list(cur))
                return
            
            if depth >= len(nums): return
            
            if not (depth > 0 and nums[depth] == nums[depth - 1] and not used[nums[depth-1]]):
                used[nums[depth]] = True
                cur.append(nums[depth])
                
                dfs(depth + 1, L)
                
                cur.pop()
                used[nums[depth]] = False
            
            dfs(depth + 1, L)
        
        for L in range(len(nums) + 1):
            dfs(0, L)
            
        return ans