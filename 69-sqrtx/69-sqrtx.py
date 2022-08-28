class Solution:
    def mySqrt(self, x: int) -> int:
        
        if x == 0 or x == 1: return x
        
        l, r = 1, x
        while l < r:
            m = (l + r) // 2
            if m ** 2 <= x: l = m + 1
            else: r = m
        
        return l - 1