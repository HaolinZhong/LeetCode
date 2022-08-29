class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        def bs(i):
            l, r = 0, len(matrix[0])
            while l < r:
                m = (l + r) // 2
                if matrix[i][m] < target: l = m + 1
                else: r = m
            
            return l < len(matrix[0]) and matrix[i][l] == target
        
        for i in range(len(matrix)):
            if matrix[i][0] > target or matrix[i][-1] < target: continue
            if bs(i): return True
        
        return False