class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        
        if len(intervals) <= 1: return True
        
        intervals.sort()
        start, end = intervals[0]
        for i in range(1, len(intervals)):
            if intervals[i][0] >= end:
                start, end = intervals[i]
            else:
                return False
        
        return True