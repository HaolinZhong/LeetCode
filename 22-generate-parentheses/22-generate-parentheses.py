class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        stat = [0, 0]
        
        cur = []
        ans = []
        
        def dfs():
            if len(cur) == 2 * n:
                ans.append("".join(cur))
                return
            
            if stat[0] < n:
                stat[0] += 1
                cur.append("(")
                dfs()
                stat[0] -= 1
                cur.pop()
            
            if stat[1] < stat[0] and stat[1] < n:
                stat[1] += 1
                cur.append(")")
                dfs()
                stat[1] -= 1
                cur.pop()
        
        dfs()
        
        return ans