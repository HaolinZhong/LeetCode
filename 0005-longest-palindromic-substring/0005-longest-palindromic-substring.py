class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        def findPalin(l, r):
            while l > -1 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            return s[l+1:r]
        
        maxlen = 0
        maxstr = s[0]
        
        for i in range(len(s)):
            cur1 = findPalin(i, i + 1)
            cur2 = findPalin(i, i)
            cur = cur1 if len(cur1) > len(cur2) else cur2
            if len(cur) > maxlen:
                maxlen = len(cur)
                maxstr = cur
        
        return maxstr