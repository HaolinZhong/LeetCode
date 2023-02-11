class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Integer> q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh ++;
                if (grid[i][j] == 2) q.offer(i*n + j);
            }
        }
        
        
        if (fresh == 0) return 0;
        
        int t = 0;
        int[] DIR = new int[]{-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int s = q.size();
            for (int k = 0; k < s; k++) {
                int cur = q.poll();
                int i = cur / n; int j = cur % n;
                for (int x = 1; x < 5; x++) {
                    int ni = i + DIR[x-1]; int nj = j + DIR[x];
                    // System.out.println(ni);
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                        q.offer(ni*n + nj);
                        grid[ni][nj] = 2;
                        fresh--;
                    }
                }
            }
            if (!q.isEmpty()) t++;
        }
        
        
        
        if (fresh > 0) return -1;
        return t;
    }
}