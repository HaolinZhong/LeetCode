class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        
        diff = [0] * length
        for s, e, inc in updates:
            diff[s] += inc
            if e+1 < len(diff): diff[e+1] -= inc
        
        res = [diff[0]]
        
        for i in range(1, len(diff)):
            res.append(res[i-1] + diff[i])
        
        return res