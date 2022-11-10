class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans = []
        path = []
        def dfs(cur):
            
            if cur == len(graph) - 1:
                path.append(cur)
                ans.append(list(path))
                path.pop()
                return
            
            path.append(cur)
            for node in graph[cur]:
                dfs(node)
            path.pop()
        
        dfs(0)
        
        return ans