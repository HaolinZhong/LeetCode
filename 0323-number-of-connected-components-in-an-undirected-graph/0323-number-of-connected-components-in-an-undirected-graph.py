class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        self.cnt = n
        
        p = list(range(n))
        
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            xp, yp = find(x), find(y)
            if xp != yp:
                p[xp] = yp
                self.cnt -= 1
        
        
        for x, y in edges:
            union(x, y)
        

        return self.cnt