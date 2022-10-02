class Solution:
    
    
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        def dfs(i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]): 
                return 0
            if grid[i][j] != 1: return 0
            cnt = 0
            if grid[i][j] == 1:
                grid[i][j] = 0
                cnt += 1
                cnt += dfs(i-1, j)
                cnt += dfs(i+1, j)
                cnt += dfs(i, j-1)
                cnt += dfs(i, j+1)
            return cnt
        
        max_area = 0
        
        for i, j in product(range(len(grid)), range(len(grid[0]))):
            cur_area = dfs(i, j)
            if cur_area > max_area: max_area = cur_area
        
        return max_area
                