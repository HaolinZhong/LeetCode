class Solution {
    public int[] runningSum(int[] nums) {
        int[] pfSum = new int[nums.length];
        pfSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pfSum[i] = pfSum[i-1] + nums[i];
        }
        return pfSum;
    }
}