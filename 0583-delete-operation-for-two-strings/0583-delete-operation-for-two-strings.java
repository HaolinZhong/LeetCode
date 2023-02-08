class Solution {
    
    private int[][] mem;
    
    public int minDistance(String word1, String word2) {
        mem = new int[word1.length()][word2.length()];
        Arrays.stream(mem).forEach(x -> Arrays.fill(x, -1));
        return dp(0, 0, word1, word2);
    }
    
    private int dp(int i, int j, String s1, String s2) {
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if (mem[i][j] != -1) return mem[i][j];
        
        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = dp(i+1, j+1, s1, s2);
        } else {
            ans = Math.min(dp(i+1, j, s1, s2) + 1, dp(i, j+1, s1, s2) + 1);
            ans = Math.min(dp(i+1, j+1, s1, s2) + 2, ans);
        }
        
        mem[i][j] = ans;
        return ans;
    }
}