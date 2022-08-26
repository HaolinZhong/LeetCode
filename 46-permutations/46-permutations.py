class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        used = defaultdict(bool)
        cur, ans = [], []
        
        def dfs():
            
            if len(cur) == len(nums):
                ans.append(list(cur))
                return
            
            for i in range(len(nums)):
                if used[i]: continue
                used[i] = True
                cur.append(nums[i])
                dfs()
                cur.pop()
                used[i] = False
        
        dfs()
        
        return ans