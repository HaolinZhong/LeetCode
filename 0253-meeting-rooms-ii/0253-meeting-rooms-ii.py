from sortedcontainers import SortedList
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        rooms = SortedList()
        rooms.add(intervals[0][1])
        
        for i in range(1, len(intervals)):
            start, end = intervals[i]
            if start < rooms[0]: 
                rooms.add(end)
            else:
                rooms.pop(0)
                rooms.add(end)
            print(rooms)
        
        return len(rooms)
            
            
        
        
            
        