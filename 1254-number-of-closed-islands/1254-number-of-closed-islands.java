class Solution {
    
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] DIR = new int[]{-1, 0, 1, 0, -1};
        int cnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == -1) continue;
                Queue<Integer> q = new LinkedList<>();
                q.add(i * n + j);
                boolean isValid = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int x = cur / n, y = cur % n;
                    grid[x][y] = -1;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + DIR[k], ny = y + DIR[k+1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            isValid = false;
                            continue;
                        } 
                        if (grid[nx][ny] == 0) q.add(nx * n + ny);
                    }
                }
                
                if (isValid) cnt++;
            }
        }
        
        return cnt;
    }
    
}