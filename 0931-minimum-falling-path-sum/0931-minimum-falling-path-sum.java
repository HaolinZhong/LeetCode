class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int mins = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curMin = Integer.MAX_VALUE;
                if (i > 0) {
                    for (int c : new int[]{-1, 0, 1}) {
                        if (j+c >= 0 && j+c <= n-1){
                            curMin = Math.min(curMin, matrix[i-1][j+c]);
                        }
                    }
                    matrix[i][j] += curMin;
                }
                
                if (i == m - 1) {
                    mins = Math.min(mins, matrix[i][j]);
                }
            }
        }
        
        return mins;
    }
}