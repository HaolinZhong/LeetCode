class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color: return image
        
        def dfs(i, j, init):
            if i < 0 or i >= len(image) or j < 0 or j >= len(image[0]): return
            if image[i][j] == init:
                image[i][j] = color
                dfs(i-1, j, init)
                dfs(i+1, j, init)
                dfs(i, j-1, init)
                dfs(i, j+1, init)
        

        dfs(sr, sc, image[sr][sc])
        
        return image