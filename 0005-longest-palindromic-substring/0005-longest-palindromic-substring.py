class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        res = ""
        
        for i in range(len(s)):
            c = 1
            while i - c >= 0 and i + c < len(s):
                if s[i-c] == s[i+c]: 
                    c += 1
                    continue
                break
            if 2 * c - 1 > len(res): res = s[i-c+1:i+c]
            
            c = 1
            if i < len(s) - 1 and s[i+1] == s[i]:
                while i - c >= 0 and i + 1 + c < len(s):
                    if s[i-c] == s[i + 1 + c]: 
                        c += 1
                        continue
                    break
                
                if 2 * c > len(res): res = s[i-c+1:i+1+c]
            
        
        return res
        
            
                