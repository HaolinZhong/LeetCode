class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        # 记录可到达的room
        canVisit={}
        
        def dfs(i):
            if i in canVisit.keys(): return
            canVisit[i] = True
            for k in rooms[i]:
                dfs(k)
        
        # 只能进入第一个room
        dfs(0)

        return len(canVisit.keys()) == len(rooms)
        
        