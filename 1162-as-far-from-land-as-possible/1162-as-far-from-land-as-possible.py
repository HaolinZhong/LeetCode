class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        
        # 使用BFS, 从所有1出发, 将0重新标记为到最近的1的距离; 最后返回距离值即可
        
        queue = deque([])
        DIR = [0, 1, 0, -1, 0]
        
        # 将所有1存入队列
        
        for i, j in product(range(len(grid)), range(len(grid[0]))):
            if grid[i][j] == 1:
                queue.append([i, j])
        
        if len(queue) == 0: return -1       # 如果没有1就按要求返回-1
        
        # bfs
        
        cnt = -1
        while len(queue) > 0:
            cnt += 1
            for n in range(len(queue)):     # 进行当前队列长度次数的遍历 - 此时的点应该都具有同一distance
                i, j = queue.popleft()
                for k in range(4):
                    nr, nc = i + DIR[k], j + DIR[k+1]
                    if nr < 0 or nr >= len(grid) or nc < 0 or nc >= len(grid[0]) or grid[nr][nc] != 0: continue
                    grid[nr][nc] = cnt + 1 
                    queue.append([nr, nc])
        
        return -1 if cnt == 0 else cnt      # 倘若cnt为0, 则说明第一轮所有1周围读完之后发现没有0, 按要求返回-1
            