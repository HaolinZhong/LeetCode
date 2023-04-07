class Solution {
    
    boolean touchGround = false;
    int[] DIR = new int[]{-1, 0, 1, 0, -1};
    
    public int numEnclaves(int[][] grid) {
        int cnt = 0;
        int cur = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) continue;
                touchGround = false;
                cur = dfs(grid, i, j);
                if (!touchGround) cnt += cur;
            }
        }
        return cnt;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            touchGround = true;
            return 0;
        }
        
        if (grid[i][j] == 0 || grid[i][j] == -1) return 0;
        int res = 1;
        grid[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int ni = i + DIR[k], nj = j + DIR[k+1];
            res += dfs(grid, ni, nj);
        }
        return res;
    }
}