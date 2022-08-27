class Solution:
    def numSquarefulPerms(self, nums: List[int]) -> int:
        
        nums.sort()
        
        def checkSq(n):
            return math.sqrt(n).is_integer()
        
        cur = []
        used = defaultdict(bool)
        ans = [0]
        
        def dfs():
            
            if len(cur) == len(nums): 
                ans[0] += 1
                return
            
            for i in range(len(nums)):
                if used[i]: continue
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]: continue
                if len(cur) == 0 or checkSq(cur[-1] + nums[i]):
                    used[i] = True
                    cur.append(nums[i])
                    dfs()
                    cur.pop()
                    used[i] = False
        
        dfs()
        
        return ans[0]