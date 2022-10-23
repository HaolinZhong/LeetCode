class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0: return 0
        
        d = defaultdict(int)
        max_len = 1
        l, r = 0, 0
        
        while r < len(s):
            while r < len(s) and d[s[r]] == 0:
                d[s[r]] += 1
                r += 1
            
            max_len = max(max_len, r - l)
            if r == len(s): break
            d[s[r]] += 1
            
            while d[s[r]] > 1 and l <= r:
                d[s[l]] -= 1
                l += 1
            
            r += 1
        
        return max_len