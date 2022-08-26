class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        
        ans = []
        cur = []
        
        def dfs(curSum, depth):
            if (curSum == target): 
                ans.append(list(cur))
                return
            for i in range(depth, len(candidates)):
                if curSum + candidates[i] > target: break
                cur.append(candidates[i])
                dfs(curSum + candidates[i], i)
                cur.pop()
        
        dfs(0, 0)
        
        return ans