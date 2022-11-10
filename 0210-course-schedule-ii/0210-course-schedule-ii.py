class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        al = [[] for i in range(numCourses)]
        indeg = defaultdict(int)
        for c, pre in prerequisites:
            al[c].append(pre)
            indeg[pre] += 1
        
        q = deque()
        for i in range(numCourses):
            if indeg[i] == 0: q.append(i)
                
        res = deque()
        cnt = 0
        
        while len(q) > 0:
            for i in range(len(q)):
                cur = q.popleft()
                res.appendleft(cur)
                cnt += 1
                
                for pre in al[cur]:
                    indeg[pre] -= 1
                    if indeg[pre] == 0: 
                        q.append(pre)
                        
        if cnt != numCourses: return []
        return res
            
        
        
        
                        