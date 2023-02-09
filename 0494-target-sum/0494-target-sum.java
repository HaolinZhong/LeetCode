class Solution {
    
    private Map<String, Integer> mem;
    
    public int findTargetSumWays(int[] nums, int target) {
        mem = new HashMap<>();
        return dp(nums.length-1, target, nums);
    }
    
    private int dp(int i, int s, int[] nums) {
        if (i == -1) {
            if (s == 0) return 1;
            return 0;
        }
        String key = i + "," + s;
        if (mem.get(key) != null) return mem.get(key);
        mem.put(key, dp(i-1, s - nums[i], nums) + dp(i-1, s + nums[i], nums));
        return mem.get(key);
    }
}