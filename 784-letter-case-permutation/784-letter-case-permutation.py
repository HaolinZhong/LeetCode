class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        cur = []
        ans = []
        
        def dfs(D):
            
            if len(cur) == len(s):
                ans.append("".join(cur))
                return
            
            if (s[D].isalpha()):
                cur.append(s[D].lower())
                dfs(D + 1)
                cur.pop()
                cur.append(s[D].upper())
                dfs(D + 1)
                cur.pop()
            else:
                cur.append(s[D])
                dfs(D+1)
                cur.pop()
        
        dfs(0)
        
        return ans