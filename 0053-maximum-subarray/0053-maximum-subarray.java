class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        
        // curSum: 必须包括i, 以其为终点的所有subarray中最优的subarray
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum < 0 ? nums[i] : curSum + nums[i];
            maxSum = maxSum < curSum ? curSum : maxSum;
        }
        
        return maxSum;
    }
}