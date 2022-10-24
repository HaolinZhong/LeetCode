class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        used = defaultdict(bool)
        ans = []
        def dfs(cur):
            if len(cur) == len(nums):
                ans.append(list(cur))
                return
            
            for i in range(len(nums)):
                if used[i]: continue
                if i > 0 and (not used[i-1]) and nums[i] == nums[i-1]: continue
                used[i] = True
                cur.append(nums[i])
                dfs(cur)
                cur.pop()
                used[i] = False
        
        dfs([])
        
        return ans