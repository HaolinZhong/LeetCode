class Solution {
    
    private int[][] mem;
    
    public int minInsertions(String s) {
        mem = new int[s.length()][s.length()];
        Arrays.stream(mem).forEach(a -> Arrays.fill(a, -1));
        return dp(0, s.length()-1, s);
    }
    
    private int dp(int i, int j, String s) {
        if (i >= j) return 0;
        if (mem[i][j] != -1) return mem[i][j];
        
        int ans;
        if (s.charAt(i) == s.charAt(j)) {
            ans = dp(i+1, j-1, s);
        } else {
            ans = Math.min(dp(i, j-1, s), dp(i+1, j, s)) + 1;
        }
        
        mem[i][j] = ans;
        return ans;
    }
}