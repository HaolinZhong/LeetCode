class Solution {
    
    private Integer[][] mem;
    
    public int change(int amount, int[] coins) {
        mem = new Integer[coins.length][amount + 1];
        return dp(coins.length-1, amount, coins);
    }
    
    private int dp(int i, int s, int[] coins) {
        if (s == 0) return 1;
        if (i < 0 || s < 0) return 0;
        
        if (mem[i][s] != null) return mem[i][s];
        
        mem[i][s] = dp(i, s - coins[i], coins) + dp(i-1, s, coins);
        return mem[i][s];
    }
}