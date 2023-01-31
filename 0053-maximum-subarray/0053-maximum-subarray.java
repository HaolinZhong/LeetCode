class Solution {
    public int maxSubArray(int[] nums) {
        int[] pfSum = new int[nums.length + 1];
        pfSum[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            pfSum[i] = nums[i-1] + pfSum[i-1];
        }
        
        int[] leftMin = new int[nums.length + 1];
        int lmin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (pfSum[i] < lmin) lmin = pfSum[i];
            leftMin[i] = lmin;
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length + 1; i++) {
            maxSum = pfSum[i] - leftMin[i-1] > maxSum ? pfSum[i] - leftMin[i-1] : maxSum;
        }
        
        return maxSum;
        
    }
}