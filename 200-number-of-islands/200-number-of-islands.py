class Solution:
    
    def __init__(self):
        self.cnt = 0
    
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]): return
            if grid[i][j] != '1': return
            grid[i][j] = '#'
            dfs(i-1, j)
            dfs(i, j-1)
            dfs(i+1, j)
            dfs(i, j+1)
        
        for i, j in product(range(len(grid)), range(len(grid[0]))):
            if grid[i][j] == '1': 
                self.cnt += 1
                dfs(i, j)
        
        return self.cnt
                