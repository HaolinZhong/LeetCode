class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        
        visited = [False for i in range(len(isConnected))]
        
        def dfs(i):
            for j in range(len(isConnected[0])):
                if isConnected[i][j] == 1 and not visited[j]:
                    visited[j] = True
                    dfs(j)
        
        cnt = 0
        
        for i in range(len(isConnected)):
            if not visited[i]:
                cnt += 1
                dfs(i)
        
        return cnt