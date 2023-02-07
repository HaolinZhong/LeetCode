class Solution {
    
    private int[][] mem;
    
    public boolean canPartition(int[] nums) {
        int s = Arrays.stream(nums).sum();
        if (s % 2 == 1) return false;
        this.mem = new int[nums.length][s+1];
        return dp(nums, nums.length-1, s/2);
    }
    
    private boolean dp(int[] nums, int i, int s) {
        if (s == 0) return true;
        if (s < 0) return false;
        if (i == 0) return s == nums[i];
        
        if (this.mem[i][s] == -1) {
            return false;
        } else if (this.mem[i][s] == 1) {
            return true;
        }
        
        boolean res = dp(nums, i-1, s-nums[i]) || dp(nums, i-1, s);
        this.mem[i][s] = res ? 1 : -1;
        return res;
    }
}