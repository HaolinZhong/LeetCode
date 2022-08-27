class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def dfs(i, j, D):
            if D == len(word): return True
            
            outbound = i < 0 or i >= len(board) or j < 0 or j >= len(board[0])
            
            if outbound or board[i][j] != word[D]: return False
            
            cur = board[i][j]
            board[i][j] = " "
            ans = dfs(i-1, j, D+1) or dfs(i+1, j, D+1) or dfs(i, j-1, D+1) or dfs(i, j+1, D+1)
            board[i][j] = cur
        
            return ans
        
        for i, j in product(range(len(board)), range(len(board[0]))):
            if dfs(i, j, 0): return True
        
        return False
            
        
            