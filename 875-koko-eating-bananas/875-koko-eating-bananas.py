class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def canEat(k):
            T = 0
            for n in piles:
                T += n // k
                if n % k != 0: T += 1
                if T > h: return False
            return True
        
        l, r = 1, int(1e9)
        
        while l < r:
            m = (l + r) // 2
            if canEat(m):
                r = m
            else:
                l = m + 1
        
        return l
        