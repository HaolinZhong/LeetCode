class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        need, window = defaultdict(int), defaultdict(int)
        for c in s1: need[c] += 1
        
        l, r, valid = 0, 0, 0
        
        while r < len(s2):
            c = s2[r]
            r += 1
            if c in need.keys():
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            
            while r - l >= len(s1):
                if valid == len(need): return True
                d = s2[l]
                l += 1
                if d in need.keys():
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -= 1
        
        return False