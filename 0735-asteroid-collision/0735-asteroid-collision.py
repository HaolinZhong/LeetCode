from collections import deque

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        s = deque()
        
        for n in asteroids:
            while len(s) > 0 and s[-1] > 0 and n < 0 :
                cur = s.pop()
                if abs(cur) - abs(n) == 0: 
                    n = 0
                    break
                n = cur if abs(cur) > abs(n) else n
            if not n==0: s.append(n)
                
        
        return s