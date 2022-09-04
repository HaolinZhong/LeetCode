class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        def canShip(c):
            cur = 0
            T = 1
            for w in weights:
                if cur + w > c:
                    cur = 0
                    T += 1
                    if T > days: return False
                cur += w
            return True
        
        
        l, r = max(weights), sum(weights)
        
        while l < r:
            m = (l + r) // 2
            if canShip(m):
                r = m
            else:
                l = m + 1
        
        return l
        