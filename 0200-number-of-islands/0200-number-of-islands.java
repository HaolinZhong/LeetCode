class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        int[] DIR = new int[]{-1, 0, 1, 0, -1};
        
        for (int k = 1; k < 5; k++) {
            int ni = i + DIR[k-1];
            int nj = j + DIR[k];
            dfs(grid, ni, nj);
        }
    }
}