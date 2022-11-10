class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        
        p = {}
        
        def find(x):
            if x not in p.keys(): p[x] = x
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            xp, yp = find(x), find(y)
            p[xp] = yp
        
        for s in equations:
            if s[1] == "=":
                union(s[0], s[-1])
        
        for s in equations:
            if s[1] == "!" and find(s[0]) == find(s[-1]): return False
        
        return True