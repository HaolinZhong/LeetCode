class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # dfs topological sort
        
        # 创建adjacency list
        al = [[] for i in range(numCourses)]
        for c, pre in prerequisites:
            al[c].append(pre)
        
        
        visit = defaultdict(bool)
        onPath = defaultdict(bool)
        res = []
        
        self.cyclic = False
        
        def dfs(i):
            if onPath[i]:
                self.cyclic = True
                return
            
            if visit[i]: return
            
            visit[i] = True
            onPath[i] = True
            
            for pre in al[i]:
                dfs(pre)
            
            onPath[i] = False
            res.append(i)
        
        for i in range(numCourses):
            dfs(i)
            if self.cyclic: return []
        
        return res
            