class Solution {
    
    private Integer[][] mem;
    
    public int minDistance(String word1, String word2) {
        int m = word1.length(); int n = word2.length();
        mem = new Integer[m][n];
        return dp(word1, word2, 0, 0);
    }
    
    private int dp(String s1, String s2, int i, int j) {
        int m = s1.length(); int n = s2.length();
        if (i >= m) return n - j;
        if (j >= n) return m - i;

        if (mem[i][j] != null) return mem[i][j];
        
        if (s1.charAt(i) == s2.charAt(j)) {
            mem[i][j] = dp(s1, s2, i+1, j+1);
            return mem[i][j];
        }
        
        // insert at s1
        int op1 = dp(s1, s2, i, j+1) + 1;
        // delete at s1
        int op2 = dp(s1, s2, i+1, j) + 1;
        // replace at s1
        int op3 = dp(s1, s2, i+1, j+1) + 1;
        
        mem[i][j] = Math.min(Math.min(op1, op2), op3);
        return mem[i][j];
    }
}