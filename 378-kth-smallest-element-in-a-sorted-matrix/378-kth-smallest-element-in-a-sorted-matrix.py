class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        def getSmaller(n):
            S = 0
            for row in matrix:
                if row[0] > n: break
                if row[-1] < n: 
                    S += len(row)
                    continue
                l, r = 0, len(row)
                while l < r:
                    m = (l + r) // 2
                    if row[m] > n:
                        r = m
                    else:
                        l = m + 1
                S += l
            return S
        
        l, r = matrix[0][0], matrix[-1][-1]
        
        while l < r:
            m = (l + r) // 2
            if getSmaller(m) < k:
                l = m + 1
            else:
                r = m
        
        return l