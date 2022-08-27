class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        def isValid(s):
            l, r = 0, 0
            for c in s:
                if c == "(": l += 1
                if c == ")": r += 1
                if l < r: return False
            
            return l == r
        
        if isValid(s): return [s]
        
        l, r = 0, 0
        
        for c in s:
            if c == "(": 
                l += 1
            if c == ")": 
                if l > 0:
                    l -= 1
                else: 
                    r += 1
        
        sl = list(s)
        ans = []
        
        def dfs(l, r, D):
            
            cur = "".join(sl)
            
            if D == len(sl) and isValid(cur): 
                ans.append(cur)
                return
            
            if D >= len(sl): return
            
            if D > 0 and sl[D] == sl[D - 1]:
                dfs(l, r, D + 1)
                return
            
            if l > 0 and sl[D] == "(":
                sl[D] = ""
                dfs(l-1, r, D + 1)
                sl[D] = "("
                
            if r > 0 and sl[D] == ")":
                sl[D] = ""
                dfs(l, r-1, D + 1)
                sl[D] = ")"
            
            dfs(l, r, D + 1)
            
            return
        
        dfs(l, r, 0)
        
        return ans
            
            
            
            
            
            