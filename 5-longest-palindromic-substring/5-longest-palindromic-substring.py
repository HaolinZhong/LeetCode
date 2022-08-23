class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        longestStr = ""
        
        def findLongest(ind):
            l, r = ind - 1, ind + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            oddStr = s[l+1:r]
        
            l, r = ind, ind + 1
            while l >= 0 and r <= len(s) - 1 and s[l] == s[r]:
                l -= 1
                r += 1
            evenStr = s[l+1:r]
            
            return oddStr if len(oddStr) > len(evenStr) else evenStr
                
        for i in range(len(s)):
            curStr = findLongest(i)
            if len(curStr) > len(longestStr):
                longestStr = curStr
        
        return longestStr