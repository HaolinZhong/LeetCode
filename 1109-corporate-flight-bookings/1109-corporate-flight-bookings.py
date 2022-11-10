class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        
        diff = [0] * n
        
        for f, l, st in bookings:
            diff[f-1] += st
            if l < n: diff[l] -= st
        
        res = [diff[0]]
        
        for i in range(1, len(diff)):
            res.append(res[i-1] + diff[i])
        
        return res