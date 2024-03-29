class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // word1 i   word2 j  equal  num = dp[i - 1][j - 1]
        //init
        for (int i = 1; i <= word1.length(); i++) {
            //j == 0
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        // word1 i-1 == word2 j-1     dp[i][j] = Math.min(dp[i - 1][j]+1, dp[i][j-1]+1, dp[i-1][j-1])     
        //word1 i-1 == word2 j-1     dp[i][j] = Math.min(dp[i - 1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1)
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int temp = 0;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    temp = 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + temp));   
            }
        }
        return dp[word1.length()][word2.length()];
        
    }
}