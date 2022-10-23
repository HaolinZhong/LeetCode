class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        candidates.sort()
        ans = []
        
        def dfs(cur, tar, d):
            if d == len(candidates): return
            for i in range(d, len(candidates)):
                if candidates[i] > tar: break
                if candidates[i] == tar:
                    cur.append(candidates[i])
                    ans.append(list(cur))
                    cur.pop()
                else:
                    cur.append(candidates[i])
                    dfs(cur, tar - candidates[i], i)
                    cur.pop()
            
        dfs([], target, 0)
        
        return ans