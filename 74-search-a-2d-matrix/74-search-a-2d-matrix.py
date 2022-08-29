class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        u, d = 0, len(matrix)
        while u < d:
            m = (u + d) // 2
            if matrix[m][0] <= target: u = m + 1
            else: d = m
        
        if u == 0: return False
        
        l, r = 0, len(matrix[0])
        while l < r:
            m = (l + r) // 2
            if matrix[u-1][m] < target: l = m + 1
            else: r = m
        
        if l == len(matrix[0]): return False
        
        return matrix[u-1][l] == target