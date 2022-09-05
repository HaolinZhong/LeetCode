class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        
        def getSmaller(x):
            S = 0
            for i in range(1, m + 1):
                if i > x: 
                    break
                else:
                    S += min(n, x // i)
            return S
        
        
        
        l, r = 1, m * n
        
        while l < r:
            mid = (l + r) // 2
            if getSmaller(mid) < k:
                l = mid + 1
            else:
                r = mid
        
        return l