class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        
        cur = []
        ans = []
        
        def dfs(curSum, depth):
            if (curSum == target):
                ans.append(list(cur))
                return
            
            if (depth > len(candidates) - 1): return
            
            for i in range(depth, len(candidates)):
                if candidates[i] + curSum > target: break
                
                if (i > depth) and (candidates[i] == candidates[i-1]): continue
                

                cur.append(candidates[i])
                
                dfs(candidates[i] + curSum, i + 1)
                
                cur.pop()
        
        dfs(0, 0)
        
        return ans