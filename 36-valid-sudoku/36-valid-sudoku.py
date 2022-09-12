class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        d = {}
        
        def subboxInd(i, j):
            iLevel, jLevel = i // 3, j // 3
            return iLevel * 3 + jLevel
        
        for i, j in product(range(len(board)), range(len(board))):
            cur = board[i][j]
            if cur == ".": continue
            if cur not in d.keys(): d[cur] = [[False]*9, [False]*9, [False]*9]
            rowCond, colCond, subCond = d[cur]
            subBoxInd = subboxInd(i, j)
            if rowCond[i] or colCond[j] or subCond[subBoxInd]: return False
            rowCond[i] = True
            colCond[j] = True
            subCond[subBoxInd] = True
        
        return True
            