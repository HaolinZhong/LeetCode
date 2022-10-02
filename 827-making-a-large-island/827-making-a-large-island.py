class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        DIR = [0, 1, 0, -1, 0]
        
        def paint(i, j, color):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != 1: 
                return 0
            grid[i][j] = color
            ans = 1
            for k in range(4):
                ans += paint(i+DIR[k], j+DIR[k+1], color)
            return ans
        
        color = 2
        maxArea = 0
        islandArea = {}
        for i, j in product(range(len(grid)), range(len(grid[0]))):
            if grid[i][j] == 1:
                curArea = paint(i, j, color)
                islandArea[color] = curArea
                maxArea = max(maxArea, curArea)
                color += 1
        
        def getSize(i, j):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == 0:
                return 0
            return islandArea[grid[i][j]]
        
        for i, j in product(range(len(grid)), range(len(grid[0]))):
            if grid[i][j] == 0:
                nbs = set()
                for k in range(4):
                    if i + DIR[k] < 0 or i + DIR[k] >= len(grid) or j + DIR[k+1] < 0 or j + DIR[k+1] >= len(grid[0]) or grid[i+DIR[k]][j+DIR[k+1]] == 0:
                        continue
                    nbs.add(grid[i+DIR[k]][j+DIR[k+1]])
                
                curArea = 1
                for n in nbs:
                    curArea += islandArea[n]
                maxArea = max(maxArea, curArea)
        
        return maxArea