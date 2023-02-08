class Solution {
    
    private int[][] mem;
    
    public int longestCommonSubsequence(String text1, String text2) {
        this.mem = new int[text1.length()][text2.length()];
        Arrays.stream(this.mem).forEach(x -> Arrays.fill(x, -1));
        return dp(0, 0, text1, text2);
    }
    
    private int dp(int i, int j, String s1, String s2) {
        if (i == s1.length()) return 0;
        if (j == s2.length()) return 0;
        if (this.mem[i][j] > -1) return this.mem[i][j];
        
        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = dp(i+1, j+1, s1, s2) + 1;
        } else {
            ans = Math.max(dp(i, j+1, s1, s2), dp(i+1, j, s1, s2));
            ans = Math.max(dp(i+1, j+1, s1, s2), ans);
        }
        
        this.mem[i][j] = ans;
        return ans;
    }
}