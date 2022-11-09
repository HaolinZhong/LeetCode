class Solution:
    def minWindow(self, s: str, t: str) -> str:
        window, need = defaultdict(int), defaultdict(int)
        l, r, valid = 0, 0, 0
        
        for c in t: need[c] += 1
        
        minstr = [0, 0]
        minlen = len(s) + 1
        
        while r < len(s):
            c = s[r]
            r += 1
            
            if c in need.keys():
                window[c] += 1
                if window[c] == need[c]:
                    valid += 1
            
            while valid == len(need):
                if (r - l) < minlen:
                    minlen = r - l
                    minstr[0], minstr[1] = l, r
                
                d = s[l]
                l += 1
                if d in need.keys():
                    window[d] -= 1
                    if window[d] == need[d] - 1:
                        valid -= 1
            
        return s[minstr[0]:minstr[1]]
            
            