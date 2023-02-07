class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        int k = 1;
        int x = 0; int y = 0;
        int m = matrix.length; int n = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();
        
        while (ans.size() < m*n) {
            ans.add(matrix[x][y]);
            matrix[x][y] = 101;
            int nx = x + DIR[k-1]; int ny = y + DIR[k];
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] != 101)) {
                k = (k + 1) % 5;
                if (k == 0) k++;
                nx = x + DIR[k-1]; ny = y + DIR[k];
            }
            x = nx; y = ny;
        }
        
        return ans;
    }
}