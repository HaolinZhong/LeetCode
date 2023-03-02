class Solution {
    
    public int[][] mem;
    
    // first dimension: day
    // second dimension: has stock (at the end of the day)
    // value: maximum profit
    
    public int maxProfit(int[] prices) {
        mem = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            
            // base case
            if (i == 0) {
                mem[i][0] = 0;          // has no stock at day 0, profit = 0
                mem[i][1] = -prices[i]; // has stock at day 0, profit = - prices[0]
                continue;
            }
            
            mem[i][0] = Math.max(mem[i-1][0],  // yesterday has no stock + do nothing today
                                 mem[i-1][1] + prices[i]); // yesterday has stock, sell today
            mem[i][1] = Math.max(- prices[i],  // yesterday has no stock, buy today
                                mem[i-1][1]);  // yesterdat has stock, do nothing today
        }
        
        return mem[prices.length-1][0];   // the last day, and stock has been sold
    }
    
}