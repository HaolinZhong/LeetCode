class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        def dfs(cur, d, s):
            if len(cur) == s: 
                ans.append(list(cur))
                return
            if d == len(nums): return
            for i in range(d, len(nums)):
                if i > d and nums[i] == nums[i-1]: continue
                cur.append(nums[i])
                dfs(cur, i+1, s)
                cur.pop()
        
        for s in range(len(nums) + 1):
            dfs([], 0, s)
        
        return ans