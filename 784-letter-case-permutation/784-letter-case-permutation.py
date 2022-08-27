class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        cur = []
        ans = []
        
        sl = list(s)
        
        def dfs(D):
            
            if D == len(s):
                ans.append("".join(sl))
                return
            
            if (sl[D].isalpha()):
                sl[D] = sl[D].lower()
                dfs(D + 1)
                
                sl[D] = sl[D].upper()
                dfs(D + 1)
                
            else:
                dfs(D+1)
        
        dfs(0)
        
        return ans