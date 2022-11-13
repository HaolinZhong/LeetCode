class Solution:
    def countOdds(self, low: int, high: int) -> int:
        length = high - low + 1

        if length % 2 == 0:
            return length // 2
        
        
        if low % 2 == 1: length += 1
        
        return length // 2