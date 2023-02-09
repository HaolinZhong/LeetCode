class Solution {
    
    private Integer[][] mem;
    
    public int longestPalindromeSubseq(String s) {
        mem = new Integer[s.length()][s.length()];
        return dp(0, s.length()-1, s);
    }
    
    private int dp(int i, int j, String s) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (mem[i][j] != null) return mem[i][j];
        
        int ans;
        if (s.charAt(i) == s.charAt(j)) {
            ans = dp(i+1, j-1, s) + 2;
        } else {
            ans = Math.max(dp(i+1, j, s), dp(i, j-1, s));
        }
        
        mem[i][j] = ans;
        return ans;
    }
}