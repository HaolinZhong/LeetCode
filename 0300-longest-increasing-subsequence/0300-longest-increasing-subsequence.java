class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxl = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxl = Math.max(dp[i], maxl);
        }
        
        return maxl;
    }
}