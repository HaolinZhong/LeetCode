class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:

        cur = []
        ans = []
        
        def dfs(depth, cnt):
            if cnt == k:
                ans.append(list(cur))
                return 
            
            if depth > n: return
            
            cur.append(depth)
            dfs(depth + 1, cnt + 1)
            cur.pop()
            dfs(depth + 1, cnt)
        
        dfs(1, 0)
        
        return ans