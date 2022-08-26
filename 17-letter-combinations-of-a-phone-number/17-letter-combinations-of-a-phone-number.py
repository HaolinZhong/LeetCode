class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if len(digits) == 0: return []
        
        l2cMap = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        
        ans = []
        cur = []
        
        def getCombs(depth):
            if depth == len(digits):
                ans.append("".join(cur))
                return
            
            for c in l2cMap[digits[depth]]:
                cur.append(c)
                getCombs(depth + 1)
                cur.pop()
        
        getCombs(0)
        
        return ans
            
            