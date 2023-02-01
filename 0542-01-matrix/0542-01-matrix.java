class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; int n = mat[0].length;
        int[] DIR = new int[]{-1, 0, 1, 0, -1};
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int v = 1;
        while (!q.isEmpty()) {
            int iter = q.size();
            for (int x = 0; x < iter; x++) {
                int[] curCell = q.poll();
                int i = curCell[0]; int j = curCell[1];
                for (int k = 1; k < 5; k++) {
                    if (isValid(i+DIR[k-1], j+DIR[k], mat, visited)) {
                        mat[i+DIR[k-1]][j+DIR[k]] = v;
                        q.add(new int[]{i+DIR[k-1], j+DIR[k]});
                        visited[i+DIR[k-1]][j+DIR[k]] = true;
                    }
                }
            }
            v += 1;
        }
        
        return mat;
    }
    
    private boolean isValid(int i, int j, int[][] mat, boolean[][] visited) {
        return (0 <= i && i < mat.length) && (0 <= j && j < mat[0].length) && (!visited[i][j]);
    }
}