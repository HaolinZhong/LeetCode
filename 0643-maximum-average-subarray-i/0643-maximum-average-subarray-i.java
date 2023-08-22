class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
                continue;
            }
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - (k - 1); i++) {
            maxSum = Math.max(maxSum, prefixSum[i + k - 1] - prefixSum[i] + nums[i]);
        }
        
        return (double) maxSum / k;
    }
}