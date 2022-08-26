class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        M =  min(k * (k + 1) // 2, 9)
        
        if n < M: return []
        
        cur = []
        ans = []
        
        def dfs(D, curSum):
            
            if curSum == n and len(cur) == k: 
                ans.append(list(cur))
                return
            
            if D > 9: return
            
            cur.append(D)
            dfs(D + 1, curSum + D)
            cur.pop()
            dfs(D + 1, curSum)
        
        dfs(1, 0)
        
        return ans