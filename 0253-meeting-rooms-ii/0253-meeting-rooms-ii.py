from sortedcontainers import SortedList
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        rooms = [[intervals[0][1]]]
        find = True
        for i in range(1, len(intervals)):
            find = False
            for j in range(len(rooms)):
                if intervals[i][0] < rooms[j][-1]:
                    continue
                rooms[j].append(intervals[i][1])
                find = True
                break
            if not find: rooms.append([intervals[i][1]])
        
        return len(rooms)
            
        
        
            
        