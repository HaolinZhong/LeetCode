class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # 构建adjacency list
        adjList = [[] for i in range(numCourses)]
        
        for c, pre in prerequisites:
            adjList[c].append(pre)
        
        # 对于图问题, 有两种类型的"来过"
        # visited: 已以该节点为起点进行过搜索; 节点不一定在当前搜索路径中
        # onPath: 节点在当前搜索路径中
        visited = defaultdict(bool)
        onPath = defaultdict(bool)
        self.hasCycle = False
        
        def dfs(i):
            
            # 如果无环, 当前搜索路径中不应当重复出现元素
            # 所以有重复出现说明有环
            if onPath[i]: 
                self.hasCycle = True
                return
            
            # 已搜索过, 剪枝
            if visited[i]: return
            
            # backtrack
            visited[i] = True
            onPath[i] = True
            
            for pre in adjList[i]:
                dfs(pre)
            
            onPath[i] = False
        
        for i in range(numCourses):
            dfs(i)
            if self.hasCycle: return False
        
        return True