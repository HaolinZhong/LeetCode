class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0: return 0
        
        d = {}
        max_len = 1
        l, r = 0, 0
        
        while r < len(s):
            while r < len(s) and (s[r] not in d.keys() or d[s[r]] < l):
                d[s[r]] = r
                r += 1
            
            max_len = max(max_len, r - l)
            if r == len(s): break
            l = d[s[r]] + 1
            d[s[r]] = r
            r += 1
        
        return max_len