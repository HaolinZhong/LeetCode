class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, amount + 1);
        mem[0] = 0;
        
        for (int i = 0; i < amount+1; i++) {
            for (int n : coins) {
                if (i >= n) {
                    mem[i] = Math.min(mem[i], mem[i-n] + 1);
                }
            }
        }
        
        return mem[amount] > amount? -1 : mem[amount];
    }
}